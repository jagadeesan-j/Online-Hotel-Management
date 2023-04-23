import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {

  product: Product = new Product();

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
  }

  addProduct(){
    this.productService.addProduct(this.product).subscribe(data => {
      console.log(data);
      this.routeToProductList();
    },
    error => console.log(error));
  }

  routeToProductList(){
    this.router.navigate(['/inventory/product/list']);
  }

  onSubmit(){
    this.addProduct();
  }
}
