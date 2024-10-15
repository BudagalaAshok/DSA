package com.dsalgo.arrays;

public class ConvertIntegerToRoman {

    public void convertValueToRoman(int value) {

        //First define all possible values and the subsequent roman characters
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanValues = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder ans = new StringBuilder();
        //Now iterate each value from values array and then check the current value is greater than or equal to the input value
        for (int i = 0; i < values.length; i++) {

            //If input value is greater than or equal to values array then subtract from the original value
            while (value >= values[i]) {
                value-=values[i];
                ans.append(romanValues[i]);
            }

        }
        System.out.println("Converted value was:"+ ans.toString());

    }

    public static void main(String[] args) {

        ConvertIntegerToRoman convertIntegerToRoman=new ConvertIntegerToRoman();
        convertIntegerToRoman.convertValueToRoman(3749);
    }


}
