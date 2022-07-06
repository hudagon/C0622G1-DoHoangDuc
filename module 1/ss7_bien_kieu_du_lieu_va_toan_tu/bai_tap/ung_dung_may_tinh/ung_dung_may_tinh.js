function thuchienpheptoancong() {
    let number1 = parseInt(document.getElementById("number1").value);
    let number2 = parseInt(document.getElementById("number2").value);
    let result = number1 + number2
    document.getElementById("result").innerHTML = result;
}
function thuchienpheptoantru() {
    let number1 = parseInt(document.getElementById("number1").value);
    let number2 = parseInt(document.getElementById("number2").value);
    let result = number1 - number2
    document.getElementById("result").innerHTML = result;
}
function thuchienpheptoannhan() {
    let number1 = parseInt(document.getElementById("number1").value);
    let number2 = parseInt(document.getElementById("number2").value);
    let result = number1 * number2
    document.getElementById("result").innerHTML = result;
}
function thuchienpheptoanchia() {
    let number1 = parseInt(document.getElementById("number1").value);
    let number2 = parseInt(document.getElementById("number2").value);
    let result = number1 / number2
    document.getElementById("result").innerHTML = result;
}