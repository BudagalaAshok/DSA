package com.dsalgo.mixBagConcepts;

public class TowerOfHanoi {
    public static void toh(int number, char source, char temp, char dest){

        if(number==0){
            return;
        }
        toh(number-1,source,dest,temp);
        System.out.println("Move "+number+" from "+source+" to "+dest);
        toh(number-1,temp,source,dest);
    }


    public static void main(String[] args) {
        toh(3,'A','B','C');
    }

}
