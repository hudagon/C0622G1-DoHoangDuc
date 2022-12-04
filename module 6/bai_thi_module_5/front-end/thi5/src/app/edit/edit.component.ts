import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {CarHostService} from '../service/car-host.service';
import {TicketService} from '../service/ticket.service';
import {tick} from '@angular/core/testing';
import {CarHost} from '../model/car-host';
import {ActivatedRoute, Router} from '@angular/router';
import {TicketDto} from '../dto/ticket-dto';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  rfTicketEdit: FormGroup;

  ticketEditId: number;
  ticketABTE: TicketDto;

  carHostList: CarHost[] = [];

  constructor(
    private carHostService: CarHostService,
    private ticketService: TicketService,
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.ticketEditId = params.id;
    })

    this.getEditTicketForm();

    this.getCarHostList();
  }

  getEditTicketForm() {
    this.ticketService.getTicketById(this.ticketEditId).subscribe((ticket) => {
      this.rfTicketEdit = this.formBuilder.group({
        id: [ticket.id],
        price: [ticket.price, [Validators.required, Validators.min(0)]],
        startPoint: [ticket.startPoint,Validators.required],
        endPoint: [ticket.endPoint,Validators.required],
        startDate: [ticket.startDate,Validators.required],
        startTime: [ticket.startTime,[Validators.required, Validators.pattern('^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$')]],
        amount: [ticket.amount,[Validators.required, Validators.min(0)]],
        carHostId: [ticket.carHost.id,Validators.required],
      })
    })
  }

  getCarHostList() {
    this.carHostService.getCarHostList().subscribe( carHostList => {
      this.carHostList = carHostList;
    })
  }

  edit() {

    this.ticketABTE = this.rfTicketEdit.value;

    this.ticketService.editTicket(this.ticketABTE).subscribe(() => {
      this.toastr.success('Ticket updated successfully!')
      this.router.navigateByUrl('list')
    })
  }

}
