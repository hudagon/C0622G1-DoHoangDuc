"use strict";
function displayAndSumFibonacci(number) {
    let fiboArr = [0, 1];
    let sum = 1;
    while (number > fiboArr.length) {
        let c = 0;
        c = fiboArr[fiboArr.length - 2] + fiboArr[fiboArr.length - 1];
        sum += c;
        fiboArr.push(c);
    }
    return "Fibonacci line is - " + fiboArr.toString() + " and the sum of its is: " + sum;
}
console.log(displayAndSumFibonacci(20));
