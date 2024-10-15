package com.dsalgo.arrays;

public class DuplicateUsingSlowAndFastPointerTechnique {

    public int findDuplicateNumber(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        //Start slow and fast pointer from starting position of the array
        //Next move the start pointer by one index value and fast pointer by two times and until and unless start and fast meets
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //Now reset the start pointer to zero
        //Now move the start and fast pointer to one stop until and unless meet
        //Return the slow pointer next
        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }

        return slow;

    }
}
