package com.dsalgo.mixBagConcepts;

import java.util.Scanner;

public class FindUniqueElement {

    public void findUniqueElementsInArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int uniqueElement = arr[i];
            int counter = 0;
            for (int j = 0; j < arr.length; j++) {

                if (i != j && uniqueElement == arr[j]) {
                    counter++;
                    break;
                }
            }
            if (counter == 0) {
                System.out.print(uniqueElement + " ");
            }
        }

    }



    public  void printUniqueElements(int[] arr) {
        System.out.print("Unique elements in the array: ");
        boolean[] visited = new boolean[arr.length]; // To keep track of visited elements
        for (int i = 0; i < arr.length; i++) {
            boolean isUnique = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isUnique = false;
                    visited[j] = true; // Mark the duplicate as visited
                }
            }
            if (!visited[i] && isUnique) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();
        int[] arr = new int[range];
        for (int i = 0; i < range; i++) {
            arr[i] = sc.nextInt();
        }
        FindUniqueElement findUniqueElement = new FindUniqueElement();
        findUniqueElement.printUniqueElements(arr);
    }
}
