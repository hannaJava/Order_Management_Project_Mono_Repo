import { Component, OnInit } from '@angular/core';
import { enviroment } from 'src/enviroments/enviroment';
import { OrderService } from '../order.service';
import { Router } from '@angular/router';
import { Order } from '../order';

@Component({
  selector: 'app-list-order-customer',
  templateUrl: './list-order-customer.component.html',
  styleUrls: ['./list-order-customer.component.css']
})
export class ListOrderCustomerComponent implements OnInit{
  orders!:Order[];
  order:Order=new Order;

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

  updateOrder(id:number){
    this.router.navigate(['/update_order',id]);
  }
  deleteOrder(id:number){
   // this.router.navigate(['/delete_order',id]);
      this.orderService.deleteOrder(id).subscribe(
        response=>{
          console.log(response)
        },
        error=>console.log(error)
      );
      this.orderService.publishActivityEventMessage('an order with id : '+id+' has been deleted').subscribe(
        response=>{
          console.log(response)
        },
        error=>console.log(error)
      );
      this.orderService.getOrderById(id).subscribe(
        response=>{
          //console.log(response);
          this.order=response
        },
        error=>console.log(error)
      );
      this.orderService.publishOrderEventMessage('cancelled',this.order).subscribe(
        response=>{
          console.log(response)
        },
        error=>console.log(error)
      );
      this.displayOrderList();
    }
  
    displayOrderList(){
      this.router.navigate(['/list_orders_customer'])
    }

}
