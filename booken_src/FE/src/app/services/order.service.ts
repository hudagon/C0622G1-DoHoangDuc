import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root",
})
export class OrderService {
  /* Book order information */
  bookOrderId!: number;
  quantity: number = 1;

  constructor(private httpClient: HttpClient) {}

  addToCart(id: number): Observable<any> {
    return this.httpClient.get<any>(
      environment.API_URL +
        "api/v1/order/addToCart?bookId=" +
        id +
        "&bookOrderId=" +
        this.bookOrderId +
        "&quantity=" +
        this.quantity
    );
  }

  getBookOrder(): Observable<any> {
    return this.httpClient.get<any>(
      environment.API_URL + "api/v1/order/getBookOrder"
    );
  }

  removeFormCart(id: number): Observable<any> {
    return this.httpClient.delete<any>(
      environment.API_URL +
        "api/v1/order/removeFromCart?bookOrderDetailId=" + id
    );
  }
}
