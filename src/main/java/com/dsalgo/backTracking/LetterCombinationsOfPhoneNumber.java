package com.dsalgo.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 	•	Each digit in the input corresponds to 3 or 4 possible letters (e.g., 2 maps to “abc”, 7 maps to “pqrs”).
 * 	•	In the worst case, each digit maps to 4 letters.
 * 	•	For n digits, the total number of combinations is approximately 4^n.
 *
 * Thus, the time complexity is O(4^n) because we are generating and potentially storing all combinations of letters.
 */
public class LetterCombinationsOfPhoneNumber {

    private List<String> result=new ArrayList<>();
    private String[] KEYPAD={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return result;
        }

        //Now do the dfs by exploring all the combinations
        StringBuilder currentResult=new StringBuilder();;
        dfs(digits,0,currentResult);
        return result;

    }

    public void dfs(String digits,int index,StringBuilder currentResult){

        //Base case
        if(digits.length()==index){
            result.add(currentResult.toString());
            return;
        }

        //Get the string by using the index from keypad array
        String keyPadString=KEYPAD[digits.charAt(index)-'0'];
        for(char ch: keyPadString.toCharArray()){
            currentResult.append(ch);
            dfs(digits,index+1,currentResult);
            //Now backtracking by removing the last character and try another combination
            currentResult.deleteCharAt(currentResult.length()-1);
        }

    }

    public static void main(String[] args) {

        LetterCombinationsOfPhoneNumber lcp=new LetterCombinationsOfPhoneNumber();
        System.out.println(lcp.letterCombinations("23"));

    }
}
