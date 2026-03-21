package org.jganan.training;

public class ArrayAnalyzer {

    public static void main() {
        double[] temps = {22.5, 18.0, 31.2, 25.7, 19.8, 28.4, 15.3};

        System.out.println("=== TEMPERATURES ===");
        printTemps(temps);
        System.out.printf("Highest: %.1f%n", findHighest(temps));
        System.out.printf("Lowest: %.1f%n", findLowest(temps));
        System.out.printf("Average: %.1f%n", calculateAverage(temps));
    }

    public static void printTemps(double[] temps) {
        for (int i = 0; i < temps.length; i++) {
            System.out.println("[" + i + "] " + temps[i]);
        }
    }

    public static double findHighest(double[] temps) {
        double hi = temps[0];

        for (int i = 1; i < temps.length; i++) {
            if (temps[i] > hi) hi = temps[i];
        }

        return hi;
    }

    public static double findLowest(double[] temps) {
        double low = temps[0];

        for (int i = 1; i < temps.length; i++) {
            if (temps[i] < low) low = temps[i];
        }

        return low;
    }

    public static double calculateAverage(double[] temps) {
        double sum = 0;
        for (double c : temps) sum += c;
        return sum / temps.length;
    }
}
