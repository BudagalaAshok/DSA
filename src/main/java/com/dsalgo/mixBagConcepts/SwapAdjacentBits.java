package com.dsalgo.mixBagConcepts;

public class SwapAdjacentBits {
    public static int swapAdjacentBits(int n) {
        // Mask to extract even bits (0b10101010101010101010101010101010)
        int evenMask = 0xAAAAAAAA;
        // Mask to extract odd bits (0b01010101010101010101010101010101)
        int oddMask = 0x55555555;

        // Extract even and odd bits
        int evenBits = n & evenMask;
        int oddBits = n & oddMask;

        // Right shift even bits to make them odd and left shift odd bits to make them even
        evenBits >>= 1;
        oddBits <<= 1;

        // Combine the shifted even and odd bits to get the swapped number
        return evenBits | oddBits;
    }

    public static void main(String[] args) {
        // Test the method
        int number = 10; // Example number
        int swappedNumber = swapAdjacentBits(number);
        System.out.println("Original number: " + number);
        System.out.println("Swapped number: " + swappedNumber);
    }
}
