package com.company;

public class A_SlidingWindow {
    static class MaxSumSubArrayOfSizeK {
        //Problem Statement
        //Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

        //Example1
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        //Max Sum = 9
        //Explanation: Subarray with maximum sum is [5, 1, 3].

        public static int findMaxSumSubArray(int k, int[] arr) {
            int windowStart = 0;
            int windowSum = 0;
            int windowMaxSum = 0;

            for(int i=0; i <= arr.length-1; i++) {
                windowSum += arr[i];
                System.out.println("windowStart: " + windowStart);
                if(i >= k-1){
                    if (windowSum >= windowMaxSum) {
                        windowMaxSum = windowSum;
                        System.out.println("windowMaxSum " + windowMaxSum);
                    }
                    windowSum -= arr[windowStart];
                    windowStart++;
                    //System.out.println("windowStart after: " + windowStart);
                }
            }
            return windowMaxSum;
        }
    }
}
