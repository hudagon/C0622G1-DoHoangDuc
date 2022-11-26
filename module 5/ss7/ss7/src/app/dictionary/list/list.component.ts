import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../../service/dictionary.service";
import {Dictionary} from "../../model/dictionary";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  dictionaryList: Dictionary[];

  constructor(
    private dictionaryService: DictionaryService
  ) { }

  ngOnInit(): void {
    this.dictionaryList = this.dictionaryService.getALl();
  }

}
