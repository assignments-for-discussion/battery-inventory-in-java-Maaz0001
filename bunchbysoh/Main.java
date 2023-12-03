package bunchbysoh;

import java.util.Scanner;

public class Main {
    static class CountsBySoH {
        public int healthy = 0;
        public int exchange = 0;
        public int failed = 0;
    }

    static CountsBySoH countBatteriesByHealth(int[] presentCapacities, int ratedCapacity) {
        CountsBySoH counts = new CountsBySoH();

        for (int presentCapacity : presentCapacities) {
            // Compute State of Health (SoH) percentage
            double sohPercentage = (100.0 * presentCapacity ) / ratedCapacity;

            // Classify batteries based on SoH
            if (sohPercentage > 80.0 && sohPercentage <= 100.0) {
                counts.healthy++;
            } else if (sohPercentage >= 62.0 && sohPercentage <= 80.0) {
                counts.exchange++;
            } else {
                counts.failed++;
            }
        }

        return counts;
    }
    static CountsBySoH countBatteriesByHealth(double[] presentCapacities, int ratedCapacity) {
        CountsBySoH counts = new CountsBySoH();

        for (double presentCapacity : presentCapacities) {
            // Compute State of Health (SoH) percentage
            double sohPercentage = ( 100.0 * presentCapacity ) / ratedCapacity;

            // Classify batteries based on SoH
            if (sohPercentage > 80.0 && sohPercentage <= 100.0) {
                counts.healthy++;
            } else if (sohPercentage >= 62.0 && sohPercentage <= 80.0) {
                counts.exchange++;
            } else {
                counts.failed++;
            }
        }

        return counts;
    }

    static void testBucketingByHealth() {
        System.out.println("Counting batteries by State of Health (SoH)...\n");

        // Test data
        int[] presentCapacities = {113, 116, 80, 95, 92, 70};
        int ratedCapacity = 120; 

        // Perform battery health classification
        CountsBySoH counts = countBatteriesByHealth(presentCapacities, ratedCapacity);

        // Assertions
        assert counts.healthy == 2 : "expected number of healthy batteries";
        assert counts.exchange == 3 : "expected number of batteries for exchange";
        assert counts.failed == 1 : "expected number of failed batteries";

        // Display classification results
        System.out.println("Classification Results:");
        System.out.println("Healthy Batteries: " + counts.healthy);
        System.out.println("Batteries for Exchange: " + counts.exchange);
        System.out.println("Failed Batteries: " + counts.failed);

        // Additional test cases
        int[] additionalPresentCapacities = {90, 110, 105, 75,20};
        CountsBySoH additionalCounts = countBatteriesByHealth(additionalPresentCapacities, ratedCapacity);

        // Assertions for additional test case
        assert additionalCounts.healthy == 2 : "expected number of healthy batteries in additional test case";
        assert additionalCounts.exchange == 2 : "expected number of batteries for exchange in additional test case";
        assert additionalCounts.failed == 1 : "expected number of failed batteries in additional test case";

        // Display additional test case results
        System.out.println("\nAdditional Test Case Results:");
        System.out.println("Healthy Batteries: " + additionalCounts.healthy);
        System.out.println("Batteries for Exchange: " + additionalCounts.exchange);
        System.out.println("Failed Batteries: " + additionalCounts.failed);

        // Edge cases and boundary conditions
        double[] edgePresentCapacities = {120.0, 120.0, 120.0, 120.0, 96.0,96.0,74.4,0.0};
        CountsBySoH edgeCounts = countBatteriesByHealth(edgePresentCapacities, ratedCapacity);

        // Assertions for edge cases
        assert edgeCounts.healthy == 4 : "expected number of healthy batteries in edge case";
        assert edgeCounts.exchange == 3 : "expected number of batteries for exchange in edge case";
        assert edgeCounts.failed == 1 : "expected number of failed batteries in edge case";

        System.out.println("\nEdge Case Results:");
        System.out.println("Healthy Batteries: " + edgeCounts.healthy);
        System.out.println("Batteries for Exchange: " + edgeCounts.exchange);
        System.out.println("Failed Batteries: " + edgeCounts.failed);

        // Lower boundary condition with no batteries
        int[] noBatteriesPresent = {};
        CountsBySoH noBatteriesCounts = countBatteriesByHealth(noBatteriesPresent, ratedCapacity);

        // Assertions for no batteries
        assert noBatteriesCounts.healthy == 0 : "expected number of healthy batteries with no batteries";
        assert noBatteriesCounts.exchange == 0 : "expected number of batteries for exchange with no batteries";
        assert noBatteriesCounts.failed == 0 : "expected number of failed batteries with no batteries";

        System.out.println("\nNo Batteries Results:");
        System.out.println("Healthy Batteries: " + noBatteriesCounts.healthy);
        System.out.println("Batteries for Exchange: " + noBatteriesCounts.exchange);
        System.out.println("Failed Batteries: " + noBatteriesCounts.failed);

        // Test with only one battery
        int[] singleBatteryPresent = {110};
        CountsBySoH singleBatteryCounts = countBatteriesByHealth(singleBatteryPresent, ratedCapacity);

        // Assertions for a single battery
        assert singleBatteryCounts.healthy == 1 : "expected number of healthy batteries with a single battery";
        assert singleBatteryCounts.exchange == 0 : "expected number of batteries for exchange with a single battery";
        assert singleBatteryCounts.failed == 0 : "expected number of failed batteries with a single battery";

        System.out.println("\nSingle Battery Results:");
        System.out.println("Healthy Batteries: " + singleBatteryCounts.healthy);
        System.out.println("Batteries for Exchange: " + singleBatteryCounts.exchange);
        System.out.println("Failed Batteries: " + singleBatteryCounts.failed);

        System.out.println("\nDone counting batteries by SoH :)");
    }

    public static void main(String[] args) {
        testBucketingByHealth();
    }
}
