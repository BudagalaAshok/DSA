package com.dsalgo.backTracking;

import java.util.ArrayList;
import java.util.List;

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
