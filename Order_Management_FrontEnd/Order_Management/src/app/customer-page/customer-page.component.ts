import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-page',
  templateUrl: './customer-page.component.html',
  styleUrls: ['./customer-page.component.css']
})
export class CustomerPageComponent implements OnInit{
  constructor(private router:Router){
  }
  
  ngOnInit(): void {
    
  }
  dashboard(){

  }
  logout(){

  }
  addOrder(){
    this.router.navigate(['/add_order']);
  }
  updateDeleteOrder(){
    
  }
  listOrders(){
    
  }
  listProducts(){
    
  }

}
