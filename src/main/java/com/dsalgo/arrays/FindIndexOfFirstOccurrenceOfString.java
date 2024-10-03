package com.dsalgo.arrays;

public class FindIndexOfFirstOccurrenceOfString {


    public void findIndexOfFirstOccurrence(String needle, String hayStack) {

        //return hayStack.indexOf(needle);
        int i = 0;
        int p1 = 0;
        int p2 = 0;
        while (p2 < hayStack.length()) {
            if (needle.charAt(p1) == hayStack.charAt(p2)) {
                p1++;
                p2++;
                if(p1==needle.length()){
                    System.out.println("Found Needle at Index :"+i);
                    i=p1;
                }
            } else {
                p1 = 0;
                p2++;
            }
        }

    }

    public static void main(String[] args) {

        FindIndexOfFirstOccurrenceOfString findIndexOfFirstOccurrenceOfString = new FindIndexOfFirstOccurrenceOfString();
        //System.out.println(findIndexOfFirstOccurrenceOfString.findIndexOfFirstOccurrence("leeto", "leetcode"));
        findIndexOfFirstOccurrenceOfString.findIndexOfFirstOccurrence("sad", "sadbutsad");

    }

}
