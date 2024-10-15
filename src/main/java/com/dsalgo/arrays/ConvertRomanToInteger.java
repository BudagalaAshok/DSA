package com.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToInteger {


    public void convertRomanValueToInteger(String romanString) {
        //LVIII
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanValues = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        //Put all the possible values in to map
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('M', 1000);
        hashMap.put('D', 500);
        hashMap.put('C', 100);
        hashMap.put('L', 50);
        hashMap.put('X', 10);
        hashMap.put('V', 5);
        hashMap.put('I', 1);

        int prevValue=0;
        int total=0;

        //Iterate string from right to left and then compare the current value with the previous value if the current value is less than previous value
        // then reduce the current value from total otherwise add it to total
        for (int i=romanString.length()-1;i>=0;i--){
          int currentVal=hashMap.get(romanString.charAt(i));
          if(currentVal< prevValue){
              total-=currentVal;
          }else{
              total+=currentVal;
          }
          prevValue=currentVal;

        }

        System.out.println(total);

    }

    public static void main(String[] args) {
        ConvertRomanToInteger convertRomanToInteger=new ConvertRomanToInteger();
        //LVIII,MCMXCIV
        convertRomanToInteger.convertRomanValueToInteger("MCMXCIV");
    }

}
