import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit{
  product:Product=new Product;

  constructor(private productService:ProductServiceService,private router:Router){
  }
 ngOnInit():void{
  }

  onSubmit(){
    //console.log(this.department);
    this.addProduct();
   /*this.productService.publishActivityEventMessage('a new product has been created ').subscribe(
      response=>{
        //console.log(response)
      },
      error=>console.log(error)
    );*/
    this.productService.publishActivityEventMessage('a new product has been created').subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error)
    );
    this.displayProductList();
  }

  addProduct(){
    this.productService.addProduct(this.product).subscribe(
      response=>{
        console.log(response);
      },
      error=>console.log(error) 
    );
  }

  displayProductList(){
    this.router.navigate(['/list_products'])
  }
}
