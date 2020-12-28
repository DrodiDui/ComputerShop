import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ApiResponse} from "../model/ApiResponse";
import {OrderDTO} from "../model/dto/order-dto";
import {Order} from "../model/Order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private orderUrl: string = `http://localhost:8090/api/orders`;

  constructor(private http: HttpClient) { }

  public createOrder(orderDTO: OrderDTO):Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${this.orderUrl}`, orderDTO);
  }

  public getAllOrders(userId: number): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.orderUrl}/${userId}`);
  }
}
