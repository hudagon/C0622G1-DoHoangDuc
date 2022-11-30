import { NgModule } from '@angular/core';
import {FacilityListComponent} from './facility-list/facility-list.component';
import { Routes, RouterModule } from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';
import {ContractListComponent} from './contract-list/contract-list.component';
import {CustomerCreateComponent} from './customer-create/customer-create.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {FacilityCreateComponent} from './facility-create/facility-create.component';
import {FacilityEditComponent} from './facility-edit/facility-edit.component';



const routes: Routes =[
  {path: 'facilityList', component: FacilityListComponent},
  {path: 'customerList', component: CustomerListComponent},
  {path: 'contractList', component: ContractListComponent},
  {path: 'customer/create', component: CustomerCreateComponent},
  {path: 'customer/edit/:customerId', component: CustomerEditComponent},
  {path: 'facility/create', component: FacilityCreateComponent},
  {path: 'facility/edit/:facilityId', component: FacilityEditComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
