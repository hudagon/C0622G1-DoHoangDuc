import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  listFlag: boolean = false;
  createFlag: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  toggleCreate() {
    this.createFlag = !this.createFlag;
  }

  toggleList() {
    this.listFlag = !this.createFlag;
  }
}
