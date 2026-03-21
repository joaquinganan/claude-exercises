package org.jganan.training;

public class GradeClassifier {
    static final int A = 90;
    static final int B = 80;
    static final int C = 70;
    static final int D = 60;

    public static void main() {
        int score1 = 78;
        int score2 = 85;
        int score3 = 72;

        double average = calculateAverage(score1, score2, score3);
        char letterGrade = getLetterGrade(average);
        String status = average >= 60 ? "Pass" : "Fail";
        String description = getDescription(letterGrade);

        System.out.println("=== GRADE REPORT ===");
        System.out.printf("Scores: %d, %d, %d%n", score1, score2, score3);
        System.out.printf("Average: %.2f%n", average);
        System.out.printf("Grade: %c%n", letterGrade);
        System.out.printf("Status: %s%n", status);
        System.out.printf("Description: %s performance%n", description);
    }

    public static double calculateAverage(int score1, int score2, int score3) {
        return (double) (score1 + score2 + score3) / 3;
    }

    public static char getLetterGrade(double average) {
        if (average >= A) return 'A';
        if (average >= B) return 'B';
        if (average >= C) return 'C';
        if (average >= D) return 'D';

        return 'F';
    }

    public static String getDescription(char grade) {
        return switch (grade) {
            case 'A' -> "Excellent";
            case 'B' -> "Good";
            case 'C' -> "Satisfactory";
            case 'D' -> "Needs improvement";
            default -> "Failed";
        };
    }
}
