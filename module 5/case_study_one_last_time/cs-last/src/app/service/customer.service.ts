import {Injectable} from '@angular/core';
import {Customer} from "../model/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  index: number = 0;

  customerList: Customer[] = [
    {
      id: 'KH-0001',
      name: 'Đỗ Hoàng Đức',
      dateOfBirth: '01-11-2000',
      gender: 1,
      idCard: '206395960',
      phoneNumber: '0905123123',
      email: 'amthanhloama@gmail.com',
      customerType: '1',
      address: 'Quang Nam'
    },
    {
      id: 'KH-0002',
      name: 'Lê Trần Thảo Nhi',
      dateOfBirth: '28-12-2000',
      gender: 2,
      idCard: '123456789',
      phoneNumber: '0905123123',
      email: 'nhicute@gmail.com',
      customerType: '1',
      address: 'Hue'
    }
  ];

  constructor() {
  }

  getAll() {
    return this.customerList;
  }

  createCustomer(customerATBC: Customer) {
    this.customerList.push(customerATBC);
  }

  getCustomerById(customerId: string) {
    console.log(customerId);
    for (let x of this.customerList) {
      if (x.id === customerId) {
        return x;
      }
    }
  }

  editCustomer(customerATBE: Customer) {

    for (let i = 0; i < this.customerList.length; i++) {
      if (this.customerList[i].id === customerATBE.id) {
        this.index = i;
      }
    }

    for (let x of this.customerList) {
      if (x.id === customerATBE.id) {
        this.customerList.splice(this.index, 1, customerATBE);
      }
    }
  }
}
