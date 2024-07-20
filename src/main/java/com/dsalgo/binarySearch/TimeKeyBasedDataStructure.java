package com.dsalgo.binarySearch;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Binary search to get the value based on the timestamp, Now time stamp is in increasing order.
//As per the constraints timestamp value is in sorted order.
public class TimeKeyBasedDataStructure {

    //Here key is same but it has multiple values and values consists of pairs
    HashMap<String, List<Pair<String, Integer>>> map;

    List<Integer> integers=new ArrayList<>();


    public TimeKeyBasedDataStructure() {
        map = new HashMap<>();
       Pair pair=new Pair<Integer,Integer>(10,20);
       pair.getKey();


    }

    public void set(String key, String value, int timeStamp) {

        //That means with that key we don't have any value
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(value, timeStamp));
    }

    public String get(String key, int timeStamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair<String, Integer>> pairs = map.get(key);
        return search(pairs, timeStamp);
    }

    //Doing binary search here to find the value based on the timestamp
    private String search(List<Pair<String, Integer>> pairs, int timeStamp) {

        int left = 0;
        int right = pairs.size() - 1;
        String res = "";
        while (left <= right) {
            int mid = (left + right) / 2;
            if (pairs.get(mid).getValue() <= timeStamp) {
                res = pairs.get(mid).getKey();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;

    }


}
