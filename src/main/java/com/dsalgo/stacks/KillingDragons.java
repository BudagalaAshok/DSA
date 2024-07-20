package com.dsalgo.stacks;

import java.util.Scanner;

public class KillingDragons {
    public static int defeatDragons(int[] dungeons, int[] energiesRequired, int[] energiesAvailable) {
        int n = dungeons.length;
        for (int start = 0; start < n; start++) {
            int energy = 0;
            for (int i = start; i < start + n; i++) {
                int idx = i % n;
                energy += energiesAvailable[idx];
                if (energy >= energiesRequired[idx]) {
                    energy -= energiesRequired[idx];
                } else {
                    energy=-1;
                    break;
                }
            }
            if (energy >= 0) {
                return dungeons[start];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = scanner.nextInt();
            int[] dungeons = new int[n];
            int[] energiesRequired = new int[n];
            int[] energiesAvailable = new int[n];
            for (int i = 0; i < n; i++) {
                dungeons[i] = i + 1;
            }
            for (int i = 0; i < n; i++) {
                energiesRequired[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                energiesAvailable[i] = scanner.nextInt();
            }
            int result = defeatDragons(dungeons, energiesRequired, energiesAvailable);
            System.out.println(result);
        }
        scanner.close();
    }
}

