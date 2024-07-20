package com.dsalgo.mixBagConcepts;

import java.util.Arrays;

public class FindUniqueElementUnderArray {

    public static int findUniqueElement(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result = result ^ num;
        }
        return result;
    }

    public static int[] findTwoRepeatingNumbers(int[] nums) {
        int[] result = new int[2];

        // Step 1: XOR all elements with numbers from 1 to N-2
        int xor = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i] ^ i;
        }

        // Step 2: Find the rightmost set bit in the XOR result
        int rightmostSetBit = xor & ~(xor - 1);

        // Step 3: Partition the array elements into two groups
        int group1 = 0, group2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightmostSetBit) == 0) {
                group1 ^= nums[i];
            } else {
                group2 ^= nums[i];
            }
        }

        // Step 4: Resulting numbers are the repeating numbers
        result[0] = group1;
        result[1] = group2;

        return result;
    }

    public static int findUniqueElementFromDuplicateElements(int[] arr) {
        int ans = 0;
        for (int i = 0; i <= 30; i++) {
            int oneCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if (checkBit(arr[j], i) == 1) {
                    oneCount++;
                }
            }
            if (oneCount % 3 != 0) {
                ans = ans + (1 << i);
            }
        }
        return ans;
    }

    public static int checkBit(int num, int i) {

        return (num >> i) & 1;

    }

    public static void main(String[] args) {

        //System.out.println("Unique element is :" + findUniqueElement(new int[]{3, 10, 4, 10, 15, 3, 18, 18, 4}));
        //System.out.println("Unique eleemnt amount three duplicates was :" + findUniqueElementFromDuplicateElements(new int[]{4, 12, 4, 17, 17, 12, 4, 10, 10, 18, 12, 17, 10}));
        System.out.println("Find Repeating numbers :" + Arrays.toString(findTwoRepeatingNumbers(new int[]{1, 2, 3, 4, 2, 3})));

    }

}
