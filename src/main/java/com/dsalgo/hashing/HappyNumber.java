package com.dsalgo.hashing;

import java.util.HashSet;

/*
"Use a HashSet to track sums of squares for cycle detection,
or apply Floyd’s Cycle Detection with two pointers to determine if the number becomes 1."
 */
public class HappyNumber {

    //To find happy number we can store the number in the hashset
    //We can iterate a loop until n!=1 and the number does not contain hashset

    public static boolean isHappy(int number){

        HashSet<Integer> hashSet=new HashSet<>();

        while (number!=1 && !hashSet.contains(number)){
            hashSet.add(number);
            number=getSumOfSquares(number);
        }
        return number==1;

    }

    private static int getSumOfSquares(int number) {

        int sum=0;
        while(number>0){
            int rem=number%10;
            sum+=rem*rem;
            number=number/10;
        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

}
