import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductCategoryService {

  private path: string = `http://localhost:8090/api/product-categories`;

  constructor(private http: HttpClient) { }

  public getAllProductCategories(): Observable<string[]> {
    return this.http.get<string[]>(`${this.path}`);
  }

}
