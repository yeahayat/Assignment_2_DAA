package org.yeah.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KadaneAlgorithmTest {

    @Test
    void testNormalCase() {
        KadaneAlgorithm algo = new KadaneAlgorithm();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        KadaneAlgorithm.MaxSubarrayResult result = algo.findMaxSubarray(nums);

        assertEquals(6, result.maxSum);
        assertEquals(3, result.startIndex);
        assertEquals(6, result.endIndex);
    }

    @Test
    void testSingleElement() {
        KadaneAlgorithm algo = new KadaneAlgorithm();
        int[] nums = {5};

        KadaneAlgorithm.MaxSubarrayResult result = algo.findMaxSubarray(nums);

        assertEquals(5, result.maxSum);
        assertEquals(0, result.startIndex);
        assertEquals(0, result.endIndex);
    }

    @Test
    void testAllNegative() {
        KadaneAlgorithm algo = new KadaneAlgorithm();
        int[] nums = {-5, -2, -8, -1, -3};

        KadaneAlgorithm.MaxSubarrayResult result = algo.findMaxSubarray(nums);

        assertEquals(-1, result.maxSum);
        assertEquals(3, result.startIndex);
        assertEquals(3, result.endIndex);
    }
}