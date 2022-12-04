import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import { ContractService } from '../service/contract.service';
import {EmployeeService} from "../service/employee.service";
import {CustomerService} from "../service/customer.service";
import {FacilityService} from "../service/facility.service";
import {Customer} from "../model/customer";
import {Facility} from "../model/facility";
import {Employee} from "../model/employee";
import {Contract} from "../model/contract";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  customerList: Customer[] = [];
  facilityList: Facility[] = [];
  employeeList: Employee[] = [];

  contractATBE: Contract;

  rfContractEdit: FormGroup;

  contractEditId: number;

  constructor(
    private activatedRoute: ActivatedRoute,
    private contractService: ContractService,
    private formBuilder: FormBuilder,
    private employeeService: EmployeeService,
    private customerService: CustomerService,
    private facilityService: FacilityService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.contractEditId = params.id;
    })

    this.getEditContractForm(this.contractEditId);

    this.getCustomerList();
    this.getEmployeeList();
    this.getFacilityList();
  }


  getEditContractForm(productId: number){
    this.contractService.getContractById(productId).subscribe(contractEdit => {
      this.contractATBE = contractEdit;
      this.rfContractEdit = this.formBuilder.group({
        id: [this.contractATBE.id],
        customer: [this.contractATBE.customer, [Validators.required]],
        employee: [this.contractATBE.employee, [Validators.required]],
        facility: [this.contractATBE.facility, [Validators.required]],
        startDate: [this.contractATBE.startDate, [Validators.required]],
        endDate: [this.contractATBE.endDate, [Validators.required]],
        deposit: [this.contractATBE.deposit, [Validators.required]],
      })
    })
  }

  getCustomerList() {
    this.customerService.getCustomerList().subscribe(customerList => {
      this.customerList = customerList;
    })
  }

  getEmployeeList() {
    this.employeeService.getEmployeeList().subscribe(employeeList => {
      this.employeeList = employeeList;
    })
  }

  getFacilityList() {
    this.facilityService.getFacilityList().subscribe(facilityList => {
      this.facilityList = facilityList;
    })
  }

  edit() {
    this.contractService.edit(this.rfContractEdit.value).subscribe(data => {
      this.toastr.success('Contract champion successfully!')
      this.router.navigateByUrl('list')
    });
  }
}
