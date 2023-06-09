package com.example.labook_be.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetDate {
    public static String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return (LocalDate.now().format(formatter));
    }
}
