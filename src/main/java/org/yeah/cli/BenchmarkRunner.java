package org.yeah.cli;

import org.yeah.algorithms.KadaneAlgorithm;
import java.io.FileWriter;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Kadane's Algorithm Benchmark ===");

        FileWriter writer = new FileWriter("kadane_performance.csv");
        writer.write("ArraySize,TimeMicros,Operations\n");

        int[] sizes = {100, 1000, 10000, 100000};

        for (int size : sizes) {
            int[] array = generateRandomArray(size);

            long startTime = System.nanoTime();
            KadaneAlgorithm algo = new KadaneAlgorithm();
            KadaneAlgorithm.MaxSubarrayResult result = algo.findMaxSubarray(array);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime) / 1000;
            writer.write(size + "," + duration + "," + result.operations + "\n");

            System.out.println("Size: " + size + " - Time: " + duration + "μs - Operations: " + result.operations);
        }

        writer.close();
        System.out.println("✓ CSV created: kadane_performance.csv");
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100;
        }
        return array;
    }
}