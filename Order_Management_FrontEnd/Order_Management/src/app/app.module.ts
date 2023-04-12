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
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { ListCustomersComponent } from './list-customers/list-customers.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { MainPageComponent } from './main-page/main-page.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { DasboardPageComponent } from './dasboard-page/dasboard-page.component';
import { AppHeaderComponent } from './app-header/app-header.component';
import { AppMainComponent } from './app-main/app-main.component';
import { AppFooterComponent } from './app-footer/app-footer.component';
import { AdminSidebarComponent } from './admin-sidebar/admin-sidebar.component';
import { CustomerSidebarComponent } from './customer-sidebar/customer-sidebar.component';
import { ListProductCustomerComponent } from './list-product-customer/list-product-customer.component';
import { ListOrdersComponent } from './list-orders/list-orders.component';
import { ListOrderCustomerComponent } from './list-order-customer/list-order-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminLoginComponent,
    CustomerLoginComponent,
    AdminPageComponent,
    CustomerPageComponent,
    AddCustomerComponent,
    UpdateCustomerComponent,
    ListCustomersComponent,
    AddProductComponent,
    UpdateProductComponent,
    ListProductsComponent,
    MainPageComponent,
    AddOrderComponent,
    UpdateOrderComponent,
    DasboardPageComponent,
    AppHeaderComponent,
    AppMainComponent,
    AppFooterComponent,
    AdminSidebarComponent,
    CustomerSidebarComponent,
    ListProductCustomerComponent,
    ListOrdersComponent,
    ListOrderCustomerComponent
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
