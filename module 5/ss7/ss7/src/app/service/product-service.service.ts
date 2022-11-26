import {Injectable} from '@angular/core';
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  product: Product;

  productList: Product[] = [
    {
      id: 1,
      name: 'IPhone 12',
      price: 2400000,
      description: 'New'
    }, {
      id: 2,
      name: 'IPhone 11',
      price: 1560000,
      description: 'Like new'
    }, {
      id: 3,
      name: 'IPhone X',
      price: 968000,
      description: '97%'
    }, {
      id: 4,
      name: 'IPhone 8',
      price: 7540000,
      description: '98%'
    }, {
      id: 5,
      name: 'IPhone 11 Pro',
      price: 1895000,
      description: 'Like new'
    }
  ];

  constructor() {
  }

  getAll() {
    return this.productList;
  }

  addNewProduct(newProduct: Product) {
    this.productList.push(newProduct);
  }

  findProductById(productId: number) {
    for (let x of this.productList) {
      if (x.id == productId) {
        this.product = x;
      }
    }
    return this.product;
  }

  editProduct(productEdit: Product) {
    for (let i = 0; i < this.productList.length; i++) {
      if (this.productList[i].id == productEdit.id) {
        this.productList[i] = productEdit;
      }
    }
  }

  deleteProduct(productId: number) {
    console.log(productId)
    for (let i = 0; i < this.productList.length; i++) {
      if (this.productList[i].id == productId) {
        this.productList.splice(i,1);
        console.log('ok')
      }
    }
    console.log(this.productList)
  }

}
