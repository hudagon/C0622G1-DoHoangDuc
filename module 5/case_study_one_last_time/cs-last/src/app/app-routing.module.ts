import { NgModule } from '@angular/core';
import {FacilityListComponent} from './facility-list/facility-list.component';
import { Routes, RouterModule } from '@angular/router';



const routes: Routes =[
  {path: 'facilityList', component: FacilityListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
