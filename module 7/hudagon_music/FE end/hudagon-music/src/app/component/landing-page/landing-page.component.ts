import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ProductHomeShow } from 'src/app/dto/product-home-show';
import { Product } from 'src/app/model/product/product';
import { ProductSearchInfo } from 'src/app/payload/request/product-search-info';
import { ProductService } from 'src/app/service/product/product.service';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  rfSearch: FormGroup;
  productHomeShowList: ProductHomeShow[];

  constructor(
    private productService: ProductService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.searchProduct();
  }

  productSearchInfo: ProductSearchInfo = {
    productName: '',
    categoryId: '-1',
    brandId: '-1',
    priceRange: ''
  }
  
  searchProduct() {
    this.productService.searchProduct(this.productSearchInfo).subscribe(data => {
      this.productHomeShowList = data.content;
    })
  }

}
