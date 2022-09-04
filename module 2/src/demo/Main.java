package demo;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentTime = new Date();

        String birthday321 = "01/11/2005";

        Date birthday = dateFormat.parse(birthday321);

//        birthday.setYear(birthday.getYear() + 18);

        int over100 = currentTime.getYear() - birthday.getYear();

        System.out.println(over100);
    }
}
