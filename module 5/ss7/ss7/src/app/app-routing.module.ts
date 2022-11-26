import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TimelinesComponent} from "./timelines/timelines.component";
import {YoutubePlaylistComponent} from "./youtube-playlist/youtube-playlist.component";
import {YoutubePlayerComponent} from "./youtube-player/youtube-player.component";
import {ProductListComponent} from "./product/product-list/product-list.component";
import {ProductCreateComponent} from "./product/product-create/product-create.component";
import {ListComponent} from "./dictionary/list/list.component";
import {ViewComponent} from "./dictionary/view/view.component";
import {ProductEditComponent} from "./product/product-edit/product-edit.component";
import {ProductDeleteComponent} from "./product/product-delete/product-delete.component";


const routes: Routes = [
  {path: 'timelines', component: TimelinesComponent},
  {
    path: 'youtube',
    component: YoutubePlaylistComponent,
    children: [{
      path: ':id',
      component: YoutubePlayerComponent
    }]
  },
  {path: 'productList', component: ProductListComponent},
  {path: 'productCreate', component: ProductCreateComponent},
  {path: 'dictionaryList', component: ListComponent},
  {path: 'dictionaryView/:index', component: ViewComponent},
  {path: 'productEdit/:productId', component: ProductEditComponent},
  {path: 'productDelete/:productId', component: ProductDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
