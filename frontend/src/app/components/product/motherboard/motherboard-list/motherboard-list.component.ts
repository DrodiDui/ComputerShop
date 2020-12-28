import { Component, OnInit } from '@angular/core';
import {Motherboard} from "../../../../model/Motherboard";
import {MotherboardService} from "../../../../service/product/motherboard.service";

@Component({
  selector: 'app-motherboard-list',
  templateUrl: './motherboard-list.component.html',
  styleUrls: ['./motherboard-list.component.css']
})
export class MotherboardListComponent implements OnInit {

  private motherboards: Motherboard[];

  constructor(private motherboardService: MotherboardService) { }

  ngOnInit() {

    this.motherboardService.getAllMotherboards().subscribe(data => {
      this.motherboards = data;
    })

  }

}
