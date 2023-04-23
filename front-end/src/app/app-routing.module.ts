import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DefaultPageNotFoundComponent } from './components/default-page-not-found/default-page-not-found.component';
import { GuestAddComponent } from './components/guest-management/guest-add/guest-add.component';
import { GuestDetailsComponent } from './components/guest-management/guest-details/guest-details.component';
import { GuestListComponent } from './components/guest-management/guest-list/guest-list.component';
import { GuestUpdateComponent } from './components/guest-management/guest-update/guest-update.component';
import { HomeComponent } from './components/home/home.component';
import { CategoryAddComponent } from './components/inventory-management/category/category-add/category-add.component';
import { CategoryListComponent } from './components/inventory-management/category/category-list/category-list.component';
import { CategoryUpdateComponent } from './components/inventory-management/category/category-update/category-update.component';
import { ProductAddComponent } from './components/inventory-management/product/product-add/product-add.component';
import { ProductListComponent } from './components/inventory-management/product/product-list/product-list.component';
import { ProductUpdateComponent } from './components/inventory-management/product/product-update/product-update.component';
import { LoginComponent } from './components/login/login.component';
import { RazorpayGatewayComponent } from './components/razorpay-gateway/razorpay-gateway.component';
import { ReservationAddComponent } from './components/reservation-management/reservation/reservation-add/reservation-add.component';
import { ReservationDetailsComponent } from './components/reservation-management/reservation/reservation-details/reservation-details.component';
import { ReservationListComponent } from './components/reservation-management/reservation/reservation-list/reservation-list.component';
import { ReservationUpdateComponent } from './components/reservation-management/reservation/reservation-update/reservation-update.component';
import { RoomAddComponent } from './components/reservation-management/room/room-add/room-add.component';
import { RoomListComponent } from './components/reservation-management/room/room-list/room-list.component';
import { RoomUpdateComponent } from './components/reservation-management/room/room-update/room-update.component';
import { StaffAddComponent } from './components/staff-management/staff-add/staff-add.component';
import { StaffDetailsComponent } from './components/staff-management/staff-details/staff-details.component';
import { StaffListComponent } from './components/staff-management/staff-list/staff-list.component';
import { StaffUpdateComponent } from './components/staff-management/staff-update/staff-update.component';

const routes: Routes = [
  {path: 'guest/list', component: GuestListComponent},
  {path: 'guest/add', component: GuestAddComponent},
  {path: 'guest/update/:memberCode', component: GuestUpdateComponent},
  {path: 'guest/details/:memberCode', component: GuestDetailsComponent},

  {path: 'staff/list', component: StaffListComponent},
  {path: 'staff/add', component: StaffAddComponent},
  {path: 'staff/update/:employeeCode', component: StaffUpdateComponent},
  {path: 'staff/details/:employeeCode', component: StaffDetailsComponent},

  {path: 'inventory/category/list', component: CategoryListComponent},
  {path: 'inventory/category/add', component: CategoryAddComponent},
  {path: 'inventory/category/update/:categoryID', component: CategoryUpdateComponent},

  {path: 'inventory/product/list', component: ProductListComponent},
  {path: 'inventory/product/add', component: ProductAddComponent},
  {path: 'inventory/product/update/:productID', component: ProductUpdateComponent},

  {path: 'reservation/list', component: ReservationListComponent},
  {path: 'reservation/add', component: ReservationAddComponent},
  {path: 'reservation/update/:bookingID', component: ReservationUpdateComponent},
  {path: 'reservation/details/:bookingID', component: ReservationDetailsComponent},

  {path: 'reservation/room/list', component: RoomListComponent},
  {path: 'reservation/room/add', component: RoomAddComponent},
  {path: 'reservation/room/update/:roomNumber', component: RoomUpdateComponent},

  {path: 'payment/createOrder', component: RazorpayGatewayComponent},

  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: '**', component: DefaultPageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
