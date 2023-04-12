import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-list-customers',
  templateUrl: './list-customers.component.html',
  styleUrls: ['./list-customers.component.css']
})
export class ListCustomersComponent implements OnInit{
  customers!:Customer[];

  constructor(private customerService:CustomerServiceService, 
    private router:Router){ }

  ngOnInit(): void {
    this.getCustomers();
  }

  private getCustomers(){
    this.customerService.getCustomersList().subscribe(response=>{
      console.log(response);
      this.customers=response;
    }
      );
  }
  updateCustomer(id:number){
    this.router.navigate(['/update_customer',id]);
  }
  deleteCustomer(id:number){
    //this.router.navigate(['/delete_customer',id]);
    this.customerService.deleteCustomer(id).subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error)
    );
    this.customerService.publishActivityEventMessage('a customer with id : '+id+' has been deleted').subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error)
    );
    this.displayCustomerList();
  }

  displayCustomerList(){
    this.router.navigate(['/list_customers'])
  }
}
