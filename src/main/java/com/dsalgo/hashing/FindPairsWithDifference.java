package com.dsalgo.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindPairsWithDifference {

     public static  boolean findPairsWithDifference(int[] arr, int target){

         Map<Integer,Integer> integerMap=new HashMap<>();
         for(int number:arr){
             if(integerMap.containsKey(number)) {
                 integerMap.put(number, integerMap.get(number) + 1);
             }else{
                 integerMap.put(number,1);
             }
         }

         //a-b=k --> a=k+b
         for (int eachNumber:arr){

             int difference=eachNumber+target;
             if(integerMap.containsKey(difference)){

                 if(difference!=eachNumber) {
                     return true;
                 }
                 if(difference==eachNumber && integerMap.get(difference)>=2){
                     return true;
                 }

             }
         }

         return false;
     }

    public static void main(String[] args) {

        System.out.println(findPairsWithDifference(new int[]{2,3,4,5,6,7,8},10));

    }

}
