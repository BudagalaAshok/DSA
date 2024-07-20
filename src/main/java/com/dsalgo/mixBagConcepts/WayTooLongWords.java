package com.dsalgo.mixBagConcepts;

import java.util.Scanner;

public class WayTooLongWords {

    public String getShortWord(String word){
        if(word.length()<=10){
            return word;
        }
        char startCh=word.charAt(0);
        char endChar=word.charAt(word.length()-1);
        String finalString=word.substring(1,word.length()-1);
        return String.valueOf(startCh)+finalString.length()+ endChar;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int words= Integer.parseInt(scanner.nextLine());
        WayTooLongWords wayTooLongWords=new WayTooLongWords();
        for(int i=0;i<words;i++) {
            System.out.println(wayTooLongWords.getShortWord(scanner.nextLine()));
        }
    }

}
