import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { enviroment } from 'src/enviroments/enviroment';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit{
  constructor(private router:Router){
  }
  ngOnInit(): void {
  
  }
  login(){
    this.router.navigate(['/admin_page']);
    enviroment.userId=0;
    console.log(enviroment.userId);
  }

}
