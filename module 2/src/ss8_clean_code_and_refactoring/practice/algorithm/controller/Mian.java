package ss8_clean_code_and_refactoring.practice.algorithm.controller;

public class Mian {
        public boolean kiemTra(int[] arr) {
            int sum1 = 0;
            int sum2 = 0;
            boolean check = false;
            for (int i = 1; i < arr.length - 1; i++) {
                for (int j = 0; j <= i; j++) {
                    sum1 += arr[j];
                }
                for (int j = i + 1; j <= arr.length - 1; j++) {
                    sum2 += arr[j];
                }
                if (sum1 == sum2) {
                    check = true;
                    break;
                }
            }
            return check;
        }




}
