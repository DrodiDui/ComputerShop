export class AuthResponse {

  private _token: string;
  private _id: number
  private _role: string;


  get token(): string {
    return this._token;
  }

  set token(value: string) {
    this._token = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get role(): string {
    return this._role;
  }

  set role(value: string) {
    this._role = value;
  }
}
