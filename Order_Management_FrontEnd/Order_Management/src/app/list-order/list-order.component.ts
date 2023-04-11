import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { Router } from '@angular/router';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-list-order',
  templateUrl: './list-order.component.html',
  styleUrls: ['./list-order.component.css']
})
export class ListOrderComponent implements OnInit{

  orders!:Order[];

  constructor(private orderService:OrderService, 
    private router:Router){ }

  ngOnInit(): void {
    this.getOrders;
  }

  private getOrders(){
    this.orderService.getOrdersList().subscribe(response=>{
      console.log(response);
      this.orders=response;
    }
      );
  }
  updateOrder(id:number){
    this.router.navigate(['/update_order',id]);
  }
  deleteOrder(id:number){
    this.router.navigate(['/delete_order',id]);
  }
}
