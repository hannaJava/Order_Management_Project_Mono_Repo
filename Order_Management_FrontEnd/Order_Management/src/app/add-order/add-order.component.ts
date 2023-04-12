import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';
import { Router } from '@angular/router';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { enviroment } from 'src/enviroments/enviroment';

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit{
  products!:Product[];
  order: Order= new Order;
  product:Product=new Product();

  constructor(private productService:ProductServiceService, 
    private orderService:OrderService, private router:Router){ }

  ngOnInit(): void {
    this.displayProductList();
    console.log(enviroment.userId);
  }

  onSubmit(){
    //console.log(this.department);
    this.addOrder();
    this.displayOrderList();
  }

  addOrder(){
    this.order.customerId=enviroment.userId;
    console.log(enviroment.userId);
    this.order.productId=enviroment.productId;
    console.log(this.order.productId);
    this.orderService.addOrder(this.order).subscribe(
      response=>{
        console.log(response);
      },
      error=>console.log(error) 
    );
    this.orderService.publishActivityEventMessage('a new order has been created by customer id : '
    +this.order.customerId).subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error)
    );
    this.orderService.publishOrderEventMessage('created',this.order).subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error)
    );
  }

  displayOrderList(){
    this.router.navigate(['/list_orders_customer'])
  }

  private displayProductList(){
    this.productService.getProductsList().subscribe(response=>{
      console.log(response);
      this.products=response;
    }
      );
  }

}
