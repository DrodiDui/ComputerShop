import { Injectable } from '@angular/core';

const PRODUCT_IDS: string = 'products';

@Injectable({
  providedIn: 'root'
})
export class BasketService {

  private productIds: number[];

  constructor() {
  }

  public addNewProduct(productId: number) {
    this.productIds.push(productId);
    localStorage.setItem(PRODUCT_IDS, JSON.stringify(this.productIds));
  }

  public getProductsIds(): number[] {
    return JSON.parse(localStorage.getItem(PRODUCT_IDS));
  }

  public removeProduct(productId: number) {
    const index: number = this.productIds.indexOf(productId);
    if (index !== -1) {
      this.productIds.splice(index, 1);
    }
  }

  public isEmpty(): boolean {
    return this.getProductsIds().length === 0;
  }

  clear() {
    localStorage.clear();
  }
}
