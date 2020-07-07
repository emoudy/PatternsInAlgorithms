package com.company;

import java.util.ArrayList;
import java.util.List;

public class B_TwoPointers {
    static int[] pairInArray(int[] arr, int targetSum) {
        int right = arr.length-1;
        for(int left = 0; left < (arr.length)/2; left++) {
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (targetSum == sum) {
                    return new int[]{left, right};
                } else if (targetSum > sum) {
                    left++;
                } else if (targetSum < sum) {
                    right--;
                }
            }
        }
        return new int[] {-1, -1};
    }

    static int[] squaringSorted(int[] arr) {
        int [] sortedSquaredArr = new int[arr.length];
        int position = arr.length-1;
        int right = arr.length-1;
        int left = 0;

        while (left <= right){
            int squaredLeft = arr[left] * arr[left];
            int squaredRight = arr[right] * arr[right];

            if (squaredLeft > squaredRight){
                sortedSquaredArr[position] = squaredLeft;
                left++;
            } else {
                sortedSquaredArr[position] = squaredRight;
                right--;
            }
            position--;
        }
        return sortedSquaredArr;
    }

    static int[] squaringSortedBookSolution(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

//    static List<List<Integer>> TripletSumToZero(int[] arr) {
//    }
}
