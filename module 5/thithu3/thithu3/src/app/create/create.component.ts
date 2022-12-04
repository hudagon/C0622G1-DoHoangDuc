import {Component, OnInit} from '@angular/core';
import {Customer} from "../model/customer";
import {Facility} from "../model/facility";
import {Employee} from "../model/employee";
import {ContractService} from "../service/contract.service";
import {EmployeeService} from "../service/employee.service";
import {CustomerService} from "../service/customer.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {FacilityService} from "../service/facility.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  rfContract: FormGroup;

  customerList: Customer[] = [];
  facilityList: Facility[] = [];
  employeeList: Employee[] = [];

  constructor(
    private contractService: ContractService,
    private employeeService: EmployeeService,
    private customerService: CustomerService,
    private facilityService: FacilityService,
    private router: Router,
    private toastr: ToastrService,
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.getCustomerList();
    this.getEmployeeList();
    this.getFacilityList();

    this.getContractForm();
  }

  getCustomerList() {
    this.customerService.getCustomerList().subscribe(customerList => {
      console.log(customerList)
      this.customerList = customerList;
    })
  }

  getEmployeeList() {
    this.employeeService.getEmployeeList().subscribe(employeeList => {
      console.log(employeeList)
      this.employeeList = employeeList;
    })
  }

  getFacilityList() {
    this.facilityService.getFacilityList().subscribe(facilityList => {
      console.log(facilityList)
      this.facilityList = facilityList;
    })
  }

  getContractForm() {
    this.rfContract = this.formBuilder.group({
      id: [],
      customer: ['', [Validators.required]],
      employee: ['', [Validators.required]],
      facility: ['', [Validators.required]],
      startDate: ['', [Validators.required]],
      endDate: ['', [Validators.required]],
      deposit: ['', [Validators.required]],
    })
  }

  create() {
    this.contractService.createContract(this.rfContract.value).subscribe(contract => {
      this.toastr.success('New contract created!')
      this.router.navigateByUrl('list');
    })
  }
}
