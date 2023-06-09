import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { OrderService } from "src/app/services/order.service";

@Component({
  selector: "app-cart",
  templateUrl: "./cart.component.html",
  styleUrls: ["./cart.component.css"],
})
export class CartComponent implements OnInit {

  /* Book order information */
  bookOrderDetailSetShow!: any;
  bookOrder!: any;
  estimatedMoney: number = 0;

  constructor(
    private orderService: OrderService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.getBookOrder();
  }

  /* Book order methods */
  getBookOrder() {
    this.orderService.getBookOrder().subscribe((data) => {

      this.bookOrder = data;
      this.bookOrderDetailSetShow = this.bookOrder.bookOrderDetailSet;

      console.log(this.bookOrder.bookOrderDetailSet.length);
      

      for (let i = 0; i < this.bookOrder.bookOrderDetailSet.length; i++) {
        this.estimatedMoney =
          this.estimatedMoney +
          (this.bookOrderDetailSetShow[i].quantity *
            this.bookOrderDetailSetShow[i].book.price);
      }
    });
  }

  removeFromCart(id: number) {
    this.orderService
      .removeFormCart(id)
      .subscribe((data) => {
        this.toastr.success("Delete from cart successfully!");
        this.ngOnInit();
      });
  }

  calculateMoney(bookOrderDetailId: number, operator: number) {
    var quantity = +document.getElementById('bookOrderDetailQuantity' + bookOrderDetailId).innerHTML;
    var price = +document.getElementById('bookOrderDetailPrice' + bookOrderDetailId).dataset.price;
    var currentTotalMoney = +document.getElementById('bookOrderDetailTotalMoney' + bookOrderDetailId).innerHTML;
    var afterTotalMoney = 0;

    /* Changing the quantity */
    if (operator === 1) {
      quantity = +quantity + 1;
    } else {
      quantity = +quantity - 1;
    }

    console.log(quantity);
    
    document.getElementById('bookOrderDetailQuantity' + bookOrderDetailId).innerHTML = JSON.stringify(quantity);

    /* Changing the total money of each product */
    afterTotalMoney = quantity * price;
    document.getElementById('bookOrderDetailTotalMoney' + bookOrderDetailId).innerHTML = JSON.stringify(afterTotalMoney);

    /* Changing the estimated money */
    this.estimatedMoney = this.estimatedMoney - currentTotalMoney + afterTotalMoney;
  }

}
