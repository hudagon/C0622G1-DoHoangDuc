function kiemtra() {
    let weight = parseInt(document.getElementById("weight").value);
    let height = parseFloat(document.getElementById("height").value);
    let bmi = weight / (height * height);
    let result;
    if (bmi  < 18.5) {
        result = "Bạn Underweight";
    } else if (bmi < 25 && bmi >= 18.5) {
        result = "Bạn bình thường";
    } else if (bmi < 30 && bmi >= 25) {
        result = "Bạn Overweight";
    } else {
        result = "Bạn Obese";
    }
    document.getElementById("hienthi").innerHTML = result;
}