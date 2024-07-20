package com.dsalgo.mixBagConcepts;

import java.util.Scanner;

public class AddingReverseNumbers {

    public int findReverseNum(int num){
        int reverse=0;
        while(num!=0){
            int remainder=num%10;
            reverse=reverse*10+remainder;
            num=num/10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        AddingReverseNumbers addingReverseNumbers=new AddingReverseNumbers();
        while(n!=0){

            int num1=sc.nextInt();
            int num2=sc.nextInt();
            int reverseNumberSum=addingReverseNumbers.findReverseNum(num1)+addingReverseNumbers.findReverseNum(num2);
            System.out.println(addingReverseNumbers.findReverseNum(reverseNumberSum));
            n--;
        }
    }

}
