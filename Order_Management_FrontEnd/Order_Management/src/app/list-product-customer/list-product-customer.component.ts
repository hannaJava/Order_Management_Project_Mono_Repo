import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';
import { Router } from '@angular/router';
import { enviroment } from 'src/enviroments/enviroment';

@Component({
  selector: 'app-list-product-customer',
  templateUrl: './list-product-customer.component.html',
  styleUrls: ['./list-product-customer.component.css']
})
export class ListProductCustomerComponent implements OnInit{
  products!:Product[];

  constructor(private productService:ProductServiceService,
    private router:Router){ }

  ngOnInit(): void {
    this.getProducts();
  }

  private getProducts(){
    this.productService.getProductsList().subscribe(response=>{
      console.log(response);
      this.products=response;
    }
      );
  }

  createOrder(id:number){
    enviroment.productId=id;
    console.log(id);
    this.router.navigate(['/add_order']);
  }
}
