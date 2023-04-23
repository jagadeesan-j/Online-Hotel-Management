import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from './category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseURL = "http://localhost:8085/inventory/category";

  constructor(private httpClient: HttpClient) { }

  getCategoryList(): Observable<Category[]>{
    return this.httpClient.get<Category[]>(`${this.baseURL+'/all'}`)
  }

  addCategory(category: Category): Observable<Object>{
    return this.httpClient.post(`${this.baseURL+'/add'}`, category)
  }

  getCategoryByCategoryID(categoryID: string): Observable<Category>{
    return this.httpClient.get<Category>(`${this.baseURL+'/getByCategoryID/'}${categoryID}`)
  }

  updateCategory(categoryID: string, category: Category): Observable<Object>{
    return this.httpClient.put(`${this.baseURL+'/updateByCategoryID/'}${categoryID}`, category)
  }

  deleteCategory(categoryID: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL+'/deleteByCategoryID/'}${categoryID}`)
  }
}
