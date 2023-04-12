import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  private getAllUrl="http://localhost:9096/order_manage/products/";
  private getUrl="http://localhost:9096/order_manage/products";
  private addUrl="http://localhost:9096/order_manage/products/";
  private updateUrl="http://localhost:9096/order_manage/products";
  private deleteUrl="http://localhost:9096/order_manage/products";
  private publishUrl="http://localhost:9093/order_manage/order_activities/publish";

  constructor(private httpClient:HttpClient) { }

  getProductsList():Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.getAllUrl}`);//(`${this.baseUrl}`);
  }

  addProduct(product:Product):Observable<any>{
      return this.httpClient.post<any>(`${this.addUrl}`,product);
  }

  getProductById(id:number):Observable<Product>{
      return this.httpClient.get<Product>(`${this.getUrl}/${id}`);
  }

  updateProduct(id:number,product:Product):Observable<any>{
      return this.httpClient.put(`${this.updateUrl}/${id}`,product);
  }

  deleteProduct(id:number):Observable<any>{
    return this.httpClient.delete(`${this.deleteUrl}/${id}`);
  }

  publishActivityEventMessage(event:string):Observable<Object>{
    console.log(event);
    return this.httpClient.post(`${this.publishUrl}`,event);
  }

  /*publishOrderEventMessage(orderStatus:string,order:Order):Observable<Object>{
    console.log(order);
    return this.httpClient.post(`${this.publishUrl}/${orderStatus}`,order);
  }*/
}
