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
    }

    public MaxSubarrayResult findMaxSubarray(int[] nums) {
        return new MaxSubarrayResult(0, 0, 0);
    }
}