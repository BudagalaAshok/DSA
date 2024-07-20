package com.dsalgo.mixBagConcepts;

import java.util.Scanner;

public class FindBitValue {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int x=0;
        for(int i=0;i<n;i++){
            String sc=scanner.next();
            if(sc.contains("+")){
                x++;
            }else{
                x--;
            }
        }
        System.out.println(x);

    }

}
