import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  bookOrderDetailSet: any = [];
  currentCartQuantity: number = 0;


  constructor(
    private orderService: OrderService
  ) { }

  ngOnInit(): void {
    this.getBookOrder();
  }

  getBookOrder() {
    this.orderService.getBookOrder().subscribe(data => {
      this.orderService.bookOrderId = data.id;
      this.bookOrderDetailSet = data.bookOrderDetailSet;
      this.currentCartQuantity = 0;

      for (let i = 0; i < this.bookOrderDetailSet.length; i++) {
        this.currentCartQuantity = this.currentCartQuantity + this.bookOrderDetailSet[i].quantity;
      }
    })
  }

}
