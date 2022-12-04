import { Injectable } from '@angular/core';
import {Champion} from '../model/champion';
import {HttpClient} from '@angular/common/http';
import {ChampionType} from '../model/champion-type';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ChampionTypeService {

  championTypeList: Champion[] = [];

  constructor(
    private httpClient: HttpClient,
  ) { }

  getAll(): Observable<ChampionType[]> {
    return this.httpClient.get<ChampionType[]>(environment.apiUrl + 'championType')
  }

}
