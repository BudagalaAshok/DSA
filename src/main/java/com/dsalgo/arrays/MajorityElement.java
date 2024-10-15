package com.dsalgo.arrays;

/**
 * Intuition:
 *
 * 	1.	Majority Element Property: The majority element appears more than half the time in the array. This means that if we could somehow “eliminate” or “cancel out” occurrences of other elements,
 * 	the majority element would still be left standing.
 * 	2.	Pairing Elements: The Boyer-Moore algorithm works by maintaining a count and a candidate for the majority element:
 * 	•	If the current element is the same as the candidate, we increase the count.
 * 	•	If the current element is different, we decrease the count.
 * 	•	If the count reaches zero, we change the candidate to the current element.
 * 	3.	Why Does It Work?: Since the majority element appears more than half the time, even after canceling out many occurrences of other elements,
 * 	the majority element will survive through the process and end up as the candidate at the end.
 */
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
