import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  rfCustomer: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getCustomerCreateForm();
  }

  getCustomerCreateForm() {
    this.rfCustomer = this.formBuilder.group({
      id: ['', [Validators.required,
                Validators.pattern('^KH-[0-9]{4}$')]],

      name: ['', [Validators.required]],

      dateOfbirth: ['', [Validators.required,
                         Validators.pattern('^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$')]],

      gender: ['0', [Validators.pattern('^[^0]$')]],

      customerType: ['0', [Validators.pattern('^[^0]$')]],

      idCard: ['', [Validators.required,
                    Validators.pattern('^([0-9]{9}|[0-9]{12})$')]],

      phoneNumber: ['', [Validators.required,
                         Validators.pattern('^([(]84[)][+]90|[(]84[)][+]91|090|091)[0-9]{7}$')]],

      email: ['', [Validators.required,
                   Validators.pattern('^[a-zA-Z0-9]+[@]{1}[a-zA-Z0-9]+[.]{1}[a-zA-Z0-9]+$')]],

      address: ['', [Validators.required]],
    })
  }

  create() {
    const customerATBC = this.rfCustomer.value;
    this.customerService.createCustomer(customerATBC);
    this.router.navigateByUrl('/customerList')
  }
}
