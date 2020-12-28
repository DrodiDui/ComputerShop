import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/auth.service";
import {Router} from "@angular/router";
import {TokenStorageService} from "../../../service/token-storage.service";
import {AuthResponse} from "../../../model/AuthResponse";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{

  usernameOrEmail: string;
  password: string;
  authResponse: AuthResponse;

  constructor(
    private authService: AuthService,
    private router: Router,
    private tokenStorage: TokenStorageService
  ) {
    this.authResponse = new AuthResponse();
  }

  login() {
    this.authService.login(this.usernameOrEmail, this.password).subscribe(data => {

      this.tokenStorage.setId = data.id;
      this.tokenStorage.setToken = data.token;
      this.tokenStorage.setRole = data.role;

      this.router.navigate(['/'])
    })
  }

}
