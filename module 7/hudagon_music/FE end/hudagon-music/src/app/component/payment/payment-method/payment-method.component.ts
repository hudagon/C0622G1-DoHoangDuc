import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { render } from 'creditcardpayments/creditCardPayments';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-payment-method',
  templateUrl: './payment-method.component.html',
  styleUrls: ['./payment-method.component.css']
})
export class PaymentMethodComponent implements OnInit {

  constructor(
    private toastr: ToastrService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    render({
      id: '#myPaypalButton',
      currency: 'USD',
      value: '100.00',
      onApprove: (details) => {
        this.toastr.success('Giao dịch thành công');
        this.router.navigateByUrl('');
      }
    }) 
  }

}
