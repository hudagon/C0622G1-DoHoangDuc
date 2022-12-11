import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { CarHostService } from '../service/car-host.service';
import {CarHost} from '../model/car-host';
import { TicketService } from '../service/ticket.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {TicketDto} from '../dto/ticket-dto';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  rfTicket: FormGroup;
  ticketABTC: TicketDto;

  carHostList: CarHost[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private carHostService: CarHostService,
    private ticketService: TicketService,
    private router: Router,
    private toastr: ToastrService
  ) {
  }

  ngOnInit(): void {

    this.getTicketForm();

    this.getCarHostList();

  }

  getTicketForm() {
    this.rfTicket = this.formBuilder.group({
      id: [],
      price: ['', [Validators.required, Validators.min(0)]],
      startPoint: ['',Validators.required],
      endPoint: ['',Validators.required],
      startDate: ['',Validators.required],
      startTime: ['',[Validators.required, Validators.pattern('^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$')]],
      amount: ['',[Validators.required, Validators.min(0)]],
      carHostId: ['',Validators.required],
    })
  }

  getCarHostList() {
    this.carHostService.getCarHostList().subscribe(carHostList => {
      this.carHostList = carHostList;
    })
  }

  create() {
    this.ticketService.create(this.rfTicket.value).subscribe(ticket => {
      console.log('ok');
      this.toastr.success('New Ticket created successfully!')
      this.router.navigateByUrl('list');
    })
  }
}
