import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SocketService {

  private readonly baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = `http://localhost:8090/api/sockets`;
  }

  public getAllSocketNames(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}`);
  }
}
