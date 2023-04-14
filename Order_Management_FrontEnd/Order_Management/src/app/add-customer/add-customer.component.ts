import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerServiceService } from '../customer-service.service';
import { Router } from '@angular/router';
import { Subscription, interval } from 'rxjs';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit{
  customer:Customer=new Customer;

  constructor(private customerService:CustomerServiceService,private router:Router){
  }
 ngOnInit():void{

  }

  onSubmit(){
    //console.log(this.department);
    this.addCustomer();
    console.log(this.customer);
    this.displayCustomerList();
   
  }

  addCustomer(){
    this.customerService.addCustomer(this.customer).subscribe(
      response=>{
        this.customer=response
      },
      error=>console.log(error)
    );

    this.customerService.getCustomerByUsername(this.customer.username).subscribe(
      {
        next:response=>console.log('customer by username '+response),
        error:error=>console.log(error)
      }
    ).add;

    this.customerService.publishActivityEventMessage('a new customer has been created').subscribe(
      response=>{
        console.log('activity '+response)
      },
      error=>console.log(error)
    );
  }

  displayCustomerList(){
    this.router.navigate(['/list_customers'])
  }

}
