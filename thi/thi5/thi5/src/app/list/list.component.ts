import {Component, OnInit} from '@angular/core';
import {Ticket} from '../model/ticket';
import {TicketService} from '../service/ticket.service';
import {ToastrService} from 'ngx-toastr';
import {TicketDto} from '../dto/ticket-dto';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  startPointSearch: string = '';
  endPointSearch: string = '';
  firstDateSearch: string = '';
  secondDateSearch: string = '';

  numberOfPages: number[] = [];
  temp: number = 0;
  page: number = 0;
  sortBy: String = '';
  sortOrder: String = '';

  ticketBooked: TicketDto;
  ticketView: Ticket = {
    'id': 0,
    'price': 0,
    'startPoint': '123',
    'endPoint': '123',
    'startDate': '2022-12-17',
    'startTime': '123',
    'amount': 0,
    'carHost': {
      'id': 0,
      'name': 'Car Host 002'
    }
  };

  ticketList: Ticket[] = [];
  ticketListTemp: Ticket[] = [];
  deleteTicketId: number = 0;

  constructor(
    private ticketService: TicketService,
    private toastr: ToastrService
  ) {
  }

  ngOnInit(): void {
    this.getTicketList();
  }

  getTicketList() {
    this.ticketService.getAll(this.startPointSearch, this.endPointSearch).subscribe(data => {
      console.log('ok1');
      console.log(data);
      this.ticketListTemp = data.filter(value => {

        if (this.firstDateSearch != '' && this.secondDateSearch != '') {
          const endDateContract = new Date(value.startDate);
          const firstDateSearch = new Date(this.firstDateSearch);
          const secondDateSearch = new Date(this.secondDateSearch);

          if (endDateContract > firstDateSearch && endDateContract < secondDateSearch) {
            return value;
          }
        } else {
          return data;
        }
      });

      console.log('ok2');
      console.log(this.ticketListTemp);

      this.getNumberOfPages(this.ticketListTemp.length);

    });

    // @ts-ignore
    this.ticketService.getTicketListPaged(this.startPointSearch, this.endPointSearch, this.page, this.sortBy, this.sortOrder).subscribe(ticketList => {
      console.log('ok3');
      console.log(ticketList);
      this.ticketList = ticketList.filter(value => {

        if (this.firstDateSearch != '' && this.secondDateSearch != '') {
          const endDateContract = new Date(value.startDate);
          const firstDateSearch = new Date(this.firstDateSearch);
          const secondDateSearch = new Date(this.secondDateSearch);

          if (endDateContract > firstDateSearch && endDateContract < secondDateSearch) {
            return value;
          }
        } else {
          return ticketList;
        }
      });


      console.log('ok4');
      console.log(ticketList);

    });
  }

  viewBookTicket(ticketId: number) {
    this.ticketService.getTicketById(ticketId).subscribe(ticketBooked => {
      this.ticketView = ticketBooked;
    });
  }

  bookTicket() {
    if (this.ticketView.amount == 0) {
      this.toastr.error('There is no more of this ticket!');
      this.ngOnInit();
    } else {
      this.ticketBooked = {
        'id': this.ticketView.id,
        'price': this.ticketView.price,
        'startPoint': this.ticketView.startPoint,
        'endPoint': this.ticketView.endPoint,
        'startDate': this.ticketView.startDate,
        'startTime': this.ticketView.startTime,
        'amount': this.ticketView.amount - 1,
        'carHostId': this.ticketView.carHost.id
      };

      this.ticketService.bookTicket(this.ticketBooked).subscribe(data => {
        this.toastr.success('Ticked Booked Successfully!');
        this.ngOnInit();
      });
    }
  }

  getNumberOfPages(numberOfTickets: number) {

    if ((numberOfTickets % 3) != 0) {
      this.temp = (Math.round(numberOfTickets / 3)) + 1;
    }

    this.temp = numberOfTickets / 3;

    this.numberOfPages = [];
    for (let i = 0; i < this.temp; i++) {
      this.numberOfPages.push(i + 1);
    }
  }

  goToPage(page: number) {
    this.page = page - 1;
    this.getTicketList();
  }

  getDeleteInfo(deleteTicketId: number) {
    this.deleteTicketId = deleteTicketId;
  }

  deleteTicketById() {
    this.ticketService.deleteTickById(this.deleteTicketId).subscribe(() => {
      this.toastr.success('Ticket deleted successfully')
      this.ngOnInit();
    })
  }

  sortByPrice() {
    this.sortBy = 'price';
    this.getTicketList();
  }

}
