package com.dsalgo.strings;

import java.util.*;

public class FirstRepeatingCharacter {

    public static void printFirstRepeatingCharacter(String str){

        LinkedHashMap<Character,Integer> linkedHashMap=new LinkedHashMap<>();

        Set<Character> sets=new HashSet<>();
        for(char ch: str.toCharArray()){
            linkedHashMap.put(ch,linkedHashMap.getOrDefault(ch,0)+1);
        }

        Optional<Character> find=linkedHashMap.entrySet().stream().
                filter(characterIntegerEntry -> characterIntegerEntry.getValue()>1)
                .map(Map.Entry::getKey).findFirst();
        System.out.println(find.orElse('.'));
        //System.out.println(find);


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int noOfTestCases=sc.nextInt();
        for(int i=0;i<noOfTestCases;i++){
            String repeatingCharString=sc.next();
            printFirstRepeatingCharacter(repeatingCharString);
        }
    }

}
