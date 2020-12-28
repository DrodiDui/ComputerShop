import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/auth.service";
import {SignUpVM} from "../../../model/SignUpVM";
import {SecretQuestionService} from "../../../service/secret-question.service";
import {Router} from "@angular/router";
import {ApiResponse} from "../../../model/ApiResponse";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  signUpData: SignUpVM;
  questions: string[];
  response: ApiResponse;

  constructor(
    private authService: AuthService,
    private secretQuestionService: SecretQuestionService,
    private router: Router
    ) {
    this.signUpData = new SignUpVM();
    this.secretQuestionService.getAllQuestions().subscribe(data => {
      this.questions = data;
    })
    this.response = new ApiResponse();
  }

  signUp() {

    this.authService.registration(this.signUpData).subscribe(data => {
      this.response.message = data.message;
      this.router.navigate(['/login'])
    })

  }

  /*private getQuestions(){
    return  this.secretQuestionService.getAllQuestions().subscribe(data => {
      this.questions = data;
    })
  }*/

}
