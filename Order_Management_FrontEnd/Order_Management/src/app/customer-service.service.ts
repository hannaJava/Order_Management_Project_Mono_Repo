import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private getAllUrl="http://localhost:9095/order_manage/customers/";
  private getUrlId="http://localhost:9095/order_manage/customers/id";
  private getUrlUsername="http://localhost:9095/order_manage/customers/username";
  private addUrl="http://localhost:9095/order_manage/customers/";
  private updateUrl="http://localhost:9095/order_manage/customers";
  private deleteUrl="http://localhost:9095/order_manage/customers";
  private publishUrl="http://localhost:9093/order_manage/order_activities/publish";

  constructor(private httpClient:HttpClient) { }

  getCustomersList():Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(`${this.getAllUrl}`);//(`${this.baseUrl}`);
  }

  addCustomer(customer:Customer):Observable<Customer>{
      return this.httpClient.post<Customer>(`${this.addUrl}`,customer);
  }

  getCustomerById(id:number):Observable<Customer>{
      return this.httpClient.get<Customer>(`${this.getUrlId}/${id}`);
  }
  /*getCustomerByUsername(username:string):Observable<Customer>{
    return this.httpClient.get<Customer>(`${this.getUrlUsername}/${username}`);
  }*/
  getCustomerByUsername(username:string):Observable<Customer>{
    return this.httpClient.get<Customer>(`${this.getUrlUsername}/${username}`);
  }

  updateCustomer(id:number,customer:Customer):Observable<Customer>{
      return this.httpClient.put<Customer>(`${this.updateUrl}/${id}`,customer);
  }

  deleteCustomer(id:number):Observable<Customer>{
    return this.httpClient.delete<Customer>(`${this.deleteUrl}/${id}`);
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
