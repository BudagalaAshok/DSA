package com.dsalgo.dp;

public class DecodeWays {

    //Using Memoization(Top Down approach)

    public static int decodeUsingMemoization(String s, int idx, Integer[] dp) {

        //Base-case
        //If we reach the end of the string then it is a valid way to decode
        if (idx == s.length()) {
            return 1;
        }

        //If starting character is 0 then we can return 0
        if (s.charAt(idx) == '0') {
            return 0;
        }
        //If it is already computed then return the computed value
        if (dp[idx] != null) {
            return dp[idx];
        }

        //Then we can take the next character in the string
        int count = 0;
        count += decodeUsingMemoization(s, idx + 1, dp);

        if (idx < s.length() - 1 && (s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx + 1) < '7')) {
            count += decodeUsingMemoization(s, idx + 2, dp);
        }
        dp[idx] = count;
        return dp[idx];
    }

    //Tabulation approach(Bottom up)
    public static int decodeUsingTabulation(String s) {
        int[] dp = new int[s.length() + 1];
        //Base case
        dp[0] = 1; //empty String
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < s.length() + 1; i++) {

            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i + 1) < '7')) {
                dp[i] += dp[i - 2];
            }

        }

        return dp[s.length()];

    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has one way to be decoded

        // Single character case
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public int numDecodingsUsingSpaceOptimization(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int prev2=1;//dp[i-2]
        int prev1=s.charAt(0) != '0' ? 1 : 0; //dp[i-1]

        for (int i = 2; i <= n; i++) {

            int current=0;
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                current += prev1;
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                current+=prev2;
            }
            prev2=prev1;
            prev1=current;
        }

        return prev1;
    }


}
