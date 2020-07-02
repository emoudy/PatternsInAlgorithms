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
            //Time complexity O(n)
            //Space complexity O(1)
            long startTime = System.nanoTime();
            int windowStart = 0;
            int windowSum = 0;
            int maxSum = 0;

            for(int i=0; i <= arr.length-1; i++) {
                windowSum += arr[i];
                if(i >= k-1){
                    maxSum = Math.max(maxSum, windowSum);
                    windowSum -= arr[windowStart];
                    windowStart++;
                }
            }

            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            System.out.println("elapsedTime findMaxSumSubArray: " + elapsedTime);
            return maxSum;
        }

        public static int findMaxSumSubArrayBookSolution1(int k, int[] arr) {
            //Time complexity O(n * k)
            //Space complexity O(1)
            long startTime = System.nanoTime();
            int maxSum = 0;
            int windowSum;

            for (int i = 0; i <= arr.length - k; i++) {
                windowSum = 0;
                for (int j = i; j < i + k; j++) {
                    windowSum += arr[j];
                }
                maxSum = Math.max(maxSum, windowSum);
            }

            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            System.out.println("elapsedTime findMaxSumSubArrayBookSolution: " + elapsedTime);
            return maxSum;
        }

        public static int findMaxSumSubArrayBookSolution2(int k, int[] arr) {
            //Time complexity O(n)
            //Space complexity O(1)
            int windowSum = 0;
            int maxSum = 0;
            int windowStart = 0;

            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                windowSum += arr[windowEnd]; // add the next element
                // slide the window, we don't need to slide if we've not hit the required window size of 'k'
                if (windowEnd >= k - 1) {
                    maxSum = Math.max(maxSum, windowSum);
                    windowSum -= arr[windowStart]; // subtract the element going out
                    windowStart++; // slide the window ahead
                }
            }
            return maxSum;
        }
    }
}
