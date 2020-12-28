import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./components/shared/login/login.component";
import {RegistrationComponent} from "./components/shared/registration/registration.component";
import {ProfileComponent} from "./components/profile/profile/profile.component";
import {HomePageComponent} from "./components/shared/home-page/home-page.component";
import {MotherboardInfoComponent} from "./components/product/motherboard/motherboard-info/motherboard-info.component";
import {MotherboardListComponent} from "./components/product/motherboard/motherboard-list/motherboard-list.component";
import {MotherboardCreationComponent} from "./components/product/motherboard/motherboard-creation/motherboard-creation.component";
import {OrderComponent} from "./components/for-auth-users/order/order.component";


const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: RegistrationComponent},
  {path: 'profile/:id', component: ProfileComponent},
  {path: 'motherboards', component: MotherboardListComponent},
  {path: 'motherboards/:name', component: MotherboardInfoComponent},
  {path: 'motherboard/create', component: MotherboardCreationComponent},
  {path: 'orders', component: OrderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
