import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CarHost} from '../model/car-host';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CarHostService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getCarHostList(): Observable<CarHost[]> {
    return this.httpClient.get<CarHost[]>(environment.apiUrl + 'api/carHost/v1/list');
  }
}
