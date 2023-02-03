import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductOrder } from 'src/app/model/order/product-order';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  /* Product order information */
  productOrderId: number;

  constructor(
    private httpClient: HttpClient
  ) { }

  getProductOrder(userId: string): Observable<ProductOrder> {
    return this.httpClient.get<ProductOrder>(environment.APU_URL + 'api/v1/productOrder/getProductOrder?userId=' + userId);
  }

  addProductToCart(productQuantity: number, productId: number): Observable<any> {
    return this.httpClient.get<any>(environment.APU_URL + 'api/v1/productOrder/addProductToCart?productOrderId=' 
    + this.productOrderId + '&productQuantity=' + productQuantity + '&productId=' + productId)
  }
  
}
