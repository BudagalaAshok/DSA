package com.dsalgo.strings;

public class SubstringMatchWithRabinKarp {

    private static final int PRIME=101;

    private static long calculateHash(String hashString){

        long hash=0;
        for (int i = 0; i < hashString.length() ; i++) {
          hash= (long) (hash+ hashString.charAt(i) * Math.pow(PRIME,i));
        }

        return hash;
    }

    private static long updateHash(long prevHash, char oldChar, char newChar,int patternLength){

        long newHash= ((prevHash-oldChar)/PRIME);
        newHash= (long) (newHash+newChar*Math.pow(PRIME,patternLength-1));
        return newHash;
    }

    public static int search(String text, String pattern){
        int occurrenceCount=0;
        int patternLength=pattern.length();
        long patternHash=calculateHash(pattern);
        long textHash=calculateHash(text.substring(0,patternLength));
        for(int i=0;i<=text.length()-patternLength;i++){

            if(textHash==patternHash){
                if(text.substring(i,i+patternLength).equals(pattern)){
                    System.out.println("Pattern found at index :"+i);
                    occurrenceCount++;
                }
            }

            //Here we are calculating hash by removing first character in an old substring and adding new next character again
            //This function we call it as rolling hash
            if(i<text.length()-patternLength){
                textHash=updateHash(textHash,text.charAt(i),text.charAt(i+patternLength),patternLength);
            }

        }
        return occurrenceCount;

    }


    public static void main(String[] args) {

       // System.out.println(search("yalgoalgoalgopalgoaxalgoasaxalgolalgoalgoalgo","algo"));
        int i=1,j=5,k=7,l=11;
        String text1="psmartabcdatanmn";
        String text2="xydatazsmart";
        System.out.println(text1.substring(1,6)+" "+text2.substring(7,12));
        search(text1.substring(1,6),text2.substring(7,12));

    }

}
