import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/Product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsURL: string = `http://localhost:8090/api/products`;

  constructor(private http: HttpClient) { }

  public getProductByName(productName: string): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.productsURL}/${productName}`);
  }

  getProductById(productIds: number[]): Observable<Product[]> {
    return this.http.post<Product[]>(`${this.productsURL}/all`, productIds);
  }
}
