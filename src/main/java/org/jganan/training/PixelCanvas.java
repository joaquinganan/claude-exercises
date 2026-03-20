package org.jganan.training;

public class PixelCanvas {
    static final int W = 10, H = 10;
    static final char EMPTY = '.';

    public static void main() {
        char[][] canvas = new char[H][W];

        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++) canvas[i][j] = EMPTY;

        drawRectangle(canvas,1,1,5,4,'*');
        System.out.println("=== CANVAS ===");
        printCanvas(canvas);

        drawDiagonal(canvas,'#');
        System.out.println("After diagonal:");
        printCanvas(canvas);
    }

    public static void printCanvas(char[][] canvas) {
        for (char[] rows : canvas) {
            for (char c : rows) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void drawRectangle(char[][] canvas, int x1, int y1, int x2, int y2, char ch){
        for (int i = x1; i <= x2; i++) {
            canvas[y1][i] = ch;
            canvas[y2][i] = ch;
        }
        for (int i = y1; i <= y2; i++) {
            canvas[i][x1] = ch;
            canvas[i][x2] = ch;
        }
    }

    public static void drawDiagonal(char[][] canvas, char ch){
        int len = Math.min(H, W);
        for (int i = 0; i < len; i++) {
            canvas[i][i]=ch;
        }
    }

}
