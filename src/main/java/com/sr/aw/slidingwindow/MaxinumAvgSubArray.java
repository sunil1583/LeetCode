package com.sr.aw.slidingwindow;

/**
 * 643 Maximum Average Subarray I
 *
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 */

/**
 * Solution:
 * Idea is to calcluate max sum using sliding window anf then calculate and return average
 */
public class MaxinumAvgSubArray {
    static void main() {
        double maxAvg = findMaxAverage(new int[]{1,12, -5, -6, 50, 3}, 4);
        System.out.println(maxAvg);
    }
    public static double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        for(int right = 0; right < k; right++) {
            sum = sum + nums[right];
        }
        int maxSum = sum;
        //slide window
        for(int right = k; right < nums.length; right ++) {
            sum = sum + nums[right];
            sum = sum - nums[right - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }
}
