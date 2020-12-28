import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SecretQuestionService {

  path: string = `http://localhost:8090/api/secret-questions`

  constructor(private http: HttpClient) { }

  public getAllQuestions(): Observable<string[]> {
    return this.http.get<string[]>(`${this.path}`);
  }

}
