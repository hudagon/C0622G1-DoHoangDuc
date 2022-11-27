import {Injectable} from '@angular/core';
import {Customer} from "../model/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  customerList: Customer[] = [
    {
      id: 1,
      name: 'Đỗ Hoàng Đức',
      dateOfBirth: '01/11/2000',
      gender: 1,
      idCard: '206395960',
      phoneNumber: '0766011120',
      email: 'amthanhloama@gmail.com',
      customerType: 'Diamond',
      address: 'Quang Nam'
    },
    {
      id: 2,
      name: 'Lê Trần Thảo Nhi',
      dateOfBirth: '28/12/2000',
      gender: 0,
      idCard: '123456789',
      phoneNumber: '0905123123',
      email: 'nhicute@gmail.com',
      customerType: 'Diamond',
      address: 'Hue'
    }
  ];

  constructor() {
  }

  getAll() {
    return this.customerList;
  }
}
