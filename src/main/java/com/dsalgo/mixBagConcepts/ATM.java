package com.dsalgo.mixBagConcepts;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int withDrawAmount = sc.nextInt();
        double balance = sc.nextDouble();
        if (balance % 5 == 0 && balance >= withDrawAmount + 0.50) {
            System.out.println(balance - withDrawAmount - 0.50);
        }else{
            System.out.println(balance);
        }
    }

}
