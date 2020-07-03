package com.company;

public class Main {
    public static void main(String[] args) {
        /*
        A_SlidingWindow
        */

        //Example1
        //Explanation: Subarray with maximum sum is [5, 1, 3].
        //Max Sum = 9
        //System.out.println(A_SlidingWindow.MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
        //System.out.println(A_SlidingWindow.MaxSumSubArrayOfSizeK.findMaxSumSubArrayBookSolution(3, new int[] {2, 1, 5, 1, 3, 2}));

        //Example2
        //Explanation: Given an array of positive numbers and a positive number ‘S’, find the length of the
        // smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
        System.out.println(A_SlidingWindow.MinSizeSubArraySum.findMinSubArray(7, new int[] {2, 1, 5, 2, 8}));
    }
}
