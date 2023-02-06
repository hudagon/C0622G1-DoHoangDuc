import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartComponent } from './component/cart/cart.component';
import { LandingPageComponent } from './component/landing-page/landing-page.component';
import { PaymentMethodComponent } from './component/payment/payment-method/payment-method.component';
import { PaymentComponent } from './component/payment/payment.component';


const routes: Routes = [
  {path: '', component: LandingPageComponent},
  {path: 'cart/:userId', component: CartComponent},
  {path: 'payment/:userId', component: PaymentComponent,
  children: [
    {path: 'method', component: PaymentMethodComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
