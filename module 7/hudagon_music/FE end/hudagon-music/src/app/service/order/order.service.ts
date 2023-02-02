import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductOrder } from 'src/app/model/order/product-order';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getProductOrder(userId: string): Observable<ProductOrder> {
    console.log(userId);
    
    return this.httpClient.get<ProductOrder>(environment.APU_URL + 'api/v1/productOrder/getProductOrder?userId=' + userId);
  }
  
}
