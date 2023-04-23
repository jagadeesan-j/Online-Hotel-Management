import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GuestListComponent } from './components/guest-management/guest-list/guest-list.component';
import { MaterialModule } from './components/material/material.module';
import { GuestAddComponent } from './components/guest-management/guest-add/guest-add.component';
import { FormsModule } from '@angular/forms';
import { GuestUpdateComponent } from './components/guest-management/guest-update/guest-update.component';
import { DefaultPageNotFoundComponent } from './components/default-page-not-found/default-page-not-found.component';
import { GuestDetailsComponent } from './components/guest-management/guest-details/guest-details.component';
import { CategoryListComponent } from './components/inventory-management/category/category-list/category-list.component';
import { CategoryAddComponent } from './components/inventory-management/category/category-add/category-add.component';
import { CategoryUpdateComponent } from './components/inventory-management/category/category-update/category-update.component';
import { ProductListComponent } from './components/inventory-management/product/product-list/product-list.component';
import { ProductAddComponent } from './components/inventory-management/product/product-add/product-add.component';
import { ProductUpdateComponent } from './components/inventory-management/product/product-update/product-update.component';
import { ReservationListComponent } from './components/reservation-management/reservation/reservation-list/reservation-list.component';
import { ReservationAddComponent } from './components/reservation-management/reservation/reservation-add/reservation-add.component';
import { ReservationUpdateComponent } from './components/reservation-management/reservation/reservation-update/reservation-update.component';
import { ReservationDetailsComponent } from './components/reservation-management/reservation/reservation-details/reservation-details.component';
import { RoomListComponent } from './components/reservation-management/room/room-list/room-list.component';
import { RoomAddComponent } from './components/reservation-management/room/room-add/room-add.component';
import { RoomUpdateComponent } from './components/reservation-management/room/room-update/room-update.component';
import { StaffListComponent } from './components/staff-management/staff-list/staff-list.component';
import { StaffAddComponent } from './components/staff-management/staff-add/staff-add.component';
import { StaffUpdateComponent } from './components/staff-management/staff-update/staff-update.component';
import { StaffDetailsComponent } from './components/staff-management/staff-details/staff-details.component';
import { RazorpayGatewayComponent } from './components/razorpay-gateway/razorpay-gateway.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    GuestListComponent,
    GuestAddComponent,
    GuestUpdateComponent,
    DefaultPageNotFoundComponent,
    GuestDetailsComponent,
    CategoryListComponent,
    CategoryAddComponent,
    CategoryUpdateComponent,
    ProductListComponent,
    ProductAddComponent,
    ProductUpdateComponent,
    ReservationListComponent,
    ReservationAddComponent,
    ReservationUpdateComponent,
    ReservationDetailsComponent,
    RoomListComponent,
    RoomAddComponent,
    RoomUpdateComponent,
    StaffListComponent,
    StaffAddComponent,
    StaffUpdateComponent,
    StaffDetailsComponent,
    RazorpayGatewayComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
