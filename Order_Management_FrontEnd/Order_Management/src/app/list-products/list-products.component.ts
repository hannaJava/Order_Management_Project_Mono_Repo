import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductServiceService } from '../product-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit{
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
  updateProduct(id:number){
    this.router.navigate(['/update_product',id]);
  }
  deleteProduct(id:number){
    //this.router.navigate(['/delete_product',id]);
      this.productService.deleteProduct(id).subscribe(
        response=>{
          console.log(response)
        },
        error=>console.log(error)
      );
      this.productService.publishActivityEventMessage('a product with id : '+id+' has been deleted').subscribe(
        response=>{
          console.log(response)
        },
        error=>console.log(error)
      );
      this.displayProductList();
    }
  
    displayProductList(){
      this.router.navigate(['/list_products'])
    }
}
