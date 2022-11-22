import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CalculatorComponent } from './calculator/calculator.component';
import {FormsModule} from "@angular/forms";
import { ColorPickerComponent } from './color-picker/color-picker.component';
import { ArticleComponent } from './article/article.component';
import { LikeComponentComponent } from './article/like-component/like-component.component';
import { HeaderComponent } from './article/header/header.component';
import { FooterComponent } from './article/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    ColorPickerComponent,
    ArticleComponent,
    LikeComponentComponent,
    HeaderComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
