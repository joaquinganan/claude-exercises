package org.jganan.training;

public class DungeonExplorer {

    public static void main () {
        char[][] dungeon = {
                {'.','T','.','.','E'},
                {'#','#','.','T','.'},
                {'.','E','.','.','.'},
                {'T','.','#','T','E'},
                {'.','.','.','E','T'}
        };

        int treasure = countCell(dungeon, 'T'), enemies = countCell(dungeon, 'E');
        int walls = countCell(dungeon, '#'), empty = countCell(dungeon, '.');

        printMap(dungeon);
        System.out.printf("Treasures: %d  Enemies: %d  Walls: %d  Empty: %d%n", treasure, enemies, walls, empty);
        System.out.println(findBestTreasureRow(dungeon));

    }

    public static void printMap(char[][] dungeon) {
        System.out.println("=== DUNGEON MAP ===");
        System.out.println("+-------+");
        for (char[] row : dungeon) {
            System.out.print("| ");
            for (char c : row) System.out.print(c);
            System.out.println(" |");
        }
        System.out.println("+-------+");
    }

    public static int countCell(char[][] dungeon, char target) {
        int count = 0;
        for (char[] row : dungeon)
            for (char c : row)
                if (c == target) count++;
        return count;
    }

    public static String findBestTreasureRow(char[][] dungeon) {
        int bestRowIndex = 0, bestCount = 0;
        for (int i = 0; i < dungeon.length; i++) {
            int c = 0;
            for (char ch : dungeon[i]) {
                if (ch == 'T') c++;
            }
            if (c > bestCount) {
                bestCount = c;
                bestRowIndex = i;
            }

        }

        return "Best row for treasure: Row " + (bestRowIndex + 1) + " (" + bestCount + " treasures)";
    }
}