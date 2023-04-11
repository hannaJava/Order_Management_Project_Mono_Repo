import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent {
  title = 'Order_Management';

  constructor(private router:Router){
  }

  adminLogin(){
    this.router.navigate(['/admin_login']);
  }
  customerLogin(){
    this.router.navigate(['/customer_login']);
  }
}
