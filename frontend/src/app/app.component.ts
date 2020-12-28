import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "./service/token-storage.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'ComputerShop';
  id: number;

  constructor(
    private tokenStorage: TokenStorageService,
    private router: Router,
    private rout: ActivatedRoute
    ) {
  }

  ngOnInit(): void {

    this.id = this.tokenStorage.getId;

  }

  isLogin(): boolean {
    return this.tokenStorage.isLogin()
  }

  logout() {
    this.tokenStorage.logout();
    this.router.navigate([this.rout])
  }

}
