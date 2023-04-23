import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productList: Product[] = [];

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
    this.getProductList();
  }

  private getProductList(){
    this.productService.getProductList().subscribe(data => {
      this.productList = data;
      console.log(data);
    })
  }

  updateProduct(productID: string){
    this.router.navigate(['/inventory/product/update', productID]);
  }

  deleteProduct(productID: string){
    this.productService.deleteProduct(productID).subscribe(data => {
      console.log(data);
      this.router.navigate(['/inventory/product/list']);
    })
  }
}
