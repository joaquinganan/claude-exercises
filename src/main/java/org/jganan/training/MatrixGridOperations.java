package org.jganan.training;

public class MatrixGridOperations {
    static final int ROWS = 3, COLS = 4;

    public static void main() {
        int[][] grid = new int[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = (i + 1) * (j + 1);
            }
        }

        printGrid(grid);
    }

    public static void printGrid (int[][] grid){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.printf("%3d", grid[i][j]);
            }
            System.out.println();
        }
    }

//    public static int rowSum(int[][] grid) {
//
//    }

//    public static int colSum(int[][] grid) {
//
//    }
}
