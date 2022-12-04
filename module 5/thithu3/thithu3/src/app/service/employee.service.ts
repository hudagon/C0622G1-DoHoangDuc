import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Customer} from "../model/customer";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Employee} from "../model/employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getEmployeeList(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(environment.apiUrl + 'employee')
  }
}
