package com.dsalgo.mixBagConcepts;

public class MissingAndDuplicateNumber {

    public static void findMissingAndDuplicateNumber(int[] arr) {

        int n = arr.length;

        // Missing Number
        int miss = 0;

        // Repeating Number
        int rep = 0;

        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        // XOR here is XOR of 2 numbers bitwise. These 2 numbers are missing and repeating numbers.
        // Now we will divide these array numbers into 2 sets. The XOR of each of these sets will give us 2 numbers. These are
        // Repeating and Missing Numbers.
        int a = 0;
        int b = 0;

        // Getting the last bit which is set
        int lastBitSet = xor & ~(xor - 1);

        // Loop for dividing the array in 2 sets. one for missing elements, other for repeating.
        //Here doing xor on array elements and 1 to size of array i.e n to find the msb is set or not and diving in to two sets, missing and repeating
        for (int i = 0; i < n; i++) {
            if ((lastBitSet & arr[i]) != 0) {
                // If the last bit is set, go to the missing set.
                a ^= arr[i];
            } else {
                // Else, this goes to the repeating set.
                b ^= arr[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((lastBitSet & i) != 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        miss = a;
        rep = b;
        System.out.println("Missing Number: " + miss);
        System.out.println("Repeating Number: " + rep);
    }

    public static void findMissingNumber(int[] arr){

        int n=arr.length;
        int rep=0;
        int xor=0;
        for(int i=0;i<n;i++){
            xor^=arr[i];
        }
        for(int i=0;i<n;i++){
            xor^=i;
        }
        int lastBitSet=xor & ~(xor-1);

        for(int i=0;i<n;i++){
            if((lastBitSet & arr[i])==0){
                rep^=arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if((lastBitSet & i)==0){
                rep^=i;
            }
        }
        System.out.println(rep);

    }

    public static void main(String[] args) {
        //findMissingAndDuplicateNumber(new int[]{1,5,7,2,4,5,6});
        findMissingNumber(new int[]{1,5,7,2,4,5,6});
    }

}
