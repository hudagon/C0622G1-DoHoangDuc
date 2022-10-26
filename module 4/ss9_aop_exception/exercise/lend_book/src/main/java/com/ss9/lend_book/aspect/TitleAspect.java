package com.ss9.lend_book.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Aspect
@Component
public class TitleAspect {

    @After("execution(* com.ss9.lend_book.controller.TitleController.*(..))")
    public void logAfterMethodTitleController(JoinPoint joinPoint) throws IOException {
        String path = "C:\\Users\\Xuan Vinh\\Desktop\\code\\CodeGym\\module 4\\ss9_aop_exception\\exercise\\lend_book\\src\\main\\java\\com\\ss9\\lend_book\\ulti\\logFile";
        String nameMethod = joinPoint.getSignature().getName();
        String line = "Người truy cập phương thức " + nameMethod + " vào lúc " + LocalDateTime.now();


        File file = new File(path);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

        bufferedWriter.newLine();
        bufferedWriter.write(line);

        bufferedWriter.close();

    }
}
