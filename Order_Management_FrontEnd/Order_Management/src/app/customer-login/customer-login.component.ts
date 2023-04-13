import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { enviroment } from 'src/enviroments/enviroment';
import { CustomerServiceService } from '../customer-service.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit{

  customer:Customer=new Customer;

  constructor(private router:Router,private customerService:CustomerServiceService){

  }
  ngOnInit(): void {
  
  }
  login(){
    console.log(this.customer.username);
    this.customerService.getCustomerByUsername(this.customer.username).subscribe(
      response=> {
        this.customer=response
      },
      error=> console.log(error)  
  );
  enviroment.userId=this.customer.id;
  console.log(this.customer.id);
  console.log(this.customer.username);
  console.log(this.customer.address);
    this.router.navigate(['/customer_page']);
  }
}
