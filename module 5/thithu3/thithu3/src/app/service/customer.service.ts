import { Injectable } from '@angular/core';
import {Customer} from "../model/customer";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getCustomerList(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(environment.apiUrl + 'customer')
  }
}
