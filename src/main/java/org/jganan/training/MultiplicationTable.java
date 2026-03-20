package org.jganan.training;

public class MultiplicationTable {
    static final int SIZE = 5;

    public static void main() {
        int[][] table = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        printTable(table);
        printDiagonal(table);
    }

    public static void printTable(int[][] table) {
        System.out.println("=== MULTIPLICATION TABLE ===");
        System.out.printf("   ");

        for (int i = 1; i <= SIZE; i++) System.out.printf("%4d", i);
        System.out.println();
        for (int j = 0; j < SIZE; j++) {
            System.out.printf("%d |", j + 1);
            for (int i = 0; i < SIZE; i++) System.out.printf("%4d", table[i][j]);
            System.out.println();
        }

        System.out.println("---");
    }

    public static void printDiagonal(int[][] table){
            System.out.print("Diagonal: ");
            for (int i = 0; i < SIZE; i++)
                System.out.print(table[i][i] + (i < SIZE-1 ? " " : ""));
            System.out.println();
    }

}
