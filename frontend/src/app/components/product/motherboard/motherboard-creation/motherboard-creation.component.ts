import { Component, OnInit } from '@angular/core';
import {MotherboardService} from "../../../../service/product/motherboard.service";
import {Motherboard} from "../../../../model/Motherboard";
import {ApiResponse} from "../../../../model/ApiResponse";
import {SocketService} from "../../../../service/product/details/socket.service";
import {MotherboardFormFactorService} from "../../../../service/product/details/motherboard-form-factor.service";
import {MotherboardMemoryTypeService} from "../../../../service/product/details/motherboard-memory-type.service";
import {ProductCategoryService} from "../../../../service/product-category.service";
import {ProductStatusService} from "../../../../service/product/details/product-status.service";

@Component({
  selector: 'app-motherboard-creation',
  templateUrl: './motherboard-creation.component.html',
  styleUrls: ['./motherboard-creation.component.css']
})
export class MotherboardCreationComponent {

  private motherboard: Motherboard;
  private previewImage: File;
  private response: ApiResponse;
  private sockets: string[];
  private formFactors: string[];
  private memoryTypes: string[];
  private productCategories: string[];
  private productStatuses: string[];

  constructor(
    private motherboardService: MotherboardService,
    private socketService: SocketService,
    private formFactorService: MotherboardFormFactorService,
    private memoryTypeService: MotherboardMemoryTypeService,
    private productCategoryService: ProductCategoryService,
    private productStatusService: ProductStatusService
  ) {
    this.motherboard = new Motherboard();
    this.init()
  }

  save() {
    this.motherboardService.createMotherboard(this.motherboard, this.previewImage).subscribe(data => {
      this.response = data;
    })
  }

  init() {
    this.socketService.getAllSocketNames().subscribe(data => {this.sockets = data;});
    this.formFactorService.getAllFormFactors().subscribe(data => {this.formFactors = data});
    this.memoryTypeService.getAllMemoryTypeNames().subscribe(data => {this.memoryTypes = data});
    this.productCategoryService.getAllProductCategories().subscribe(data => {this.productCategories = data});
    this.productStatusService.getAllStatusNames().subscribe(data => {this.productStatuses = data});
  }

}
