import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {ProductServiceService} from "../../service/product-service.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";
import {CategoryService} from "../../service/category.service";
import {Category} from "../../model/category";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  rfProductEdit: FormGroup;
  productId: number;
  categoryList: Category[];

  constructor(
    private formBuilder: FormBuilder,
    private productService: ProductServiceService,
    private activateRoute: ActivatedRoute,
    private router: Router,
    private categoryService: CategoryService
  ) {
  }

  ngOnInit(): void {
    this.activateRoute.params.subscribe(
      (params: Params) => {
        this.productId = params.productId;
      })

    this.getCategoryList();
    this.getEditProduct(this.productId);

  }

  editProduct() {
    const productEdit = this.rfProductEdit.value;
    this.productService.editProduct(productEdit).subscribe(productEdit => {
      this.router.navigateByUrl('/productList');
    });
  }

  getEditProduct(productId: number) {
    this.productService.findProductById(productId).subscribe(product => {
      this.rfProductEdit = this.formBuilder.group({
        id: [product.id],
        name: [product.name],
        price: [product.price],
        description: [product.description],
        category: [product.category]
      })
    })
  }

  getCategoryList() {
    this.categoryService.getAll().subscribe(categoryList => {
      this.categoryList = categoryList;
    })
  }

}
