import { Injectable } from '@angular/core';
import {Champion} from '../model/champion';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ChampionService {

  championList: Champion[] = [];
  championId: string;

  constructor(
    private httpClient: HttpClient,
  ) { }

  delete(championId: string): Observable<Champion> {
    return this.httpClient.delete<Champion>(environment.apiUrl + "champion/" + championId)
  }

  search(championNameSearch: string, championTypeSearch: string): Observable<Champion[]> {
    return this.httpClient.get<Champion[]>(environment.apiUrl + "champion/?name_like=" + championNameSearch +
    '&championType.id_like=' + championTypeSearch)
  }

  findChampionById(championId: string): Observable<Champion> {
    return this.httpClient.get<Champion>(environment.apiUrl + "champion/" + championId)
  }

  createChampion(championATBC: Champion): Observable<Champion> {
    return this.httpClient.post<Champion>(environment.apiUrl + "champion", championATBC)
  }

  edit(championATBE: Champion): Observable<Champion> {
    return this.httpClient.put<Champion>(environment.apiUrl + "champion/" + championATBE.id, championATBE)
  }
}
