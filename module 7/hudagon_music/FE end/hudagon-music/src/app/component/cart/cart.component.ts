import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductOrder } from 'src/app/model/order/product-order';
import { ProductOrderDetail } from 'src/app/model/order/product-order-detail';
import { OrderService } from 'src/app/service/order/order.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  productOrderDetailList: ProductOrderDetail[] = [];
  productOrder: ProductOrder;
  userId: string;

  constructor(
    private orderService: OrderService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.userId = params.userId;
    })  

    this.getProductOrder();
  }

  getProductOrder() {
    this.orderService.getProductOrder(this.userId).subscribe(data => {
      this.productOrderDetailList = data.productOrderDetailSet;
    })
  }

}
