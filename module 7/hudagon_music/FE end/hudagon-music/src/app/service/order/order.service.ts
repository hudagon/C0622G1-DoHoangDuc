import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductOrder } from 'src/app/model/order/product-order';
import { TotalMoney } from 'src/app/payload/request/total-money';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  /* Product order information */
  productOrderId: number;
  totalMoneyUSD: number;
  exchangeRate: number = 23482.44687;

  constructor(
    private httpClient: HttpClient
  ) { }

  getProductOrder(userId: string): Observable<ProductOrder> {
    return this.httpClient.get<ProductOrder>(environment.API_URL + 'api/v1/productOrder/getProductOrder?userId=' + userId);
  }

  addProductToCart(productQuantity: number, productId: number): Observable<any> {
    return this.httpClient.get<any>(environment.API_URL + 'api/v1/productOrder/addProductToCart?productOrderId=' 
    + this.productOrderId + '&productQuantity=' + productQuantity + '&productId=' + productId)
  }

  updateTotalMoney(totalMoney: TotalMoney): Observable<void> {
    return this.httpClient.post<void>(environment.API_URL + 'api/v1/productOrder/updateTotalMoney',  totalMoney);
  }

  updatePaymentStatus(): Observable<void> {
    return this.httpClient.patch<void>(environment.API_URL + 'api/v1/productOrder/updatePaymentStatus', 
    JSON.stringify(this.productOrderId));
  }

  convertVNDToUSD(totalMoneyVND: number){
    console.log('ok');
    this.totalMoneyUSD = +(totalMoneyVND / this.exchangeRate).toFixed(2);
    console.log(this.totalMoneyUSD);
    
  }
  
}
