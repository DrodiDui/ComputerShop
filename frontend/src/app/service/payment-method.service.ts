import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PaymentMethodService {

  private readonly paymentMethodUrl: string;

  constructor(private http: HttpClient) {
    this.paymentMethodUrl = `http://localhost:8090/api/payment-methods`;
  }

  public getAllPaymentMethodNames(): Observable<string[]> {
    return this.http.get<string[]>(`${this.paymentMethodUrl}`);
  }
}
