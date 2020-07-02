package com.company;

public class Main {
    public static void main(String[] args) {
        //A_SlidingWindow
        //Example1
        //Max Sum = 9
        //Explanation: Subarray with maximum sum is [5, 1, 3].

        System.out.println(A_SlidingWindow.MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
        //System.out.println(A_SlidingWindow.MaxSumSubArrayOfSizeK.findMaxSumSubArrayBookSolution(3, new int[] {2, 1, 5, 1, 3, 2}));
    }
}
