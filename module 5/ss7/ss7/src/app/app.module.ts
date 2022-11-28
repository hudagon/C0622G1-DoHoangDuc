import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {TimelinesComponent} from './timelines/timelines.component';
import {YoutubePlaylistComponent} from './youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './youtube-player/youtube-player.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ReactiveFormsModule} from "@angular/forms";
import {ListComponent} from './dictionary/list/list.component';
import {ViewComponent} from './dictionary/view/view.component';
import {ProductEditComponent} from './product/product-edit/product-edit.component';
import {ProductDeleteComponent} from './product/product-delete/product-delete.component';
import {HttpClientModule} from "@angular/common/http";
import { TodoComponent } from './todo/todo.component';

@NgModule({
  declarations: [
    AppComponent,
    TimelinesComponent,
    YoutubePlaylistComponent,
    YoutubePlayerComponent,
    ProductCreateComponent,
    ProductListComponent,
    ListComponent,
    ViewComponent,
    ProductEditComponent,
    ProductDeleteComponent,
    TodoComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
