import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  /* Search info */
  name: string = '';
  categoryId: number = -1;
  authorId: number = -1;
  firstPrice: number = 0;
  secondPrice: number = 9999999999999;
  pageNumber: number = 0;
  sortOption: number = 0;
  sortDirection: boolean = false;

  constructor(
    private httpClient: HttpClient
  ) { }

  searchBook(bookSearchInfo: any): Observable<any> {
    return this.httpClient.post<any>(environment.API_URL + 
      "api/v1/book/searchBook", bookSearchInfo);
  }

  getAllPriceRanges(): Observable<any> {
    return this.httpClient.get<any>(environment.API_URL +
      "api/v1/book/getAllPriceRanges")
  }

}
