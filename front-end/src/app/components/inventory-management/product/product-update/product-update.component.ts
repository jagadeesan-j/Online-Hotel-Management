import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  product!: Product;
  productID!: string;

  constructor(
    private productService: ProductService,
    private activatedRoute: ActivatedRoute, private router: Router
  ) { }

  ngOnInit(): void {
    this.product = new Product();
    this.productID = this.activatedRoute.snapshot.params['productID'];
    this.productService.getProductByProductID(this.productID).subscribe(data => {
      this.product = data;
    }, error => console.log(error));
  }

  updateProduct(){
    this.productService.updateProduct(this.productID, this.product).subscribe(data => {
      this.product = new Product();
      this.routeToProductList();
    }, error => console.log(error));
  }

  routeToProductList(){
    this.router.navigate(['/inventory/product/list']);
  }

  onSubmit() {
    this.updateProduct();
  }
}
