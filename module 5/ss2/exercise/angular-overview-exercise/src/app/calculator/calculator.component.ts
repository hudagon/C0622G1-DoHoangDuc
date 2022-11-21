import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  firstNumber: number = 0;
  secondNumber: number = 0;
  result: number = 0;

  constructor() {
  }

  ngOnInit(): void {
  }

  add() {
    this.result = (+this.firstNumber + +this.secondNumber);
  }

  subtract() {
    this.result = this.firstNumber - this.secondNumber;
  }

  multiply() {
    this.result = this.firstNumber * this.secondNumber;
  }

  divide() {
    this.result = this.firstNumber / this.secondNumber;
  }


}
