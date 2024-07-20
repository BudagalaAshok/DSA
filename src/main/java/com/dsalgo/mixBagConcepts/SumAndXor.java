package com.dsalgo.mixBagConcepts;

public class SumAndXor {

    public static void findSumAndXor(long number){
        int count=0;

        while(number!=0){

            if((number&1)==0){
                count++;
            }
            number=number>>1;

        }
        System.out.println((int)Math.pow(2,count)-1);

    }

    public static void main(String[] args) {
        //findSumAndXor(10e18);
    }
}
