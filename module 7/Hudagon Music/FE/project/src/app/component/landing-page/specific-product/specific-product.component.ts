import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-specific-product',
  templateUrl: './specific-product.component.html',
  styleUrls: ['./specific-product.component.css']
})
export class SpecificProductComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  toggleThing() {
    const accordionBtn = document.querySelectorAll('[data-accordion-btn]');
    const accordion = document.querySelectorAll('[data-accordion]');

    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < accordionBtn.length; i++) {

      accordionBtn[i].addEventListener('click', function() {

        const clickedBtn = this.nextElementSibling.classList.contains('active');

        // tslint:disable-next-line:no-shadowed-variable
        for (let i = 0; i < accordion.length; i++) {

          if (clickedBtn) {
            break;
          }

          if (accordion[i].classList.contains('active')) {

            accordion[i].classList.remove('active');
            accordionBtn[i].classList.remove('active');

          }
        }

        this.nextElementSibling.classList.toggle('active');
        this.classList.toggle('active');

      });
    }
  }
}
