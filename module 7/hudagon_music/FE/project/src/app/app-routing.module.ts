import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LandingPageComponent} from './component/landing-page/landing-page.component';
import {OverviewProductComponent} from './component/landing-page/overview-product/overview-product.component';
import {SpecificProductComponent} from './component/landing-page/specific-product/specific-product.component';
import {LoginSignUpComponent} from './component/login-sign-up/login-sign-up.component';
import {ProductDetailComponent} from './component/product-detail/product-detail.component';
import {CartComponent} from './component/cart/cart.component';
import {UserGuard} from './security/guard/user.guard';


const routes: Routes = [
  {
    path: '', component: LandingPageComponent, children: [
      {path: '', component: OverviewProductComponent},
      {path: 'specific', component: SpecificProductComponent}
    ]
  },
  {
    path: 'login', component: LoginSignUpComponent
  },
  {
    path: 'product-detail', component: ProductDetailComponent, canActivate: [UserGuard]
  },
  {
    path: 'cart', component: CartComponent, canActivate: [UserGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
