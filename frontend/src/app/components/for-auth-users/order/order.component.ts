import { Component, OnInit } from '@angular/core';
import {OrderService} from "../../../service/order.service";
import {BasketService} from "../../../service/basket.service";
import {TokenStorageService} from "../../../service/token-storage.service";
import {PaymentMethodService} from "../../../service/payment-method.service";
import {OrderDTO} from "../../../model/dto/order-dto";
import {Order} from "../../../model/Order";
import {ApiResponse} from "../../../model/ApiResponse";
import {ProductService} from "../../../service/product.service";
import {Product} from "../../../model/Product";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  private payments: string[];
  private orderDTO: OrderDTO;
  private orders: Order[];
  private products: Product[];

  private paymentMethod: string;
  private response: ApiResponse;

  constructor(
    private orderService: OrderService,
    private basketService: BasketService,
    private tokenStorage: TokenStorageService,
    private paymentService: PaymentMethodService,
    private productService: ProductService
  ) {
    this.paymentService.getAllPaymentMethodNames().subscribe(data => {this.payments = data});
    this.orderDTO = new OrderDTO();
  }

  ngOnInit() {

    if (this.basketService.isEmpty()) {
      this.orderService.getAllOrders(this.tokenStorage.getId).subscribe(data => {
        this.orders = data;
      })
    }
    this.productService.getProductById(this.basketService.getProductsIds()).subscribe(data => {
      this.products = data;
    });
  }

  createOrder() {
    this.orderDTO.paymentMethod = this.paymentMethod;
    this.orderDTO.userId = this.tokenStorage.getId;
    this.orderDTO.productId = this.basketService.getProductsIds();
    this.orderService.createOrder(this.orderDTO).subscribe(data => {
      this.response = data;
      this.basketService.clear();
    });
  }

  deleteProduct(productId: number) {
    this.basketService.removeProduct(productId);
  }

}
