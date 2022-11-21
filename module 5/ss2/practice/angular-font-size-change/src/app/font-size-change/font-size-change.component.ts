import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-font-size-change',
  templateUrl: './font-size-change.component.html',
  styleUrls: ['./font-size-change.component.css']
})
export class FontSizeChangeComponent implements OnInit {

  fontSize = 100

  constructor() { }

  ngOnInit(): void {
  }

}
