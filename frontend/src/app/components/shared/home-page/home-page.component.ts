import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../../service/product.service";
import {Product} from "../../../model/Product";
import {ProductCategoryService} from "../../../service/product-category.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  private productName: string;
  private products: Product[];
  private productCategories: string[];

  constructor(
    private productService: ProductService,
    private productCategoryService: ProductCategoryService
  ) { }

  ngOnInit() {
    this.productCategoryService.getAllProductCategories().subscribe(data => {
      this.productCategories = data;
    })
  }

  search() {
    this.productService.getProductByName(this.productName).subscribe(data => {
      this.products = data;
    })
  }

}
