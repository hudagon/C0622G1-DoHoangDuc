import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {CustomerComponent} from "./customer/customer.component";
import {AuctionComponent} from "./auction/auction.component";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./security/auth.guard";
import {AdminGuard} from "./security/admin.guard";


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'customer', component: CustomerComponent, canActivate: [AdminGuard]},
  {path: 'auction', component: AuctionComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
