import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
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
import { ListProductCustomerComponent } from './list-product-customer/list-product-customer.component';
import { ListOrdersComponent } from './list-orders/list-orders.component';
import { ListOrderCustomerComponent } from './list-order-customer/list-order-customer.component';

const routes: Routes = [
  {path:'main_page', component:MainPageComponent},
  {path:'admin_login', component:AdminLoginComponent},
  {path:'customer_login',component:CustomerLoginComponent},
  {path:'admin_page',component:AdminPageComponent},
  {path:'customer_page',component:CustomerPageComponent},
  {path:'customer_admin',component:CustomerPageComponent},
  {path:'add_customer',component:AddCustomerComponent},
  {path:'update_customer/:id',component:UpdateCustomerComponent},
  {path:'list_customers',component:ListCustomersComponent},
  {path:'add_product',component:AddProductComponent},
  {path:'update_product/:id',component:UpdateProductComponent},
  {path:'list_products',component:ListProductsComponent},
  {path:'list_products_customer',component:ListProductCustomerComponent},
  {path:'add_order',component:AddOrderComponent},
  {path:'update_order/:id',component:UpdateOrderComponent},
  {path:'list_orders',component:ListOrdersComponent},
  {path:'list_orders_customer',component:ListOrderCustomerComponent},
  {path:'',redirectTo:'main_page',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }