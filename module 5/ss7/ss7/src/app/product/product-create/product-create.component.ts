import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ProductServiceService} from "../../service/product-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  rfProduct: FormGroup;

  constructor(
    private _formBuilder: FormBuilder,
    private _productService: ProductServiceService,
    private _router: Router
  ) { }

  ngOnInit(): void {
    this.rfProduct = this._formBuilder.group({
      id: ['1'],
      name: ['2'],
      price: ['3'],
      description: ['4']
    })
  }

  onSubmit() {
    const newProduct = this.rfProduct.value;
    this._productService.addNewProduct(newProduct);
    this._router.navigateByUrl('/productList');
  }

}
