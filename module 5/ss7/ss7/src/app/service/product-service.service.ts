import {Injectable} from '@angular/core';
import {Product} from "../model/product";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService  {

  product: Product;

  constructor(
    private httpClient: HttpClient,
  ) {
  }

  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(environment.apiUrl)
  }

  addNewProduct(newProduct: Product): Observable<Product> {
    return this.httpClient.post<Product>(environment.apiUrl, newProduct);
  }

  findProductById(productId: number): Observable<Product> {
    return this.httpClient.get<Product>(environment.apiUrl + '/' + productId)
  }

  editProduct(productEdit: Product): Observable<Product> {
    return this.httpClient.put<Product>(environment.apiUrl + '/' + productEdit.id, productEdit);
  }

  deleteProduct(productId: number): Observable<void> {
    return this.httpClient.delete<void>(environment.apiUrl + '/' + productId);
  }

}
