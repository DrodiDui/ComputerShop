export class Product {

  private _id: number;
  private _productName: string;
  private _description: string;
  private _price: number;
  private _model: string;
  private _brand: string;
  private _ageOfRelease: string;
  private _countInStock: number;
  private _productCategory: string;
  private _productStatus: string;
  private _previewImage: File;

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get previewImage(): File {
    return this._previewImage;
  }

  set previewImage(value: File) {
    this._previewImage = value;
  }

  get productName(): string {
    return this._productName;
  }

  set productName(value: string) {
    this._productName = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }

  get model(): string {
    return this._model;
  }

  set model(value: string) {
    this._model = value;
  }

  get brand(): string {
    return this._brand;
  }

  set brand(value: string) {
    this._brand = value;
  }

  get ageOfRelease(): string {
    return this._ageOfRelease;
  }

  set ageOfRelease(value: string) {
    this._ageOfRelease = value;
  }

  get countInStock(): number {
    return this._countInStock;
  }

  set countInStock(value: number) {
    this._countInStock = value;
  }

  get productCategory(): string {
    return this._productCategory;
  }

  set productCategory(value: string) {
    this._productCategory = value;
  }

  get productStatus(): string {
    return this._productStatus;
  }

  set productStatus(value: string) {
    this._productStatus = value;
  }
}
