import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../category';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-category-add',
  templateUrl: './category-add.component.html',
  styleUrls: ['./category-add.component.css']
})
export class CategoryAddComponent implements OnInit {

  category: Category = new Category();

  constructor(private categoryService: CategoryService, private router: Router) { }

  ngOnInit(): void {
  }

  addCategory(){
    this.categoryService.addCategory(this.category).subscribe(data => {
      console.log(data);
      this.routeToCategoryList();
    },
    error => console.log(error));
  }

  routeToCategoryList(){
    this.router.navigate(['/inventory/category/list']);
  }

  onSubmit(){
    this.addCategory();
  }
}
