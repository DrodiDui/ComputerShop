import {Product} from "./Product";

export class Motherboard {

  private _id: number;
  private _numberOfMemorySlot: number;
  private _maximumMemorySize: number;
  private _maximumMemoryFrequency: number;
  private _socket: string;
  private _formFactor: string;
  private _typeOfMemory: string;
  private _product: Product;

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get numberOfMemorySlot(): number {
    return this._numberOfMemorySlot;
  }

  set numberOfMemorySlot(value: number) {
    this._numberOfMemorySlot = value;
  }

  get maximumMemorySize(): number {
    return this._maximumMemorySize;
  }

  set maximumMemorySize(value: number) {
    this._maximumMemorySize = value;
  }

  get maximumMemoryFrequency(): number {
    return this._maximumMemoryFrequency;
  }

  set maximumMemoryFrequency(value: number) {
    this._maximumMemoryFrequency = value;
  }

  get socket(): string {
    return this._socket;
  }

  set socket(value: string) {
    this._socket = value;
  }

  get formFactor(): string {
    return this._formFactor;
  }

  set formFactor(value: string) {
    this._formFactor = value;
  }

  get typeOfMemory(): string {
    return this._typeOfMemory;
  }

  set typeOfMemory(value: string) {
    this._typeOfMemory = value;
  }

  get product(): Product {
    return this._product;
  }

  set product(value: Product) {
    this._product = value;
  }
}
