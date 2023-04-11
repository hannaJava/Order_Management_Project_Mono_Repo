import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
import { FormsModule } from '@angular/forms';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { CustomerPageComponent } from './customer-page/customer-page.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { DeleteCustomerComponent } from './delete-customer/delete-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { ListCustomersComponent } from './list-customers/list-customers.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { DeleteProductComponent } from './delete-product/delete-product.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { MainPageComponent } from './main-page/main-page.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { DeleteOrderComponent } from './delete-order/delete-order.component';
import { ListOrderComponent } from './list-order/list-order.component'; //ngModel
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { DasboardPageComponent } from './dasboard-page/dasboard-page.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminLoginComponent,
    CustomerLoginComponent,
    AdminPageComponent,
    CustomerPageComponent,
    AddCustomerComponent,
    DeleteCustomerComponent,
    UpdateCustomerComponent,
    ListCustomersComponent,
    AddProductComponent,
    UpdateProductComponent,
    DeleteProductComponent,
    ListProductsComponent,
    MainPageComponent,
    AddOrderComponent,
    UpdateOrderComponent,
    DeleteOrderComponent,
    ListOrderComponent,
    DasboardPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule   //ngModel
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
