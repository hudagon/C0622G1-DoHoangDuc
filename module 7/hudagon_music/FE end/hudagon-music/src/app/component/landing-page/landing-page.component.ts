import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProductHomeShow } from 'src/app/dto/product-home-show';
import { OrderService } from 'src/app/service/order/order.service';
import { ProductService } from 'src/app/service/product/product.service';
import { AuthServiceService } from 'src/app/service/security/auth-service.service';
import { TokenServiceService } from 'src/app/service/security/token-service.service';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  /* Search payload */
  rfSearch: FormGroup;
  productHomeShowList: ProductHomeShow[];

  /* Add to cart information */
  productQuantity: number = 1;

  constructor(
    private productService: ProductService,
    private formBuilder: FormBuilder,
    private authService: AuthServiceService,
    private tokenService: TokenServiceService,
    private router: Router,
    private orderService: OrderService,
    private toastr: ToastrService
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

  /* Add to cart method */
  addProductQuantity() {
    this.productQuantity = this.productQuantity + 1;
  }

  removeProductQuantity() {
    this.productQuantity = this.productQuantity - 1;
  }

  addProductToCart(productId: number) {
    this.orderService.addProductToCart(this.productQuantity, productId).subscribe(data => {
      this.toastr.success("Adding to cart successfully!")
        document.getElementById("reloadHeaderViewCart").click();
    })
  }

}
