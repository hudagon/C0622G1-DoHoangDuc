import {Component, OnInit} from '@angular/core';
import {Dictionary} from "../../model/dictionary";
import {DictionaryService} from 'src/app/service/dictionary.service';
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  dictionaryView: Dictionary;
  index: number;

  constructor(
    private dictionaryService: DictionaryService,
    private activateRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.activateRoute.params.subscribe(
      (params: Params) => {
        this.index = params.index;
        this.dictionaryView = this.dictionaryService.findDictionary(this.index)
        console.log(this.dictionaryView);
        console.log(this.index);
      })
  }
}
