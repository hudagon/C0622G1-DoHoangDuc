import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  firstNumber: number = 0;
  secondNumber: number = 0;
  result: string = 'nothing';

  constructor() {
  }

  ngOnInit(): void {
  }

  add() {
    this.result = String((+this.firstNumber + +this.secondNumber));
  }

  subtract() {
    this.result = String(this.firstNumber - this.secondNumber);
  }

  multiply() {
    this.result = String(this.firstNumber * this.secondNumber);
  }

  divide() {
    if (this.secondNumber == 0) {
      this.result = "Can't be divided!"
    } else {
      this.result = String(this.firstNumber / this.secondNumber);
    }
  }


}
