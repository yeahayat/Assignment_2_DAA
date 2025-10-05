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

    @Test
    void testAllPositive() {
        KadaneAlgorithm algo = new KadaneAlgorithm();
        int[] nums = {1, 2, 3, 4, 5};

        KadaneAlgorithm.MaxSubarrayResult result = algo.findMaxSubarray(nums);

        assertEquals(15, result.maxSum); // Sum of all elements
        assertEquals(0, result.startIndex);
        assertEquals(4, result.endIndex);
    }

    @Test
    void testEmptyArray() {
        KadaneAlgorithm algo = new KadaneAlgorithm();
        int[] nums = {};

        assertThrows(IllegalArgumentException.class, () -> {
            algo.findMaxSubarray(nums);
        });
    }

    @Test
    void testNullArray() {
        KadaneAlgorithm algo = new KadaneAlgorithm();

        assertThrows(IllegalArgumentException.class, () -> {
            algo.findMaxSubarray(null);
        });
    }

    @Test
    void testPerformanceMetrics() {
        KadaneAlgorithm algo = new KadaneAlgorithm();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        KadaneAlgorithm.MaxSubarrayResult result = algo.findMaxSubarray(nums);

        // Проверяем что метрики собираются
        assertTrue(result.operations > 0);
        assertTrue(algo.getComparisons() > 0);
        assertTrue(algo.getArrayAccesses() > 0);
    }
}