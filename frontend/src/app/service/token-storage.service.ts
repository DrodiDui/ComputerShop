import { Injectable } from '@angular/core';

const USER_TOKEN: string = "token";
const USER_ID: string = "id";
const USER_ROLE: string = "role";

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  get getToken(): string {
    return localStorage.getItem(USER_TOKEN)
  }

  set setToken(value: string) {
    localStorage.removeItem(USER_TOKEN);
    localStorage.setItem(USER_TOKEN, value);
  }

  get getId(): number {
    return Number(localStorage.getItem(USER_ID));
  }

  set setId(value: number) {
    localStorage.removeItem(USER_ID);
    localStorage.setItem(USER_ID, String(value));
  }

  get getRole(): string {
    return localStorage.getItem(USER_ROLE);
  }

  set setRole(value: string) {
    localStorage.removeItem(USER_ROLE);
    localStorage.setItem(USER_ROLE, value);
  }

  isLogin(): boolean {
    if (this.getToken) {
      return true
    }
    return false;
  }

  logout() {
    localStorage.removeItem(USER_TOKEN);
    localStorage.removeItem(USER_ID);
    localStorage.removeItem(USER_ROLE);
    localStorage.clear()
  }
}
