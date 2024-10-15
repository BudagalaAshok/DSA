package com.dsalgo.hashing;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                if (i - hashMap.get(nums[i]) <= k) {
                    return true;
                }
            }
            hashMap.put(nums[i], i);
        }
        return false;

    }
}
