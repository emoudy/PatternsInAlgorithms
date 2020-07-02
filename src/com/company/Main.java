package com.company;

public class Main {
    public static void main(String[] args) {
        //A_SlidingWindow
        //Example1
        //Max Sum = 9
        //Explanation: Subarray with maximum sum is [5, 1, 3].

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(A_SlidingWindow.MaxSumSubArrayOfSizeK.findMaxSumSubArray(k, arr));
    }
}
