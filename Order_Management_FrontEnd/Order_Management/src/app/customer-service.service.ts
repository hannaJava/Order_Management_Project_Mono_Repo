import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './customer';
import { Observable } from 'rxjs';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private getAllUrl="http://localhost:9095/order_management/customers/";
  private getUrl="http://localhost:9095/order_management/customers";
  private addUrl="http://localhost:9095/order_management/customers/";
  private updateUrl="http://localhost:9095/order_management/customers";
  private deleteUrl="http://localhost:9095/order_management/customers";
  private publishUrl="http://localhost:9093/order_manage/order_events/publish";

  constructor(private httpClient:HttpClient) { }

  getCustomersList():Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(`${this.getAllUrl}`);//(`${this.baseUrl}`);
  }

  addCustomer(customer:Customer):Observable<any>{
      return this.httpClient.post<any>(`${this.addUrl}`,customer);
  }

  getCustomerById(id:number):Observable<Customer>{
      return this.httpClient.get<Customer>(`${this.getUrl}/${id}`);
  }

  updateCustomer(id:number,customer:Customer):Observable<any>{
      return this.httpClient.put(`${this.updateUrl}/${id}`,customer);
  }

  deleteCustomer(id:number):Observable<any>{
    return this.httpClient.delete(`${this.deleteUrl}/${id}`);
  }

  publishOrderEventMessage(orderStatus:string,order:Order):Observable<Object>{
    console.log(order);
    return this.httpClient.post(`${this.publishUrl}/${orderStatus}`,order);
  }
}
