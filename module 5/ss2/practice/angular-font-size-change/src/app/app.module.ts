import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FontSizeChangeComponent } from './font-size-change/font-size-change.component';
import {FormsModule} from "@angular/forms";
import { PetInforDisplayComponent } from './pet-infor-display/pet-infor-display.component';
import { ProductComponent } from './product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeChangeComponent,
    PetInforDisplayComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
