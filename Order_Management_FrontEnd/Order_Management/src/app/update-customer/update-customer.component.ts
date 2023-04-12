import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerServiceService } from '../customer-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit{
  customer:Customer=new Customer;

  id:number=0;
  constructor(private customerService:CustomerServiceService, 
    private route:ActivatedRoute, private router:Router){

  }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.customerService.getCustomerById(this.id).subscribe(
        response=>  {
          this.customer=response
              },
          error=>console.log(error) 
    );
  }

  onSubmit(){
    console.log(this.customer);
    this.updateCustomer(this.id,this.customer);
    this.displayCustomerList();
  }

  displayCustomerList(){
    this.router.navigate(['/list_customers'])
  }

  updateCustomer(id:number,customer:Customer){
    this.customerService.updateCustomer(id,customer).subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error) 
    );
    console.log('a customer with id : '+this.customer.id+' has been updated');
    this.customerService.publishActivityEventMessage('a customer with id : '+this.customer.id+' has been updated').subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error)
    );
  }
}
