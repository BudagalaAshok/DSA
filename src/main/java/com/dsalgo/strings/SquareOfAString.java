package com.dsalgo.strings;

public class SquareOfAString {

    public static boolean checkStringIsSquare(String str){

      Double sqrt= Math.sqrt(str.length());
      if(Math.floor(sqrt)==str.length() || Math.ceil(sqrt)==str.length()){
          return true;
      }else{
          return false;
      }

    }

    static boolean isPerfectSquareString(String str)
    {
        int sum = 0;

        // calculating the length
        // of the string
        int len = str.length();

        // calculating the ASCII
        // value of the string
        for (int i = 0; i < len; i++)
            sum += (int)str.charAt(i);

        // Find floating point value
        // of square root of x.
        long squareRoot = (long)Math.sqrt(sum);

        // If square root is an integer
        return ((squareRoot -
                Math.floor(squareRoot)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquareString("acbb"));
    }


}
