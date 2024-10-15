package com.dsalgo.hashing;

import com.google.common.collect.Lists;

import java.util.*;

public class AnagramCheck {

    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> count = new HashMap<>();

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;

    }


    //This problem can be solved using hashmap by taking sorted string as key and respective matching characters are added as values.
    // Iterate each string, sort and check if it there in map or not. If it's not there add it and if it is there add the original unsorted string to the list
        public List<List<String>> groupAnagrams(String[] strs) {

            Map<String,List<String>> mapStringList=new HashMap<>();
            for(String str:strs){

                char[] charString=str.toCharArray();
                Arrays.sort(charString);
                String sortedString=new String(charString);
                if(!mapStringList.containsKey(sortedString)){
                    mapStringList.put(sortedString,new ArrayList<>());
                }
                mapStringList.get(sortedString).add(str);
            }
            return new ArrayList<>(mapStringList.values());

        }


    public static void main(String[] args) {
        AnagramCheck anagramCheck = new AnagramCheck();
        System.out.println(anagramCheck.isAnagram("hhbywxfzydbppjxnbhezsxepfexkzofxyqdvcgdvgnjbvihgufvgtuxtpioxgjuwawkbaerbsirrktcjcesepcocaglbassivfbjhikynfsvlbtkawstrclbkpuldshfgfvwjawownulsggsxhhqglbhjlgltfrqyjntgldlgorgatnjrsywlyngxrcwfojkmydmjbzuquqnzbpwlcbdzgdicctpkgtbdjgywkyrkityvohjbuvmzdfyicyplmrpygdhaeqbuxnehfybsysnnmzbhprsyjmtpcrzeqqbirofzjtlsyofdyeffkvpuhzaflwjfhnsuyryetjuajjnjwvlvrhvpenaarnzoafztixjrisfzdlepcwhxudjpsiirtofymnovacjmpdjtethjqfwduekczlqhsfjgqesyoxcfooagrdhyvsmssbhsclnlblhobvhwtpyftolneozlhbtjagpgqnnapktyevdvjfwdnbwsbelweoflhyhifprieuvfcdkavqxkygjlaegqfmzndgxbsccjgpclxmlpstrqjtqyvlqcopnahqvnpvkjimfdlosvletmamqjvotqwhadutmfvlgldniixvdkmymfadckuaglgbuttymoqmzkaeqxugsrnfyxzcamwxujgzupefretsvbdweuwwcizjvhcowtmwgkdafcpzctpsjwdocgofivyshwdinbdhbxdfhjsrrsfchxkeqndgzauyprwfnrbmunanqnhmjhrufoinakwaciaoerioqffmipfqujfxwofqdyjbhagkyvmnxcwomgnmwlaodxgkgthnuctoozxrebjiynjwohtgukyneyofabpfdrxklopmxxiwjuxqpaazknscagfiaetmmwnwpzceglupqvlctywtpluoqbzdultcsudubqclbwlxyfboimfwriugfulbntvdwnxgiycxvennakpodorvpiknkridcumsovvfziki...",
                "rmhdxtymfgxjluxmeeerhxrrtjgecmyfdhevakyosvvuwgbwmxiakbmtqjjpgctjojdqatuelqmfeldgoprxbzcylajhhjngqlmporofjpoyhrkptrbpzvvnkrqjovfzmmqybqxzjxarhguqcyvlugwmnzwtffanzuajraqbvjflgalgcwuhmrkblobybwouffzptbvkmwoklczfhvkqsirkqvhkryyxpkyfnwnjudvllmznupldkpoplwdlfzncwxdlgvgkehpcudqybnyhofpjnjmahnsrntxjtgocwsrnukejehwzxdetglgahdvzyypdztqwbnfrnytxprhtqjgobzjyewuasgnryjoyvwhdmemppixqcowgmicbmsukgodwgnsdieuqyzuysedmsphmritlqtnvnvfnmgnghxdsmmnzdhdalhfsfsppupteyrlajxrlbyqteaytgpsckottqnibbxhmkwuqfftwvibzsnaumsbohxeoaulsmwuvjcimscyqhtioekembdwfozglussscbzejqnvmcpfwdmxshhrkquacplctruyklkxcfovcbqllmyghdbkhdmawpmalrsgymgmbleftwtvldxkqprcbcbneyyluoyydtcvkimqjoinwntfxfbwqjbufqansdlgrgauzfwxpzrjxpesmozcsczbfzfeziedqzwywtxhyfnpbxfgbqcsfwdiplegcsrseqsagvkpjrupkaxffrddebpntocmkbarvdrhvujedwnktsdimzcbqlqyizozxcexqpoefjpznegsrtbfanqdyqaaudcklplvxojfuzccmtauaxurbwbexulqbxooadcrlxbtggxcycadratsuqavwwkdqtutptdpbnxeicmackhyvjhkfbayjmymjwejybhoryyqjjmwqzhpgulovxaccychffcplvkqfqghmgmdsigkugsevwkvzgpxiolhtzocdiphokfitgg..."));
        System.out.println(anagramCheck.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
