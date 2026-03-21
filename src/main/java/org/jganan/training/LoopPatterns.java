package org.jganan.training;

public class LoopPatterns {

    public static void main() {
        int[] values = {10, 20, 30, 40, 50};

        System.out.println("=== FOR LOOP ===");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + (i < 5 ? " " : "\n"));
        }

        System.out.println("=== WHILE (sum evens) ===");
        int sum = 0, i = 1;
        while (i <= 10) {
            if (i % 2 == 0) sum += i;
            i++;
        }
        System.out.println("Sum of evens 1-10: " + sum);

        System.out.println("=== DO-WHILE ===");
        int n = 1;
        do {
            System.out.print(n + (n < 5 ? " " : "\n"));
            n++;
        } while (n <= 5);

        System.out.println("=== FOR + CONTINUE (skip index 2) ===");
        for (int j = 0; j < values.length; j++) {
            if (j == 2) continue;
            System.out.print(values[j] + (j < values.length - 1 ? " " : "\n"));
        }

        System.out.println("=== NESTED (3x3 table) ===");
        for (int j = 1; j <= 3; j++) {
            for (int c = 1; c <= 3; c++)
                System.out.print(j * c + (c < 3 ? " " : ""));
            System.out.println();
        }
    }

}
