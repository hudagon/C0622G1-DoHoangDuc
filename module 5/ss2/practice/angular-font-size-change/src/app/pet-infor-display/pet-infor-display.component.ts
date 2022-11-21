import { Component, OnInit } from '@angular/core';
import { Pet } from '../pet';

@Component({
  selector: 'app-pet-infor-display',
  templateUrl: './pet-infor-display.component.html',
  styleUrls: ['./pet-infor-display.component.css']
})
export class PetInforDisplayComponent implements OnInit {

  pet : Pet = {
    name : 'puppy',
    image: 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg'
  }

  constructor() { }

  ngOnInit(): void {
  }

}
