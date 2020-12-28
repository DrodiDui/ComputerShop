import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthResponse} from "../model/AuthResponse";
import {SignUpVM} from "../model/SignUpVM";
import {ApiResponse} from "../model/ApiResponse";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private path: string = 'http://localhost:8090/api/auth'

  constructor(private http: HttpClient) { }

  public login(usernameOrEmail: string, password: string): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.path}/login`, {usernameOrEmail, password});
  }

  public registration(signUp: SignUpVM): Observable<ApiResponse>{
    return this.http.post<ApiResponse>('http://localhost:8090/api/auth/registration', signUp);
  }

}
