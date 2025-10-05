package org.yeah.algorithms;

public class KadaneAlgorithm {

    public static class MaxSubarrayResult {
        public final int maxSum;
        public final int startIndex;
        public final int endIndex;

        public MaxSubarrayResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.startIndex = start;
            this.endIndex = end;
        }

        @Override
        public String toString() {
            return String.format("MaxSum: %d, Range: [%d, %d]",
                    maxSum, startIndex, endIndex);
        }
    }

    public MaxSubarrayResult findMaxSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        if (nums.length == 1) {
            return new MaxSubarrayResult(nums[0], 0, 0);
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int start = 0, end = 0;
        int tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = nums[i];
                tempStart = i;
            } else {
                maxEndingHere += nums[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        return new MaxSubarrayResult(maxSoFar, start, end);
    }
}