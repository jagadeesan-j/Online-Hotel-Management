import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RazorpayGatewayComponent } from './razorpay-gateway.component';

describe('RazorpayGatewayComponent', () => {
  let component: RazorpayGatewayComponent;
  let fixture: ComponentFixture<RazorpayGatewayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RazorpayGatewayComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RazorpayGatewayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
