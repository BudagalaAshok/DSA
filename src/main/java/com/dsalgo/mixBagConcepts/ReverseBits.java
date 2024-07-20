package com.dsalgo.mixBagConcepts;

public class ReverseBits {

    public static long findNum(int number){

        int countOfOnes=0;
        while(number!=0){
            number=number & (number -1);
            countOfOnes++;
        }

        int countOfZeros=32-countOfOnes;
        long answer= (1<<(countOfZeros+countOfOnes)<<countOfOnes);
        System.out.println(answer);
        return answer;

    }

    static int reverseBits(int n) {
        int newN = 0;
        for(int i = 0; i < Integer.SIZE; i++) {
            newN = newN << 1;
            if((n & 1) > 0) {
                newN = newN ^ 1;
            }
            n = n >> 1;
        }
        return newN;
    }

    public static void main(String[] args) {

        System.out.println(reverseBits(4));

    }

}
