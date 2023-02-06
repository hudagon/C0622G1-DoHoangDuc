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

  /* User information */
  isLogged: boolean = false;

  /* Pagination information */
  totalPages: number = 0;
  currentPage: number = 0;

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
    if(this.tokenService.isLogged()) {
      this.isLogged = true;          
    }

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
      priceRange: this.rfSearch.get('priceRange').value,
    }

    this.productService.searchProduct(productSearchInfomartion).subscribe(data => {
      this.totalPages = data.totalPages;
      this.currentPage = data.pageable.pageNumber;
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
      this.toastr.success("Thêm thành công!")
        document.getElementById("reloadHeaderViewCart").click();
    })
  }

  /* Pop up toastr */
  popUpMess(status: string, mess: string) {
    switch (status) {
      case '1': 
      this.toastr.success(mess);
      case '2':
      this.toastr.info(mess);
      case '3':
      this.toastr.warning(mess);
      case '4':
      this.toastr.error(mess);
    }
  }

  /* Pagination methods */
  toPage(page: string) {
    this.productService.pageNumber = page;
    this.searchProduct();
  }

  previousPage() {
    this.productService.pageNumber = JSON.stringify(+this.productService.pageNumber - 1);
    this.searchProduct();
  }

  nextPage() {
    this.productService.pageNumber = JSON.stringify(+this.productService.pageNumber + 1);
    this.searchProduct();
    console.log(this.productService.pageNumber);
    console.log(this.totalPages);
  }

}
