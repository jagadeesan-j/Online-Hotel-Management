import { HttpClient } from '@angular/common/http';
import { Component, HostListener, OnInit } from '@angular/core';
import { OrderService } from './order.service';

declare var Razorpay: any;

@Component({
  selector: 'app-razorpay-gateway',
  templateUrl: './razorpay-gateway.component.html',
  styleUrls: ['./razorpay-gateway.component.css']
})
export class RazorpayGatewayComponent implements OnInit {

  form: any = {};

  constructor(private http: HttpClient,
    private orderService: OrderService) { }

  ngOnInit(): void {
  }

  sayHello() {
    alert("Hello!");
  }

  paymentId!: string;
  error!: string;

  options = {
    "key": "",
    "amount": "",
    "name": "Hotel Management",
    "description": "Payment to Hotel Management",
    "image": "https://www.javachinna.com/wp-content/uploads/2020/02/android-chrome-512x512-1.png",
    "order_id":"",
    "handler": function (response: any){
      var event = new CustomEvent("payment.success",
        {
          detail: response,
          bubbles: true,
          cancelable: true
        }
      );
      window.dispatchEvent(event);
    }
    ,
    "prefill": {
    "name": "",
    "email": "",
    "contact": ""
    },
    "notes": {
    "address": ""
    },
    "theme": {
    "color": "#3399cc"
    }
    };

    onSubmit(): void {
      this.paymentId = '';
      this.error = '';
      this.orderService.createOrder(this.form).subscribe(
      data => {
        this.options.key = data.secretId;
        this.options.order_id = data.razorpayOrderId;
        this.options.amount = data.applicationFee; //paise
        this.options.prefill.name = "Hotel";
        this.options.prefill.email = "hotel@mail.com";
        this.options.prefill.contact = "999999999";

          this.options.image="";
          var rzp1 = new Razorpay(this.options);
          rzp1.open();


        rzp1.on('payment.failed',  (response: { error: { code: any; description: any; source: any; step: any; reason: any; metadata: { order_id: any; payment_id: any; }; }; }) =>{
          // Todo - store this information in the server
          console.log(response);
          console.log(response.error.code);
          console.log(response.error.description);
          console.log(response.error.source);
          console.log(response.error.step);
          console.log(response.error.reason);
          console.log(response.error.metadata.order_id);
          console.log(response.error.metadata.payment_id);
          this.error = response.error.reason;
        }
        );
      }
      ,
      err => {
        this.error = err.error.message;
      }
      );
    }

    @HostListener('window:payment.success', ['$event'])
    onPaymentSuccess(event: { detail: any; }): void {
       console.log(event.detail);
    }
}
