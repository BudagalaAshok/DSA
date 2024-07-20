package com.dsalgo.mixBagConcepts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DifferenceBetweenDates {


    public static void differenceBetweenDates(String date1,String date2){

        LocalDate startDate=LocalDate.parse(date1,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate=LocalDate.parse(date2,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(Math.abs(ChronoUnit.DAYS.between(startDate,endDate)));
    }

    public static void main(String[] args) {
        String str="2000-01-16 1999-12-30";
        differenceBetweenDates(str.split(" ")[0],str.split(" ")[1]);
    }

}
