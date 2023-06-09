import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getAuthorList(): Observable<any> {
    return this.httpClient.get<any>(environment.API_URL + 'api/v1/author/getAuthorList')
  }

}
