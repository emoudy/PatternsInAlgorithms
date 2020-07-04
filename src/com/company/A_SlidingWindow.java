package com.company;

import java.util.HashMap;

public class A_SlidingWindow {
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

    static int LongestSubstringKDistinct(String str, int k) {
        //Time complexity O(n)
        //Space complexity O(k)
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        int distinct = 0;
        int windowStart = 0;
        int longestSubStr = 0;

        for(int letter = 0; letter < str.length(); letter++) {
            char character = str.charAt(letter);
            if (!charFrequencyMap.containsKey(character)) {
                if (distinct < k) {
                    charFrequencyMap.put(character, charFrequencyMap.getOrDefault(character, 0) + 1);
                    distinct++;
                } else {
                    int pointer = letter - 1;
                    longestSubStr = Math.max(longestSubStr, letter-windowStart);
                    while (distinct >= k) {
                        charFrequencyMap.put(str.charAt(pointer), charFrequencyMap.getOrDefault(str.charAt(pointer), 0) - 1);
                        if (charFrequencyMap.get(str.charAt(pointer)) == 0) {
                            charFrequencyMap.remove(str.charAt(pointer));
                            distinct--;
                            windowStart = pointer + 1;
                        } else {
                            pointer--;
                        }
                    }
                    charFrequencyMap.put(character, 1);
                    distinct++;
                }
            }
            else {
                charFrequencyMap.put(character, charFrequencyMap.getOrDefault(character, charFrequencyMap.get(character)) + 1);
            }
        }
        return longestSubStr;
    }

    static int LongestSubstringKDistinctBookSolution(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();

        int windowStart = 0, longestSubStr = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            longestSubStr = Math.max(longestSubStr, windowEnd - windowStart + 1); // remember the maximum length so far
        }
        return longestSubStr;
    }

    static int maxFruitsIn2Baskets(char[] arr) {
        //Time complexity O(n)
        //Space complexity O(1)
        int baskets = 2;
        int windowStart = 0;
        int maxFruit = 0;
        int tempMaxFruit = 0;
        HashMap<Character, Integer> fruitFrequencyMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);

            if (fruitFrequencyMap.size() > baskets) {
                char fruitTypeToRemove = arr[windowStart];
                while(arr[windowStart] == fruitTypeToRemove) windowStart++;
                fruitFrequencyMap.remove(fruitTypeToRemove);
            }

            tempMaxFruit = windowEnd - windowStart + 1;
            maxFruit = Math.max(maxFruit, tempMaxFruit);
        }
        return maxFruit;
    }

    static int maxFruitsIn2BasketsBookSolution(char[] arr) {
        int windowStart = 0, maxFruit = 0;
        HashMap<Character, Integer> fruitFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
            // shrink the sliding window, until we are left with '2' fruits in the frequency map
            while (fruitFrequencyMap.size() > 2) {
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++; // shrink the window
            }
            maxFruit = Math.max(maxFruit, windowEnd - windowStart + 1);
        }
        return maxFruit;
    }

    static int NoRepeatSubstringProblem(String str) {
        int windowStart = 0, subStrLength = 0, tempSubStrLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            if (charIndexMap.containsKey(str.charAt(windowEnd))) {
                charIndexMap.clear();
                tempSubStrLength = windowEnd - windowStart;
                windowStart = windowEnd;
            }

            charIndexMap.put(str.charAt(windowEnd), 1);
            subStrLength = Math.max(tempSubStrLength, subStrLength);
        }
        return subStrLength;
    }

    static int NoRepeatSubstringProblemBookSolution(String str) {
        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }

    static int longestSubStringAfterReplacement2(String str, int k) {
        int counter = k, longestSubStr = 0, tempLongestSubStr = 0, windowStart = 0;
        char current = str.charAt(0);

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            if((str.charAt(windowEnd) != current)) {
                counter--;
                if (counter >= 0) {
                    tempLongestSubStr = windowEnd - windowStart + 1;
                } else {
                    while (str.charAt(windowStart) == current || windowStart == windowEnd) {
                        windowStart++;
                    }
                    counter = k;
                    current = str.charAt(windowStart);
                    windowEnd = windowStart;
                }
            } else {
                tempLongestSubStr = windowEnd - windowStart + 1;
            }
                longestSubStr = Math.max(tempLongestSubStr, longestSubStr);
            }
        return longestSubStr;
    }

    static int longestSubStringAfterReplacement(String str, int k) {
        //Time complexity O(n)
        //Space complexity O(1)
        int longestSubStr = 0, windowStart = 0, replacements = 0;
        HashMap<Character, Integer> letterFrequencyMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            replacements = letterFrequencyMap.get(rightChar);

            while (windowEnd - windowStart + 1 - replacements > k){
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }
            longestSubStr = Math.max(windowEnd - windowStart + 1, longestSubStr);
        }
        return longestSubStr;
    }

    static int longestSubStringAfterReplacementBookSolution(String str, int k) {
        //Time complexity O(n)
        //Space complexity O(1)
        int windowStart = 0, longestSubStr = 0, maxRepeatLetterCount = 0;
        HashMap<Character, Integer> letterFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }
            longestSubStr = Math.max(longestSubStr, windowEnd - windowStart + 1);
        }
        return longestSubStr;
    }

    static int longestSubArrayAfterReplacement(int[] arr, int k){
        //Time complexity O(n)
        //Space complexity O(1)
        int windowStart =0, lengthSubArr = 0, onesRepetitions = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            if (arr[windowEnd] == 1) onesRepetitions++;

            int totalReplacements = windowEnd - windowStart + 1 - onesRepetitions;
            if (totalReplacements > k) {
                if (arr[windowStart] == 1) onesRepetitions--;
                windowStart++;
            }

            lengthSubArr = Math.max(windowEnd - windowStart + 1, lengthSubArr);
        }
        return lengthSubArr;
    }

    static boolean stringPermutationOfAPattern(String a, String b){
        boolean isPermutation = false;
        int windowStart = 0, letterCheck = 0;
        
        return isPermutation;
    }
}
