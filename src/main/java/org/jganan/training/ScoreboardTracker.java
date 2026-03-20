package org.jganan.training;

public class ScoreboardTracker {

    public static void main () {
        String[] players = {"Mario","Luigi","Peach","Bowser","Toad"};
        int[] scores     = {4200, 3150, 5800, 2100, 4750};

        sortDescending(players, scores);
        printScoreboard(players, scores);
        printStats(players, scores);

    }

    public static void sortDescending(String[] players, int[] scores){
        int n = scores.length;
        for (int i = 0; i < n -1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (scores[j] < scores[j + 1]) {
                    //You cannot swap two variables in two steps. If you wrote scores[j] = scores[j+1] first, the original value of scores[j] would be lost forever. So:
                    //Line 1 saves scores[j] into a temporary variable ts before it gets overwritten.
                    //Line 2 overwrites scores[j] with the value from scores[j+1].
                    //Line 3 puts the saved original value into scores[j+1].
                    int ts = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = ts;

                    String tp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = tp;
                }
            }
        }
    }

    public static void printScoreboard(String[] players, int[] scores){
        System.out.println("=== SCOREBOARD ===");
        for (int i = 0; i < players.length; i++) {
            System.out.printf("%d. %-7s - %d pts%n", i + 1, players[i], scores[i]);
        }
        System.out.println("---");

    }

    public static void printStats(String[] players, int[] scores){
        int hi = 0, lo = 0, sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > scores[hi]) hi = i;
            if (scores[i] < scores[lo]) lo = i;
        }
        for(int s : scores) sum+= s;
        System.out.printf("Highest: %s (%d)%n", players[hi], scores[hi]);
        System.out.printf("Lowest: %s (%d)%n", players[lo], scores[lo]);
        System.out.printf("Average: %.2f%n", (double) sum / scores.length);
    }

}
