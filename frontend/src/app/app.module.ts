import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './components/shared/login/login.component';
import {RegistrationComponent} from './components/shared/registration/registration.component';
import {FormsModule} from "@angular/forms";
import {AuthService} from "./service/auth.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {TokenStorageService} from "./service/token-storage.service";
import {ProfileComponent} from './components/profile/profile/profile.component';
import {UserService} from "./service/user.service";
import {AuthInterceptor} from "./security/AuthInterceptor";
import { HomePageComponent } from './components/shared/home-page/home-page.component';
import { MotherboardInfoComponent } from './components/product/motherboard/motherboard-info/motherboard-info.component';
import { MotherboardCreationComponent } from './components/product/motherboard/motherboard-creation/motherboard-creation.component';
import {MotherboardListComponent} from "./components/product/motherboard/motherboard-list/motherboard-list.component";
import { OrderComponent } from './components/for-auth-users/order/order.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    ProfileComponent,
    HomePageComponent,
    MotherboardInfoComponent,
    MotherboardCreationComponent,
    MotherboardListComponent,
    OrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AuthService,
    TokenStorageService,
    UserService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
