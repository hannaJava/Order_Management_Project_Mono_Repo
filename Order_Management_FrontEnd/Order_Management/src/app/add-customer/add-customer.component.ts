import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerServiceService } from '../customer-service.service';
import { Router } from '@angular/router';

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
   /*this.customerService.publishActivityEventMessage('a new customer has been created ').subscribe(
      response=>{
        //console.log(response)
      },
      error=>console.log(error)
    );*/
    this.displayCustomerList();
  }

  addCustomer(){
    this.customerService.addCustomer(this.customer).subscribe(
      response=>{
        console.log(response);
      },
      error=>console.log(error) 
    );
    this.customerService.publishActivityEventMessage('a new customer has been created').subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error)
    );
  }

  displayCustomerList(){
    this.router.navigate(['/list_customers'])
  }

}
