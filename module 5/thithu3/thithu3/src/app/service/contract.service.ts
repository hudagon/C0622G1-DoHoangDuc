import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';
import {Contract} from "../model/contract";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getListContract(customerNameSearch: string, employeeNameSearch: string,
                  facilityNameSearch: string): Observable<Contract[]> {

    return this.httpClient.get<Contract[]>(environment.apiUrl + 'contract?customer.id_like=' + customerNameSearch +
      '&employee.id_like=' + employeeNameSearch + '&facility.name_like=' + facilityNameSearch)
  }

  getContractById(contractId: number): Observable<Contract> {
    return this.httpClient.get<Contract>(environment.apiUrl + 'contract/' + contractId);
  }

  deleteContractById(contractId: number): Observable<void> {
    return this.httpClient.delete<void>(environment.apiUrl + 'contract/' + contractId)
  }

  createContract(contractATBC: Contract): Observable<Contract> {
    return this.httpClient.post<Contract>(environment.apiUrl + 'contract/', contractATBC);
  }

  edit(contractABTE: Contract): Observable<Contract> {
    return this.httpClient.put<Contract>(environment.apiUrl + "contract/" + contractABTE.id, contractABTE)
  }
}
