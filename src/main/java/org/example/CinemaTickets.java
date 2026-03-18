package org.example;

public class CinemaTickets {
    final static double STANDARD_PRICE = 12.00;
    final static double PREMIUM_PRICE = 18.00;
    final static double VIP_PRICE = 25.00;
    final static float CHILD_DISCOUNT = 0.6f;
    final static float SENIOR_DISCOUNT = 0.7f;
    final static double TUESDAY_OFF = 2.00;

    public static void main () {

        String[] names    = {"Alice","Bob","Carol","Dave"};
        int[]    ages     = {34, 8, 70, 25};
        String[] seats    = {"Standard","Premium","VIP","Standard"};
        String[] days     = {"Mon","Tue","Tue","Tue"};

        printReceipt(names, seats, ages, days);
    }

    public static void printReceipt(String[] names, String[] seats, int[] ages, String[] days) {
        double price = 0;
        for (int i = 0; i < names.length ; i++) {
            price = calculatePrice(seats[i],ages[i],days[i]);
            String ageLabel = getAgeLabel(ages[i]);
            System.out.printf("%-7s | %-8s | %-7s | %-3s | $%.2f%n",names[i], seats[i], ageLabel, days[i], price);
        }
    }

    public static double getBasePrice(String seat){

        return switch (seat) {
            case "Standard" -> STANDARD_PRICE;
            case "Premium" -> PREMIUM_PRICE;
            case "VIP" -> VIP_PRICE;
            default -> STANDARD_PRICE;
        };
    }

    public static double calculatePrice(String seat, int age, String day) {
        double base = getBasePrice(seat);
        float ageDiscount = getAgeMultiplier(age);

        if (day.equals("Tue")) return base * (double) ageDiscount - TUESDAY_OFF;
        return base * (double) ageDiscount;

    }

    public static float getAgeMultiplier(int age) {

        if (age < 12) return CHILD_DISCOUNT;
        if (age >= 65) return SENIOR_DISCOUNT;
        return 1.0f;

    }

    public static String getAgeLabel(int age) {
        if(age < 12) return "Child";
        if(age >= 65) return "Senior";
        return "Adult";
    }

}