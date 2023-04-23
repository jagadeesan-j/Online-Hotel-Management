import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseURL = "http://localhost:8085/inventory/product";

  constructor(private httpClient: HttpClient) { }

  getProductList(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseURL+'/all'}`);
  }

  addProduct(product: Product): Observable<Object>{
    return this.httpClient.post(`${this.baseURL+'/add'}`, product);
  }

  getProductByProductID(productID: string): Observable<Product>{
    return this.httpClient.get<Product>(`${this.baseURL+'/getByProductID/'}${productID}`);
  }

  updateProduct(productID: string, product: Product): Observable<Object>{
    return this.httpClient.put(`${this.baseURL+'/updateByProductID/'}${productID}`, product);
  }

  deleteProduct(productID: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL+'/deleteByProductID/'}${productID}`);
  }
}
