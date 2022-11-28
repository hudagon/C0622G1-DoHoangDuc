import { Injectable } from '@angular/core';
import {Contract} from '../model/contract';

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  contractList: Contract[] = [
    {id: 1, startDate: "10/10/2000", endDate: "13/10/2000", deposit: 5000, totalMoney: 10000},
    {id: 2, startDate: "07/02/2012", endDate: "09/02/2012", deposit: 0, totalMoney: 12000},
    {id: 3, startDate: "13/06/2008", endDate: "15/06/2008", deposit: 0, totalMoney: 8000},

  ];

  constructor() { }

  getAll() {
    return this.contractList;
  }
}
