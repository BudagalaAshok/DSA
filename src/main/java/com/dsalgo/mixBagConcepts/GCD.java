package com.dsalgo.mixBagConcepts;

import java.util.Scanner;

public class GCD {

    public static long getHCF(int a,int b){
        if(b==0){
            return a;
        }
        return getHCF(b,a%b);
    }

    public static long getLCM(int a,int b){

        long gcd=getHCF(a,b);
        long lcm= (a*b)/gcd;
        return lcm;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc=new Scanner(System.in);
        int range=sc.nextInt();
        for(int i=0;i<range;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.print(getLCM(a,b)+" "+getHCF(a,b));
            System.out.println();
        }
    }
}
