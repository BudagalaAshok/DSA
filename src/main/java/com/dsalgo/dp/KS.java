package com.dsalgo.dp;

import java.util.Scanner;

public class KS {

        public static int solve(int[] w,int[] v,int n, int k){

            int[][] dp=new int[2][k+1];
            for(int j=0;j<=k;j++){
                dp[0][j]=0;
            }
            for(int i=1;i<=n;i++){
                for(int j=0;j<=k;j++){
                    dp[i%2][j]=dp[(i-1)%2][j];
                    if(j>=w[i]){
                        dp[i%2][j]=Math.max(dp[i%2][j],dp[(i-1)%2][j-w[i]]+v[i]);
                    }
                }
            }

            return dp[n%2][k];

        }

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
            Scanner sc=new Scanner(System.in);
            int noOfTestCases=sc.nextInt();
            for(int i=0;i<noOfTestCases;i++){

                int n=sc.nextInt();
                int k=sc.nextInt();
                int[] w=new int[n+1];
                int[] v=new int[n+1];
                for(int j=1;j<=n;j++){
                    w[j]=sc.nextInt();
                    v[j]=sc.nextInt();
                }
                System.out.println(solve(w,v,n,k));
            }
        }

}
