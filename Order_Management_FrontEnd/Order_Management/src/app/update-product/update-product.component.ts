import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductServiceService } from '../product-service.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit{
  product:Product=new Product;

  id:number=0;
  constructor(private productService:ProductServiceService, 
    private route:ActivatedRoute, private router:Router){

  }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.productService.getProductById(this.id).subscribe(
        response=>  {
          this.product=response
              },
          error=>console.log(error) 
    );
  }

  onSubmit(){
    console.log(this.product);
    this.updateOrder(this.id,this.product);
    this.displayOrderList();
  }

  displayOrderList(){
    this.router.navigate(['/list_products'])
  }

  updateOrder(id:number,prodcut:Product){
    this.productService.updateProduct(id,this.product).subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error) 
    );
    console.log('a product with id : '+this.product.id+' has been updated');
    this.productService.publishActivityEventMessage('a product with id : '+this.product.id+' has been updated').subscribe(
      response=>{
        console.log(response)
      },
      error=>console.log(error)
    );
  }

}
