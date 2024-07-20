package com.dsalgo.recursion;

public class RopeCuttingProblem {
     public static int maxPieces(int ropeLength, int a, int b, int c){

         if(ropeLength==0){
             return 0;
         }
         if(ropeLength<0){
             return -1;
         }
         int temp1=maxPieces(ropeLength-a,a,b,c);
         int temp2=maxPieces(ropeLength-b,a,b,c);
         int temp3=maxPieces(ropeLength-c,a,b,c);
         int pieces=Math.max(temp3,Math.max(temp1,temp2));
         if(pieces==-1){
             return -1;
         }
         return pieces+1;

     }

    public static void main(String[] args) {
        System.out.println("Max Pieces we can count will be :"+maxPieces(15,5,8,7));
    }

}
