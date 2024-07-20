package com.dsalgo.arrays;

public class MajorityElement {


    //Using Boyer-Moore Voting Algorithm:
    public int majorityCandidate(int[] arr){

        //Initialize Candidate as first element and count=0
        int count=0;
        int candidate=arr[0];
        //[3,2,3]
        //Now traverse the each candidate if the candidate is same as current candidate then increment the count otherwise decrement the count
        //if count==0 then set the current candidate as candidate
        for (int eachCandidate:arr){

            if(count==0){
                candidate=eachCandidate;
            }

            if(eachCandidate==candidate){
                count++;
            }else{
                count--;
            }

        }

        return candidate;

    }

    public static void main(String[] args) {
        MajorityElement majorityElement=new MajorityElement();
        System.out.println("Majority Element is :"+majorityElement.majorityCandidate(new int[]{2,2,1,1,1,2,2}));
    }

}
