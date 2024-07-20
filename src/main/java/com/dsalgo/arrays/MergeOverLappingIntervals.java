package com.dsalgo.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverLappingIntervals {

    // {{1,3},{2,6},{8,10},{15,18}};
    public static void mergeIntervals(Interval intervalList[]){

        if(intervalList.length<=0){
            return;
        }

        Stack<Interval> stack=new Stack<>();
        Arrays.sort(intervalList,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2){
                return i1.start=i2.start;
            }
        });

        //Push first element to the stack
        stack.push(intervalList[0]);
        for(int i=1;i<intervalList.length;i++){
            Interval top=stack.peek();
            if(top.end<=intervalList[i].start){
                stack.push(intervalList[i]);
            }else if(top.end>=intervalList[i].start){
                top.end=intervalList[i].end;
                stack.pop();
                stack.push(top);
            }

        }

        System.out.println("The merged intervals are ");
        while(!stack.isEmpty()){
            Interval interval=stack.pop();
            System.out.println("["+interval.start+","+interval.end+"] ");
        }

    }

    public static void main(String[] args) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        mergeIntervals(arr);
    }

}

class Interval{
    int start;
    int end;
    public Interval(int start, int end){
        this.start=start;
        this.end=end;
    }
}
