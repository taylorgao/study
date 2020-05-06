package com.gbs.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTest {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();  // 而不是 new Date().getTime();
        System.out.println(l);

        long l1 = System.nanoTime();
        System.out.println(l1);


        // 获取当前时间点
        Instant date = Instant.now();//代替date
        System.out.println("instant:"+date);
        LocalDate date2 = LocalDate.now();
        System.out.println("LocalDate:"+date2);
        LocalDateTime date3 = LocalDateTime.now();//代替calendar
        System.out.println("LocalDateTime:"+date3);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");//代替simpleDateFormat
        System.out.println("DateTimeFormatter:"+dtf.format(date3));


    }
}
