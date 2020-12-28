export class OrderDTO {

  private _userId: number;
  private _productId: number[];
  private _paymentMethod: string;


  get userId(): number {
    return this._userId;
  }

  set userId(value: number) {
    this._userId = value;
  }


  get productId(): number[] {
    return this._productId;
  }

  set productId(value: number[]) {
    this._productId = value;
  }

  get paymentMethod(): string {
    return this._paymentMethod;
  }

  set paymentMethod(value: string) {
    this._paymentMethod = value;
  }
}
