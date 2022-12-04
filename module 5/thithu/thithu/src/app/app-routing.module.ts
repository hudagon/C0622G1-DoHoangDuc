import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ChampionListComponent} from './champion/champion-list/champion-list.component';
import {ChampionCreateComponent} from './champion/champion-create/champion-create.component';
import {ChampionEditComponent} from './champion/champion-edit/champion-edit.component';


const routes: Routes = [
  {path: 'champion/list', component: ChampionListComponent},
  {path: 'champion/create', component: ChampionCreateComponent},
  {path: 'champion/edit/:id', component: ChampionEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
