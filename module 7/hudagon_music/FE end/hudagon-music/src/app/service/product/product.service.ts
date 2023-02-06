import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from "rxjs";
import { ProductHomeShow } from "src/app/dto/product-home-show";
import { ProductSearchInfo } from "src/app/payload/request/product-search-info";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root",
})
export class ProductService {

  /* Search info */
  productSearchNameInfo: string = '';
  productBrandInfo: string = '-1';
  productCategoryInfo: string = '-1';
  productPriceInfo: string = '0-999999999999999999999';
  pageNumber: string = '0';

  constructor(private httpClient: HttpClient) {
  }

  updateProductSearchName(productSearchName: string) {
    this.productSearchNameInfo = productSearchName;
  }

  searchProduct(productSearchInfomartion: ProductSearchInfo): Observable<any> {
    const searchInfo: ProductSearchInfo = {
      productName: this.productSearchNameInfo,
      categoryId: this.productCategoryInfo,
      brandId: this.productBrandInfo,
      priceRange: productSearchInfomartion.priceRange,
      pageSize: '5',
      pageNumber: this.pageNumber
    }
    return this.httpClient.post<any>(environment.APU_URL + "api/v1/product/searchProduct", searchInfo);
  }

}
