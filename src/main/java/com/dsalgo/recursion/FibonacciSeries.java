package com.dsalgo.recursion;

public class FibonacciSeries {

    public int fibonacciSeries(int num) {

        //Base case
        if (num == 0) {
            return 0;
        }
        if(num==1){
            return 1;
        }

        return fibonacciSeries(num - 1) + fibonacciSeries(num - 2);


    }

    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries=new FibonacciSeries();
        System.out.println("Fibonacci Number was :"+fibonacciSeries.fibonacciSeries(5));

    }

}
