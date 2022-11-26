import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {ProductServiceService} from "../../service/product-service.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  rfProductEdit: FormGroup;
  productEdit: Product;
  productId: number;

  constructor(
    private formBuilder: FormBuilder,
    private productService: ProductServiceService,
    private activateRoute: ActivatedRoute,
    private router: Router,
  ) {
  }

  ngOnInit(): void {
    this.activateRoute.params.subscribe(
      (params: Params) => {
        this.productId = params.productId;
        this.productEdit = this.productService.findProductById(this.productId)
        console.log(this.productEdit);
      })


    this.rfProductEdit = this.formBuilder.group({
      id: [this.productEdit.id],
      name: [this.productEdit.name],
      price: [this.productEdit.price],
      description: [this.productEdit.description]
    })

  }

  editProduct() {
    const productEdit = this.rfProductEdit.value;
    this.productService.editProduct(productEdit);
    this.router.navigateByUrl('/productList');
  }
}
