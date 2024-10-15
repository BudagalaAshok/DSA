package com.dsalgo.arrays;


/**
 * This problem can be solved using greedy approach,From the current index we can check if we are able to reach the last index or not
 * we are keep tracking what was the nextFartherIndex from the currentIndex by taking max of currentIndex+It's value and existing value of fartherIndex
 * If currentPosition greater than fartherIndex then we can't reach
 */
public class JumpGameI {


    public boolean canJump(int[] nums) {

        int fartherIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > fartherIndex) {
                return false;
            }

            /**
             * 	The sum i + nums[i] gives us the farthest index we can jump to from the current position.
             * 	The goal is to keep updating farthestReachable with the maximum possible jump distance we’ve encountered so far.
             */
            fartherIndex = Math.max(i + nums[i], fartherIndex);
            if (fartherIndex > nums.length - 1) {
                return true;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        JumpGameI jumpGameI=new JumpGameI();
        System.out.println(jumpGameI.canJump(new int[]{2,3,1,1,4}));
    }

}
