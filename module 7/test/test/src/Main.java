import java.util.*;

public class Main {
    public static void main(String[] args) {

        swapAAndBWithoutTemp();

    }

    public static String convertFromDeciToOctal(Integer number) {

        Integer atFirstNumber = number;
        StringBuilder result = new StringBuilder();

        do {

            Integer phanDu = number % 8;

            result.insert(0, phanDu);

            number = number / 8;

        } while (number != 0);

        return "Đổi " + atFirstNumber + " từ hệ cơ số 10 sang 8: " + result;
    }

    public static String convertFromOctalToDeci(Integer number) {

        String numberString = String.valueOf(number);

        List<String> numberArray = Arrays.asList(numberString.split(""));
        Integer result = 0;
        Integer exponent;

        for (int i = numberArray.size() - 1; i >= 0; i--) {

            exponent = numberArray.size() - i - 1;

            result += Integer.parseInt(numberArray.get(i)) * (int) (Math.pow(8, exponent));

        }

        return "--------------------------------------------- Đổi " + number + " từ hệ cơ số 8 sang 10: " + result;
    }

    public static String sumOf2TimeString() {

        String str1 = "11:20:30";
        String str2 = "07:35:45";
        String str3 = "";
        String[] arr1 = str1.split(":");
        String[] arr2 = str2.split(":");
        int time1 = Integer.parseInt(arr1[0]) * 3600 + Integer.parseInt(arr1[1]) * 60 + Integer.parseInt(arr1[2]);
        int time2 = Integer.parseInt(arr2[0]) * 3600 + Integer.parseInt(arr2[1]) * 60 + Integer.parseInt(arr2[2]);
        int time3 = time1 + time2;
        int hour = time3 / 3600;
        int minute = (time3 - hour * 3600) / 60;
        int second = time3 - (hour * 3600 + minute * 60);
        str3 = (hour < 10 ? "0" : "") + hour + ":" + (minute < 10 ? "0" : "") + minute + ":" +
                (second < 10 ? "0" : "") + second;
        return str3;

    }

    public static void findPosition(Integer number) {

        Integer fisrtPosition;
        Integer secondPosition;
        Integer sum;
        Map<Integer, Integer> postionCorrect = new HashMap<>();

        List<Integer> listNumbers = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            listNumbers.add((int) (Math.random() * (10 + 1) + 0));
            System.out.println(listNumbers.get(i));
        }

        for (int i = 0; i < listNumbers.size(); i++) {

            for (int j = i + 1; j < listNumbers.size(); j++) {

                sum = listNumbers.get(i) + listNumbers.get(j);

                if (sum.equals(number)) {
                    fisrtPosition = i;
                    secondPosition = j;
                    postionCorrect.put(i, j);
                }
            }
        }

        if (postionCorrect.isEmpty()) {
            System.out.println("Không tìm thấy cặp số hợp lệ");
        }

        for (Integer x : postionCorrect.keySet()) {
            System.out.println("Số thứ nhất ở vị trí: " + x + ", số thứ hai ở vị trí: " + postionCorrect.get(x));
        }
    }

    public static void convertRomanNumber(String romanNumericString) {

        Map<String, Integer> romanNumeric = new HashMap<>();
        List<String> romanNumeralsStringList = Arrays.asList(romanNumericString.split(""));
        Integer sum = 0;
        Integer firstNumber;
        Integer secondNumber = 0;

        romanNumeric.put("I", 1);
        romanNumeric.put("V", 5);
        romanNumeric.put("X", 10);
        romanNumeric.put("L", 50);
        romanNumeric.put("C", 100);
        romanNumeric.put("D", 500);
        romanNumeric.put("M", 1000);

        for (int i = 0; i < romanNumeralsStringList.size(); i++) {

            if (romanNumeralsStringList.size() == 1) {
                sum += romanNumeric.get(romanNumeralsStringList.get(i));
                break;
            }

            firstNumber = romanNumeric.get(romanNumeralsStringList.get(i));

            if (!(firstNumber == romanNumeric.get(romanNumeralsStringList.get(romanNumeralsStringList.size() - 1)))) {
                secondNumber = romanNumeric.get(romanNumeralsStringList.get(i + 1));
            }

            if (firstNumber < secondNumber) {
                sum += secondNumber - firstNumber;
                i++;
            } else {
                sum += firstNumber;
            }
        }

        System.out.println(sum);
    }

    public static void countAppearTime(String testString) {

        List<String> testStringList = Arrays.asList(testString.split(""));
        Map<String, Integer> result = new HashMap<>();
        Integer newValue;

        for (String x : testStringList) {

            if (result.get(x) != null) {
                newValue = result.get(x) + 1;
                result.put(x, newValue);
            }

            result.putIfAbsent(x, 1);
        }

        for (String x : result.keySet()) {
            System.out.println("Ký tự: " + x + ", Xuất hiện: " + result.get(x) + " lần.");
        }
    }

    public static void sortAscString(String testString) {

        String[] testStringList = (testString.split(""));
        String temp = "";

        for (int i = 0; i < testStringList.length; i++) {

            for (int j = i + 1; j < testStringList.length; j++) {
                if (testStringList[i].compareTo(testStringList[j]) > 0) {
                    temp = testStringList[i];
                    testStringList[i] = testStringList[j];
                    testStringList[j] = temp;
                }
            }
        }

        String newStr = "";
        for (String x : testStringList) {
            newStr += x;
        }

        System.out.println(newStr);
    }

    public static void findOverlapNumbers() {

        int[] arrNum1 = {1, 2, 1, 3, 5};
        int[] arrNum2 = {1, 2, 4, 6, 5};

        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arrNum1.length; i++) {
            for (int j = 0; j < arrNum2.length; j++) {
                map.put(arrNum1[i], count);
                if (arrNum1[i] == arrNum2[j]) {
                    count++;
                    map.put(arrNum2[i], count);
                }
            }
            count = 0;
        }
        System.out.println("Phan tu trung là: ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey());
            }
        }

    }

    public static void stringManipulator(String str) {
        str = str.replaceAll(",", "");
        String[] arr = str.split(" ");
        String key = "";
        Integer value;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            if (map.containsKey(key)) {
                value = map.get(key);
                map.remove(key);
                map.put(key, value + 1);
            } else {
                map.put(key, new Integer(1));
            }
        }

        Set set = map.keySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            key = (String) i.next();
            System.out.println("Từ '" + key + "' xuất hiện " + map.get(key) + " lần");
        }
    }

    public static void testWhileAndDoWhile() {


    }

    public static void arraysManipulator(String str) {

        List<String> stringList = Arrays.asList(str.split(" "));
        Map<String, Integer> stringIntegerMap = new LinkedHashMap<>();
        Integer temp;

        for (String x : stringList) {

            if (stringIntegerMap.get(x) != null) {
                temp = stringIntegerMap.get(x) + 1;
                stringIntegerMap.put(x, temp);
            }

            stringIntegerMap.putIfAbsent(x, 1);

        }

        for (String x : stringIntegerMap.keySet()) {
            System.out.println("Từ: " + x + ", xuất hiện " + stringIntegerMap.get(x) + " lần!");
        }

    }

    public static void reverseNumber() {
        Scanner sc = new Scanner(System.in);
        //khai báo biến num1 là số cần đảo ngược, reversed là số sau khi đảo ngược
        String num1;
        int num2;
        int reversed = 0;
        System.out.println("\n\nNhập vào số cần đảo ngược: ");
        num1 = sc.next();
        num2 = Integer.parseInt(num1);
        int count = num1.length() - String.valueOf(num2).length();
        //sử dụng vòng lặp while để đảo ngược num2
        while (num2 != 0) {
            int digit = num2 % 10;
            reversed = reversed * 10 + digit;
            num2 /= 10;
        }
        //hiển thị số sau khi đảo ngược ra màn hình
        System.out.printf("Số sau khi đảo ngược là: %d", reversed);
        for (int i = 0; i < count; i++) {
            System.out.print('0');
        }
    }

    public static void sumOfMaxAndMin() {

        Integer[] integerArray = {11, 2, 6, 1, 9};

        Integer max = integerArray[0];
        Integer min = integerArray[0];
        Integer sum = 0;

        for (Integer x : integerArray) {

            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }

            sum += x;
        }

        System.out.println("Tong 4 so be nhat la: " + (sum - min));
        System.out.println("Tong 4 so lon nhat la: " + (sum - max));

    }

    public static void findSecondMax() {

        Integer[] integerArray = {11, 2, 6, 1, -1, -3, 0, 999, 101, 12, 4, 4, 27, 101};

        Integer max1 = integerArray[0];
        Integer max2 = integerArray[1];

        for (Integer x : integerArray) {

            if (x > max1) {
                max1 = x;
            }

            if (x > max2 && x < max1) {
                max2 = x;
            }

        }

        System.out.println("Số lớn thứ 2 trong mảng là: " + max2);

    }

    public static void oca10() {
        String[][] chs = new String[2][];
        chs[0] = new String[2];
        chs[1] = new String[5];
        int i = 97;

        for (int a = 0; a < chs.length; a++) {
            for (int b = 0; b < chs.length; b++) {
                chs[a][b] = "" + i;
                i++;
            }
        }

        for (String[] ca : chs) {
            for (String c : ca) {
                System.out.print(c + "");
            }
            System.out.println();
        }

    }

    public static String printAnIsoscelesTriangle(int N) {
        StringBuilder result = new StringBuilder();
        for (int r = 1; r <= N; r++) {
            for (int sp = 1; sp <= N - r; sp++) {
                result.append(" ");
            }
            for (int c = 1; c <= (r * 2) - 1; c++) {
                result.append("*");
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    public static void reverseString() {

        String testString = "Hello world";
        String[] testStringArray = testString.split("");
        List<String> result = new ArrayList<>();

        Stack<String> stringStack = new Stack<>();

        for (String x : testStringArray) {
            stringStack.push(x);
        }

        for (int i = 0; i < testStringArray.length; i++) {
            result.add(stringStack.pop());
        }

        for (String x : result) {
            System.out.print(x);
        }


    }

    public static void checkSymmetryArrays() {

        String[] testStringArray = {"1", "2", "3","4", "3", "2", "9"};

        for (int i = 0; i < testStringArray.length / 2; i++) {
            if (!testStringArray[i].equals(testStringArray[testStringArray.length - i - 1])) {
                System.out.println("Mảng không đối xứng!");
                return;
            }
        }

        System.out.println("Mảng đối xứng!");

    }

    public static void swapAAndBWithoutTemp() {

        int a = 6;
        int b = 9;

        a = a + b;

        b = a - b;

        a = a - b;

        System.out.println("a: " + a + " b: " + b);

    }
}