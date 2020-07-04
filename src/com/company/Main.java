package com.company;

public class Main {
    public static void main(String[] args) {
        /*
        A_SlidingWindow
        */

        //Max Sum SubArray of SizeK
        //Explanation: Subarray with maximum sum is [5, 1, 3].
        //Max Sum = 9
        //System.out.println(A_SlidingWindow.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
        //System.out.println(A_SlidingWindow.findMaxSumSubArrayBookSolution(3, new int[] {2, 1, 5, 1, 3, 2}));

        //Smallest SubArray
        //Explanation: Given an array of positive numbers and a positive number ‘S’, find the length of the
        // smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
        //System.out.println(A_SlidingWindow.findMinSubArray(7, new int[] {2, 1, 5, 2, 8}));

        //Longest Substring
        //Given a string, find the length of the longest substring in it with no more than K distinct characters.
        //Input: String="araaci", K=2
        //output 4
        //System.out.println(A_SlidingWindow.LongestSubstringKDistinct("cbbebi", 3));

        //fruits in a basket: Write a function to return the maximum number of fruits in both the baskets.
        //Input:  Fruit=['A', 'B', 'C', 'A', 'C']
        //Output: 3
        //Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
        //System.out.println(A_SlidingWindow.maxFruitsIn2Baskets(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));

        //No-repeat Substring
        //Given a string, find the length of the longest substring which has no repeating characters.
        //Input: String="aabccbb"
        //Output: 3
        //Explanation: The longest substring without any repeating characters is "abc".
        //System.out.println(A_SlidingWindow.NoRepeatSubstringProblem("abccde"));

        //Longest SubString
        //Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
        // find the length of the longest substring having the same letters after replacement.
        //Input: String="aabccbb", k=2
        //Output: 5
        //Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
        //System.out.println(A_SlidingWindow.longestSubStringAfterReplacement("abccde", 1));

        //Longest SubArray with Ones After Replacement
        //Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
        // find the length of the longest contiguous subarray having all 1s.
        //Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
        //Output: 6
        //Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
        //System.out.println(A_SlidingWindow.longestSubArrayAfterReplacement(new int[]{ 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));

        //String Permutations
        //Given a string and a pattern, find out if the string contains any permutation of the pattern.
        //Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

        //abc
        //acb
        //bac
        //bca
        //cab
        //cba

        // a string has ‘n’ distinct characters it will have n!n!n! permutations.

        //Input: String="oidbcaf", Pattern="abc"
        //Output: true
        //Explanation: The string contains "bca" which is a permutation of the given pattern.
        System.out.println(A_SlidingWindow.stringPermutationOfAPattern("oidbcaf", "abc"));
    }
}
