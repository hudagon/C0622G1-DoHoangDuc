import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Customer} from '../model/customer';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  rfCustomerEdit: FormGroup;
  customerId: string;

  constructor(
    private customerService: CustomerService,
    private formBuilder: FormBuilder,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.customerId = params.customerId;
    });

    this.getEditCustomerForm();
  }

  getEditCustomer(customerId: string): Customer {
    console.log(customerId);
    return this.customerService.getCustomerById(customerId);
  }

  getEditCustomerForm() {
    const customerATBE = this.getEditCustomer(this.customerId);
    console.log(customerATBE);
    this.rfCustomerEdit =  this.formBuilder.group({
      id: [customerATBE.id, [Validators.required,
        Validators.pattern('^KH-[0-9]{4}$')]],

      name: [customerATBE.name, [Validators.required]],

      dateOfbirth: [customerATBE.dateOfBirth, [Validators.required,
        Validators.pattern('^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$')]],

      gender: [customerATBE.gender, [Validators.pattern('^[^0]$')]],

      customerType: [customerATBE.customerType, [Validators.pattern('^[^0]$')]],

      idCard: [customerATBE.idCard, [Validators.required,
        Validators.pattern('^([0-9]{9}|[0-9]{12})$')]],

      phoneNumber: [customerATBE.phoneNumber, [Validators.required,
        Validators.pattern('^([(]84[)][+]90|[(]84[)][+]91|090|091)[0-9]{7}$')]],

      email: [customerATBE.email, [Validators.required,
        Validators.pattern('^[a-zA-Z0-9]+[@]{1}[a-zA-Z0-9]+[.]{1}[a-zA-Z0-9]+$')]],

      address: [customerATBE.address, [Validators.required]],
    })
  }

  edit() {
    const customerATBE = this.rfCustomerEdit.value;
    console.log(customerATBE);
    this.customerService.editCustomer(customerATBE);
    this.router.navigateByUrl('/customerList')
  }
}
