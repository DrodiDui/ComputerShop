import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../service/user.service";
import {User} from "../../../model/User";
import {ActivatedRoute} from "@angular/router";
import {TokenStorageService} from "../../../service/token-storage.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: User;
  private id: number;

  constructor(
    private userService: UserService,
    private tokenStorage: TokenStorageService
  ) {
    this.user = new User();
  }

  ngOnInit() {

    this.id = this.tokenStorage.getId;
    this.userService.getProfile(this.id).subscribe(data => {
      this.user = data;
    })

  }

}
