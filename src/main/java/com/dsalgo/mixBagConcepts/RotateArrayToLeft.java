package com.dsalgo.mixBagConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArrayToLeft {

    public int[] rotateLeft(int[] arr,int rotateLeftCount){

        while(rotateLeftCount!=0){

            int temp=arr[0];
            for(int i=0;i<arr.length-1;i++){
                arr[i]=arr[i+1];
            }
            arr[arr.length-1]=temp;
            rotateLeftCount--;
        }
        System.out.println(Arrays.toString(arr));
        return arr;

    }

    public List<Integer> rotateLeft(int rotateLeftCount, List<Integer> list) {

        List<Integer> rotateArrayList=new ArrayList<>();
        rotateLeftCount=rotateLeftCount%list.size();
        for(int i=rotateLeftCount;i<list.size();i++){
            rotateArrayList.add(list.get(i));
        }
        for(int i=0;i<rotateLeftCount;i++){
            rotateArrayList.add(list.get(i));
        }
        return rotateArrayList;
    }

    public static void main(String[] args) {
        RotateArrayToLeft rotateArrayToLeft=new RotateArrayToLeft();
        //rotateArrayToLeft.rotateLeft(new int[]{1,2,3,4,5},2);
        List<Integer> integerList=new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        System.out.println(rotateArrayToLeft.rotateLeft(2,integerList));
    }

}
