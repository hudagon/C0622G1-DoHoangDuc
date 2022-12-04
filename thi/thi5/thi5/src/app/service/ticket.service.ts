import {Injectable} from '@angular/core';
import {Observable, throwError} from 'rxjs';
import {Ticket} from '../model/ticket';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {TicketDto} from '../dto/ticket-dto';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(
    private httpClient: HttpClient,
  ) {
  }

  getTicketListPaged(startPointSearch: string, endPointSearch: string,
                     page: number, sortBy: string, sortOrder: string): Observable<Ticket[]> {
    return this.httpClient.get<Ticket[]>(environment.apiUrl + 'api/ticket/v1/getListPaged?searchStartPoint=' + startPointSearch +
      '&searchEndPoint=' + endPointSearch + '&page=' + page + '&sortBy=' + sortBy + '&sortOrder=' + sortOrder);
  }

  getTicketById(ticketId: number): Observable<Ticket> {
    return this.httpClient.get<Ticket>(environment.apiUrl + 'api/ticket/v1/' + ticketId);
  }

  bookTicket(ticketBooked: TicketDto): Observable<TicketDto> {
    return this.httpClient.put<TicketDto>(environment.apiUrl + 'api/ticket/v1/edit', ticketBooked);
  }

  getAll(startPointSearch: string, endPointSearch: string): Observable<Ticket[]> {
    return this.httpClient.get<Ticket[]>(environment.apiUrl + 'api/ticket/v1/getListAll?searchStartPoint=' + startPointSearch
      + '&searchEndPoint=' + endPointSearch);
  }

  deleteTickById(deleteTicketId: number): Observable<void> {
    return this.httpClient.delete<void>(environment.apiUrl + 'api/ticket/v1/' + deleteTicketId);
  }

  editTicket(ticketABTE: TicketDto): Observable<TicketDto> {
    return this.httpClient.put<TicketDto>(environment.apiUrl + 'api/ticket/v1/edit', ticketABTE);
  }

  create(ticketABTC: TicketDto): Observable<any> {
    console.log(ticketABTC);
    return this.httpClient.post<any>(environment.apiUrl + 'api/ticket/v1/create', (ticketABTC)).pipe(this.errorHandler)
  }

  errorHandler(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };
}
