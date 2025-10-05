package org.yeah.cli;

import java.io.FileWriter;

public class SimpleBenchmark {
    public static void main(String[] args) {
        System.out.println("=== Simple CSV Test ===");

        try {
            FileWriter writer = new FileWriter("test.csv");
            writer.write("ArraySize,Time,Operations\n");
            writer.write("100,600,398\n");
            writer.write("1000,70,3998\n");
            writer.close();

            System.out.println("✓ CSV file created successfully!");
            System.out.println("File should be: test.csv");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}