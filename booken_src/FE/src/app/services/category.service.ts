import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getCategoryList(): Observable<any> {
    return this.httpClient.get<any>(environment.API_URL + 
      'api/v1/category/getCategoryList')
  }
}
