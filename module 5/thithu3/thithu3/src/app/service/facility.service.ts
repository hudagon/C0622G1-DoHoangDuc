import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Facility} from "../model/facility";
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  constructor(
    private httpClient: HttpClient,
  ) { }

  getFacilityList(): Observable<Facility[]> {
    return this.httpClient.get<Facility[]>(environment.apiUrl + 'facility')
  }
}
