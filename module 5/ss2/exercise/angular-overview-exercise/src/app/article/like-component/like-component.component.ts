import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-like-component',
  templateUrl: './like-component.component.html',
  styleUrls: ['./like-component.component.css']
})
export class LikeComponentComponent implements OnInit {

  like : number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  increaseLike () : void {
    this.like++;
  }

}
