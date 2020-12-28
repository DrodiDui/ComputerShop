import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/User";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  path: string = `http://localhost:8090/api/users`

  constructor(private http: HttpClient) { }

  public getProfile(id: number): Observable<User>{
    return this.http.get<User>(`${this.path}/${id}`);
  }

}
