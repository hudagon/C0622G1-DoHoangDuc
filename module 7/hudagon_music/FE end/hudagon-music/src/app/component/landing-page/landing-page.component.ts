import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductHomeShow } from 'src/app/dto/product-home-show';
import { Product } from 'src/app/model/product/product';
import { ProductSearchInfo } from 'src/app/payload/request/product-search-info';
import { UserInformation } from 'src/app/payload/response/user-information';
import { ProductService } from 'src/app/service/product/product.service';
import { AuthServiceService } from 'src/app/service/security/auth-service.service';
import { TokenServiceService } from 'src/app/service/security/token-service.service';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  /* Search payload */
  rfSearch: FormGroup;
  productHomeShowList: ProductHomeShow[];

  constructor(
    private productService: ProductService,
    private formBuilder: FormBuilder,
    private authService: AuthServiceService,
    private tokenService: TokenServiceService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getSearchForm();
    this.searchProduct();
  }


  /* Search Form */
  getSearchForm() {
    this.rfSearch = this.formBuilder.group({
      priceRange: ['0-999999999999999999999']
    })
  }
  

  /* Search method */
  searchProduct() {
    const productSearchInfomartion = {
      priceRange: this.rfSearch.get('priceRange').value
    }

    this.productService.searchProduct(productSearchInfomartion).subscribe(data => {
      this.productHomeShowList = data.content;
    })
  }


}
