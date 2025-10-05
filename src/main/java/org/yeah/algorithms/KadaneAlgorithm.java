package org.yeah.algorithms;

public class KadaneAlgorithm {
    private int comparisons;
    private int arrayAccesses;

    public static class MaxSubarrayResult {
        public final int maxSum;
        public final int startIndex;
        public final int endIndex;
        public final int operations;

        public MaxSubarrayResult(int maxSum, int start, int end, int ops) {
            this.maxSum = maxSum;
            this.startIndex = start;
            this.endIndex = end;
            this.operations = ops;
        }

        @Override
        public String toString() {
            return String.format("MaxSum: %d, Range: [%d, %d], Operations: %d",
                    maxSum, startIndex, endIndex, operations);
        }
    }

    public MaxSubarrayResult findMaxSubarray(int[] nums) {
        resetMetrics();

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        if (nums.length == 1) {
            arrayAccesses++;
            return new MaxSubarrayResult(nums[0], 0, 0, getTotalOperations());
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int start = 0, end = 0;
        int tempStart = 0;

        arrayAccesses += 2;

        for (int i = 1; i < nums.length; i++) {
            arrayAccesses++;
            comparisons++;

            if (maxEndingHere < 0) {
                maxEndingHere = nums[i];
                tempStart = i;
                arrayAccesses++;
            } else {
                maxEndingHere += nums[i];
                arrayAccesses++;
            }

            comparisons++;
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        return new MaxSubarrayResult(maxSoFar, start, end, getTotalOperations());
    }

    private void resetMetrics() {
        comparisons = 0;
        arrayAccesses = 0;
    }

    private int getTotalOperations() {
        return comparisons + arrayAccesses;
    }

    public int getComparisons() { return comparisons; }
    public int getArrayAccesses() { return arrayAccesses; }
}