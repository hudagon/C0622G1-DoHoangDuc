function changemoney() {
    let dauvao = document.getElementById("dauvao").value
    let from = document.getElementById("from").value
    let to = document.getElementById("to").value
    let result;

    if (from == "USD" && to == "VND") {
        result = "Result: " + (dauvao*23000) + " Đ"
    }
    else if (from == "VND" && to == "USD") {
        result = "Result: " + (dauvao/23000) + " $"
    }
    else if (from == "VND" && to == "VND") {
        result = "Result: " + dauvao + " Đ"
    }
    else {
        result = "Result: " + dauvao + " $"
    }
    document.getElementById("result").innerHTML = result;
}