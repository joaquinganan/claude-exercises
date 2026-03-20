package org.jganan.training;

public class ElectionResults {

    public static void main() {
        String[] candidates = {"Koopa","Birdo","Wario","Yoshi"};
        int[] votes = {0,1,2,0,3,0,1,2,0,0,3,1,0,2,0,1,3,0,2,1};

        int[] counts = new int[candidates.length];
        for (int v : votes) counts[v]++;

        sortDescending(candidates, counts);
        System.out.println("=== ELECTION RESULTS ===");
        for (int i = 0; i < candidates.length; i++) {
            System.out.printf("%-6s : %d votes (%.1f%%)%n", candidates[i], counts[i], calculatePercent(counts[i], votes.length));
        }
        System.out.println("Total votes: " + votes.length);
        System.out.println("---");

        /*
        At this point the arrays are already sorted descending, so counts[0] holds the highest vote count
        and candidates[0] holds the name of the leading candidate.
        votes.length is the total number of votes cast — in our case 20.
         */
        if (counts[0] > votes.length/2.0)
            System.out.println("WINNER: " + candidates[0]);
        else {
            System.out.println("No outright winner.");
            System.out.println("RUNOFF: " + candidates[0] + " vs " + candidates[1]);
        }
    }

    public static double calculatePercent(int count, int total) {
        return (double) count / total * 100;
    }

    public static void sortDescending(String[] candidates, int[] counts){
        int n = counts.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (counts[j] < counts[j + 1]) {
                    int tv = counts[j];
                    counts[j] = counts[j + 1];
                    counts[j + 1] = tv;

                    String tc = candidates[j];
                    candidates[j] = candidates[j + 1];
                    candidates[j + 1] = tc;
                }
            }

        }
    }

}