import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { IonicModule } from '@ionic/angular';
import { LandingPageComponent } from './component/landing-page/landing-page.component';
import { OverviewProductComponent } from './component/landing-page/overview-product/overview-product.component';
import { SpecificProductComponent } from './component/landing-page/specific-product/specific-product.component';
import { LoginSignUpComponent } from './component/login-sign-up/login-sign-up.component';
import { ProductDetailComponent } from './component/product-detail/product-detail.component';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import { FooterComponent } from './component/footer/footer.component';
import { CartComponent } from './component/cart/cart.component';
import { UserManagementComponent } from './component/user-management/user-management.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LandingPageComponent,
    OverviewProductComponent,
    SpecificProductComponent,
    LoginSignUpComponent,
    ProductDetailComponent,
    FooterComponent,
    CartComponent,
    UserManagementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    IonicModule.forRoot(),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }