import {Component, OnInit} from '@angular/core';
import {ContractService} from "../service/contract.service";
import {Contract} from "../model/contract";
import {Employee} from "../model/employee";
import {Customer} from "../model/customer";
import {EmployeeService} from "../service/employee.service";
import {CustomerService} from "../service/customer.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  contractView: Contract = {
    "customer": {
      "id": 0,
      "name": "dummy"
    },
    "employee": {
      "id": 0,
      "name": "dummy"
    },
    "facility": {
      "id": 0,
      "name": "dummy",
      "price": 0
    },
    "startDate": "dummy",
    "endDate": "dummy",
    "deposit": 0

  }
  contractDeleteId: number = 0;

  customerNameSearch: string = '';
  employeeNameSearch: string = '';
  facilityNameSearch: string = '';

  firstDateSearch: string = '';
  secondDateSearch: string = '';

  contractList: Contract[] = [];
  employeeList: Employee[] = [];
  customerList: Customer[] = [];

  page: number = 1;

  constructor(
    private contractService: ContractService,
    private employeeService: EmployeeService,
    private customerService: CustomerService,
    private router: Router,
    private toastr: ToastrService,
  ) {
  }

  ngOnInit(): void {
    this.getCustomerList();
    this.getEmployeeList();

    this.getContractList();
  }

  getContractList() {
    this.page = 1;
    this.contractService.getListContract(this.customerNameSearch,
      this.employeeNameSearch, this.facilityNameSearch).subscribe(data => {
        this.contractList = data.filter(value => {


          if (this.firstDateSearch != '' && this.secondDateSearch != '') {
            const endDateContract = new Date(value.endDate);
            const firstDateSearch = new Date(this.firstDateSearch);
            const secondDateSearch = new Date(this.secondDateSearch);

            console.log(endDateContract);
            console.log(firstDateSearch);
            console.log(secondDateSearch);

            if (endDateContract > firstDateSearch &&  endDateContract < secondDateSearch) {
              console.log(value)
              return value;
            }
          } else {
            return data;
          }
        })
      }
    )
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


  getDeleteInfo(id: number) {
    this.contractDeleteId = id;
  }

  viewContract(id: number) {
    this.contractService.getContractById(id).subscribe(contractView => {
      this.contractView = contractView;
    })
  }

  deleteContractById() {
    this.contractService.deleteContractById(this.contractDeleteId).subscribe(() => {
      this.toastr.success('Contract deleted successfully!');
      this.ngOnInit();
    })
  }
}
