import { Injectable } from '@angular/core';
import {Dictionary} from "../model/dictionary";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  dictionaryView: Dictionary;

  dictionaryList: Dictionary[] = [
    {id: '1', word: 'orange', mean: 'cam', description: 'none'},
    {id: '2', word: 'pineapple', mean: 'dứa', description: 'none'},
    {id: '3', word: 'lemon', mean: 'chanh', description: 'none'},
    {id: '4', word: 'mango', mean: 'xoài', description: 'none'},
    {id: '5', word: 'jackfruit', mean: 'mít', description: 'none'},
  ];

  constructor() { }

  getALl() {
    return this.dictionaryList;
  }

  findDictionary(index: number) {
    console.log(index)
    // @ts-ignore
    this.dictionaryView = this.dictionaryList.find(d => d.id === index);
    console.log(this.dictionaryView)
    return this.dictionaryView;
  }
}
