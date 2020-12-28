import { Component, OnInit } from '@angular/core';
import {Motherboard} from "../../../../model/Motherboard";
import {MotherboardService} from "../../../../service/product/motherboard.service";
import {ActivatedRoute} from "@angular/router";
import {TokenStorageService} from "../../../../service/token-storage.service";
import {BasketService} from "../../../../service/basket.service";

@Component({
  selector: 'app-motherboard-info',
  templateUrl: './motherboard-info.component.html',
  styleUrls: ['./motherboard-info.component.css']
})
export class MotherboardInfoComponent implements OnInit {

  private motherboard: Motherboard;
  private productName: string;
  private viewOrder: boolean = false;

  constructor(
    private motherboardService: MotherboardService,
    private basketService: BasketService,
    private rout: ActivatedRoute,
    private tokenStorage: TokenStorageService
    ) { }

  ngOnInit() {
    this.productName = this.rout.snapshot.params['name'];
    this.motherboardService.getMotherboard(this.productName).subscribe(data => {
      this.motherboard = data;
    })
  }

  addToBasket() {
    this.basketService.addNewProduct(this.motherboard.product.id);
  }

  private OrderView(){
    if (
      this.motherboard.product.countInStock != 0 &&
      this.motherboard.product.productStatus === 'in stock' &&
      this.tokenStorage.isLogin()
    ) {
      this.viewOrder = true
    }
  }
}
