package com.dsalgo.arrays;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {

            totalGas += gas[i];
            totalCost += cost[i];
            currentGas = gas[i] - cost[i];

            //if it is negative then this position we can't start
            if (currentGas < 0) {
                start = i + 1;
                //Reset the current gas because we are starting in different position
                currentGas = 0;
            }
        }

        return totalGas >= totalCost ? start : -1;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
