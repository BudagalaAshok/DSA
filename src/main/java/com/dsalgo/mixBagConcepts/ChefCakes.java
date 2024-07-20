package com.dsalgo.mixBagConcepts;

import java.util.Scanner;

public class ChefCakes {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int testCases= scanner.nextInt();
        for(int i=0;i<testCases;i++){
            int noOfCupCakes= scanner.nextInt();
            System.out.println((noOfCupCakes/2) +1);

        }
    }

}
