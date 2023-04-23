import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../category';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categoryList: Category[] = [];

  constructor(private categoryService: CategoryService, private router: Router) { }

  ngOnInit(): void {
    this.getCategoryList();
  }

  private getCategoryList(){
    this.categoryService.getCategoryList().subscribe(data => {
      this.categoryList = data;
      console.log(data);
    });
  }

  updateCategory(categoryID: string){
    this.router.navigate(['/inventory/category/update', categoryID]);
  }

  deleteCategory(categoryID: string){
    this.categoryService.deleteCategory(categoryID).subscribe(data => {
      console.log(data);
      this.router.navigate(['/inventory/category/list']);
    })
  }
}
