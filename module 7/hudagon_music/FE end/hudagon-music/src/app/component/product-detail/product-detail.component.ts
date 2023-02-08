import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/model/product/product';
import { ProductDetailInfo } from 'src/app/payload/response/product-detail-info';
import { ProductService } from 'src/app/service/product/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  /* Product information */
  productId: string;
  currentProduct: Product;
  productListImgShown: string[] = new Array();
  productDetailInfoList: ProductDetailInfo[];

  constructor(
    private activatedRoute: ActivatedRoute,
    private productService: ProductService
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.productId = params.productId;
    })

    this.getProductById();
  }

  getProductById() {
    this.productService.getProductById(this.productId).subscribe(data => {
      this.currentProduct = data.product;
      this.productDetailInfoList = data.productOrderDetailDtoList;
      
      this.getProductListImgShown();
    })
  }

  getProductListImgShown() {
    if(this.currentProduct.imgUrlProductList.length < 5) {
      for (let i = 0; i < this.currentProduct.imgUrlProductList.length; i++) {
        this.productListImgShown.push(this.currentProduct.imgUrlProductList[i].url);
      }
    } else {
      for (let i = 0; i < 5; i++) {
        this.productListImgShown.push(this.currentProduct.imgUrlProductList[i].url);
      }
    }
  }

}
