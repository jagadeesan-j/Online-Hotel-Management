import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../category';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-category-update',
  templateUrl: './category-update.component.html',
  styleUrls: ['./category-update.component.css']
})
export class CategoryUpdateComponent implements OnInit {

  category!: Category;
  categoryID!: string;

  constructor(
    private categoryService: CategoryService,
    private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.category = new Category();
    this.categoryID = this.activatedRoute.snapshot.params['categoryID'];
    this.categoryService.getCategoryByCategoryID(this.categoryID).subscribe(data =>
      {
        this.category = data;
      }, error => console.log(error));
  }

  updateCategory(){
    this.categoryService.updateCategory(this.categoryID, this.category).subscribe(data => {
      this.category = new Category();
      this.routeToCategoryList();
    }, error => console.log(error));
  }

  routeToCategoryList(){
    this.router.navigate(['/inventory/category/list'])
  }

  onSubmit() {
    this.updateCategory();
  }
}
