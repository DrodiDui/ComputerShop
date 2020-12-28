import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Motherboard} from "../../model/Motherboard";
import {ApiResponse} from "../../model/ApiResponse";

@Injectable({
  providedIn: 'root'
})
export class MotherboardService {

  private path: string = `http://localhost:8090/api/motherboards`;

  constructor(private http: HttpClient) {}

  public getAllMotherboards(): Observable<Motherboard[]> {
    return this.http.get<Motherboard[]>(`${this.path}`);
  }

  public getMotherboard(motherboardName: string): Observable<Motherboard> {
    return this.http.get<Motherboard>(`${this.path}/${motherboardName}`);
  }

  public createMotherboard(motherboard: Motherboard, previewImage: File): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${this.path}`, {motherboard, previewImage});
  }

}
