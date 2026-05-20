package com.sr.aw.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 219 Contains duplicate II
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */

/**
 * Solution:
 * Uses a sliding window with a hash set.
 * The hash set will store the elements within our current window of size k.
 * As we move through the array, we check each new element against
 * the elements already in our hash set.
 * If we find a match, we know we have a duplicate within k distance.
 * To keep the window size constant, we remove elements that fall out of the window as we slide it forward.
 */
public class ContainsDuplicate2 {
    static void main() {

        containsNearbyDuplicate(new int[]{1,2,3,1}, 3);
        containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);

    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        System.out.println(set);
        for (int i = 0; i < nums.length; i++) {
            //3. Remove the element that is now outside the window
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            // Try to add the current element. If it fails, a duplicate exists.
            //1. Add the element in set till size ok K (this is the window size)
            //2. Add element if it is not already present in set (not duplicate), else return duplicate
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
