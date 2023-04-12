import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-order',
  templateUrl: './update-order.component.html',
  styleUrls: ['./update-order.component.css']
})
export class UpdateOrderComponent implements OnInit{
  order:Order=new Order;

  id:number=0;
  constructor(private orderService:OrderService, 
    private route:ActivatedRoute, private router:Router){

  }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.orderService.getOrderById(this.id).subscribe(
        response=>  {
          this.order=response
              },
          error=>console.log(error) 
    );
  }

  onSubmit(){
    console.log(this.order);
    this.updateOrder(this.id,this.order);
    this.displayOrderList();
  }

  displayOrderList(){
    this.router.navigate(['/list_orders'])
  }

  updateOrder(id:number,order:Order){
    this.orderService.updateOrder(id,this.order).subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error) 
    );
    console.log('a order with id : '+this.order.id+' has been updated');
    this.orderService.publishActivityEventMessage('a order with id : '+this.order.id+' has been updated').subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error)
    );
  }


}
