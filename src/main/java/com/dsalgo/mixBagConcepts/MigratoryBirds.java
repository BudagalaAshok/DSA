package com.dsalgo.mixBagConcepts;

import com.google.common.collect.Lists;

import java.util.*;

public class MigratoryBirds {


    public static void findCountOfFrequentlySightedTypeBirds(int[] arr) {

        //Define Count array
        int n = arr.length;
        int[] countArray = new int[n + 1];
        for (int i = 0; i < n; i++) {
            countArray[arr[i]] = countArray[arr[i]] + 1;
        }


        int maxCount = 0;
        int mostCommonBird = 0;
        for (int i = 1; i < countArray.length; i++) {

            if (countArray[i] > maxCount) {
                maxCount = countArray[i];
                mostCommonBird = i;
            }
        }

        System.out.println("Most Common Bird Type is :" + mostCommonBird);


        /*System.out.println("Counted Array :"+Arrays.toString(countArray));
        int count=0;
        for(int i=1;i<countArray.length;i++){

            for(int j=0;j<countArray[i];j++){
                arr[count]=i;
                count++;
            }
        }
        System.out.println("Sorted Array is :"+Arrays.toString(arr));

        int maxTypeIdRepeated = Integer.MIN_VALUE;
        for (int i = 1; i < countArray.length; i++) {
            if (countArray[i] > maxTypeIdRepeated) {
                maxTypeIdRepeated = i;
            }
        }
        System.out.println("max :" + maxTypeIdRepeated);
        System.out.println(Arrays.toString(countArray));*/
    }

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here

        List<Integer> countArrayList=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            countArrayList.add(arr.get(i),countArrayList.get(i)+1);
        }
        int maxCount=0;
        int mostCommonBird=0;
        for(int i=1;i<countArrayList.size();i++){
            if(countArrayList.get(i)>maxCount){
                maxCount=countArrayList.get(i);
                mostCommonBird=i;
            }
        }

        return mostCommonBird;


    }

    public static int sightedTypeBirdsUsingHashMap(int[] arr) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int number : arr) {
            if (integerMap.containsKey(number)) {
                integerMap.put(number, integerMap.get(number) + 1);
            } else {
                integerMap.put(number, 1);
            }
        }
        int maxCount = 0;
        int mostCommonBird = 0;
        for (Integer birdType : integerMap.keySet()) {
            int count = integerMap.get(birdType);
            if (count > maxCount) {
                maxCount = count;
                mostCommonBird = birdType;
            }
        }

        return mostCommonBird;


    }

    public static void main(String[] args) {
        //findCountOfFrequentlySightedTypeBirds(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4});
        migratoryBirds(Lists.newArrayList(1,1,2,2,4));
    }

}
