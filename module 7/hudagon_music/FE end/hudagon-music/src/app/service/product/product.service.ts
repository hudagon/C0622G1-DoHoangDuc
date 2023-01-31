import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductSearchInfo } from 'src/app/payload/request/product-search-info';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(
    private httpClient: HttpClient
  ) { }

  searchProduct(productSearchInfo: any): Observable<any> {
    return this.httpClient.post<any>(environment.APU_URL + 'api/v1/product/searchProduct', productSearchInfo);
  }

}
