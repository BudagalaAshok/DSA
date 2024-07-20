package com.dsalgo.stacks;

import java.util.*;

public class CollectingMangoes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        for (int i = 0; i < noOfTestCases; i++) {
            Stack<Integer> mangoStack = new Stack<>();
            Stack<Integer> maxStack = new Stack<>();
            int max = Integer.MIN_VALUE;
            int operations = sc.nextInt();
            System.out.println("Case " + (i + 1) + ":");
            while (operations != 0) {

                String operation = sc.next();
                switch (operation) {

                    case "A":
                        int mangoSize = sc.nextInt();
                        mangoStack.push(mangoSize);
                        max = Math.max(max, mangoSize);
                        maxStack.push(max);
                        break;
                    case "Q":
                        if (maxStack.isEmpty()) {
                            System.out.println("Empty");
                            return;
                        }
                        System.out.println(maxStack.peek());
                        break;
                    case "R":
                        if (mangoStack.isEmpty()) {
                            return;
                        }
                        mangoStack.pop();
                        maxStack.pop();
                        break;


                }
                operations--;
            }

        }
    }
}
