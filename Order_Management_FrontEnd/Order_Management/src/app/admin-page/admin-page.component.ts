import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit{
  constructor(private router:Router){
  }
  
  ngOnInit(): void {
    
  }
  dashboard(){

  }
  logout(){

  }
  addCustomer(){
    this.router.navigate(['/add_customer']);
  }
  updateDeleteCustomer(){
    
  }
  listCustomers(){
    this.router.navigate(['/list_customers']);
  }

  addProduct(){

  }
  updateDeleteProduct(){
    
  }
  listProducts(){
    this.router.navigate(['/list_products']);
  }

  listOrders(){
    this.router.navigate(['/list_orders']);
  }
}
