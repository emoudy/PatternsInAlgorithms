package com.company;

public class A_SlidingWindow {
    static class MaxSumSubArrayOfSizeK {
        //Maximum Sum Subarray of Size K

        //Problem Statement: Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        //Max Sum = 9
        //Explanation: Subarray with maximum sum is [5, 1, 3].

        public static int findMaxSumSubArray(int k, int[] arr) {
            //Time complexity O(n)
            //Space complexity O(1)
//            long startTime = System.nanoTime();
            int windowStart = 0;
            int windowSum = 0;
            int maxSum = 0;

            for (int i = 0; i <= arr.length - 1; i++) {
                windowSum += arr[i];
                if (i >= k - 1) {
                    maxSum = Math.max(maxSum, windowSum);
                    windowSum -= arr[windowStart];
                    windowStart++;
                }
            }

//            long stopTime = System.nanoTime();
//            long elapsedTime = stopTime - startTime;
//            System.out.println("elapsedTime findMaxSumSubArray: " + elapsedTime);
            return maxSum;
        }

        public static int findMaxSumSubArrayBookSolution1(int k, int[] arr) {
            //Time complexity O(n * k)
            //Space complexity O(1)
            int maxSum = 0;
            int windowSum;

            for (int i = 0; i <= arr.length - k; i++) {
                windowSum = 0;
                for (int j = i; j < i + k; j++) {
                    windowSum += arr[j];
                }
                maxSum = Math.max(maxSum, windowSum);
            }
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

    static class MinSizeSubArraySum {
    //Smallest Subarray with a given sum

//        Problem Statement: Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
//        Input: [2, 1, 5, 2, 3, 2], S=7
//        Output: 2
//        Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].

        public static int findMinSubArray(int s, int[] arr) {
            //Time complexity O(n)
            //Space complexity O(1)
            int minSubArraySize = Integer.MAX_VALUE;
            int windowSum = 0;
            int windowStart = 0;

            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
                windowSum += arr[windowEnd];

                while (windowSum >= s){
                    int tempArraySize = windowEnd - windowStart + 1;
                    minSubArraySize = Math.min(tempArraySize, minSubArraySize);
                    windowSum -= arr[windowStart];
                    windowStart++;
                }
            }
            if (minSubArraySize == Integer.MAX_VALUE) return -1;
            return minSubArraySize;
        }

        public static int findMinSubArrayBookSolution(int S, int[] arr) {
            int windowSum = 0;
            int minLength = Integer.MAX_VALUE;
            int windowStart = 0;

            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                windowSum += arr[windowEnd]; // add the next element
                // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
                while (windowSum >= S) {
                    minLength = Math.min(minLength, windowEnd - windowStart + 1);
                    windowSum -= arr[windowStart]; // subtract the element going out
                    windowStart++; // slide the window ahead
                }
            }
            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }
    }


    static class LongestSubstringKDistinct {
        //Longest Substring with K Distinct Characters

//        Given a string, find the length of the longest substring in it with no more than K distinct characters.
//        Input: String="araaci", K=2
//        Output: 4
//        Explanation: The longest substring with no more than '2' distinct characters is "araa".
        static int findLength(String str, int k) {
            


            return -1;
        }
    }
}
