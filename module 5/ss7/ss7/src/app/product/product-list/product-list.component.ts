import {Component, OnInit} from '@angular/core';
import {ProductServiceService} from "../../service/product-service.service";
import {Product} from "../../model/product";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productList: Product[];
  categoryList: Category[];

  constructor(
    private productService: ProductServiceService,
    private categoryService: CategoryService
  ) {
  }

  ngOnInit(): void {
    this.getAll();
    // this.getAllCategory();
  }

  getAll() {
    this.productService.getAll().subscribe(productList => {
      this.productList = productList;
      console.log(this.productList)
    })
  }

  getAllCategory() {
    this.categoryService.getAll().subscribe(categoryList => {
      console.log(this.categoryList)
      this.categoryList = categoryList;
    })
  }

}
