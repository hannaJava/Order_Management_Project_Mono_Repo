import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private getAllUrl="http://localhost:9097/order_management/orders/";
  private getUrl="http://localhost:9097/order_management/orders";
  private addUrl="http://localhost:9097/order_management/orders/";
  private updateUrl="http://localhost:9097/order_management/orders";
  private deleteUrl="http://localhost:9097/order_management/orders";
  private publishUrl="http://localhost:9093/order_manage/order_events/publish";

  constructor(private httpClient:HttpClient) { }

  getOrdersList():Observable<Order[]>{
    return this.httpClient.get<Order[]>(`${this.getAllUrl}`);//(`${this.baseUrl}`);
  }

  addOrder(order:Order):Observable<any>{
      return this.httpClient.post<any>(`${this.addUrl}`,order);
  }

  getOrderById(id:number):Observable<Order>{
      return this.httpClient.get<Order>(`${this.getUrl}/${id}`);
  }

  updateOrder(id:number,order:Order):Observable<any>{
      return this.httpClient.put(`${this.updateUrl}/${id}`,order);
  }

  deleteOrder(id:number):Observable<any>{
    return this.httpClient.delete(`${this.deleteUrl}/${id}`);
  }

  publishOrderEventMessage(orderStatus:string,order:Order):Observable<Object>{
    console.log(order);
    return this.httpClient.post(`${this.publishUrl}/${orderStatus}`,order);
  }
}
