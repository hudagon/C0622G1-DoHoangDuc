import { NgModule } from '@angular/core';
import {FacilityListComponent} from './facility-list/facility-list.component';
import { Routes, RouterModule } from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';
import {ContractListComponent} from './contract-list/contract-list.component';



const routes: Routes =[
  {path: 'facilityList', component: FacilityListComponent},
  {path: 'customerList', component: CustomerListComponent},
  {path: 'contractList', component: ContractListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
