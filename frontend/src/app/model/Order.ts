import {Product} from "./Product";

export class Order {

  private _products: Product[];
  private _orderStatus: string;
  private _paymentMethod: string;


  get products(): Product[] {
    return this._products;
  }

  set products(value: Product[]) {
    this._products = value;
  }

  get orderStatus(): string {
    return this._orderStatus;
  }

  set orderStatus(value: string) {
    this._orderStatus = value;
  }

  get paymentMethod(): string {
    return this._paymentMethod;
  }

  set paymentMethod(value: string) {
    this._paymentMethod = value;
  }
}
