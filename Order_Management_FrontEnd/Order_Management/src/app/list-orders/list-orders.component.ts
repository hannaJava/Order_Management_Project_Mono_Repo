import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-orders',
  templateUrl: './list-orders.component.html',
  styleUrls: ['./list-orders.component.css']
})
export class ListOrdersComponent implements OnInit{
  orders!:Order[];

  constructor(private orderService:OrderService,
    private router:Router){ }

    ngOnInit(): void {
      this.getOrders();
    }

    private getOrders(){
      this.orderService.getOrdersList().subscribe(response=>{
        console.log(response);
        this.orders=response;
      }
        );
    }
}
