package com.dsalgo.mixBagConcepts;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {

    public int findMissingNumber(List<Integer> numbers, int range){
        int totalNumbers=range*(range+1)/2;
        int sum=0;
        for(int eachNumber:numbers){
            sum+=eachNumber;
        }
        return totalNumbers-sum;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber=new MissingNumber();
        List<Integer> numbers=new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println(missingNumber.findMissingNumber(numbers,5));
    }

}
