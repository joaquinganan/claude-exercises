package org.jganan.training;

public class PotionShop {
    static final double BULK_DISCOUNT = 0.90;
    static final int BULK_MIN = 5;

    public static void main() {
        String[] items  = {"Health Potion","Mana Potion","Speed Boost","Shield Brew"};
        double[] prices = {15.0, 20.0, 25.0, 30.0};
        int[]    stock  = {50, 30, 20, 15};
        int[][] orders  = {{0,3},{1,6},{2,2},{3,1},{0,8}};

        System.out.println("=== POTION SHOP ===");
        double total = processOrders(items, prices, stock, orders);
        System.out.printf("---%nTotal: $%.2f%n", total);

        printStock(items, stock);

    }

    public static double calculateOrderPrice(double price, int qty) {
        double total = price * qty;
        if (qty >= BULK_MIN) return total * BULK_DISCOUNT;
        return total;
    }

    public static double processOrders(String[] items, double[] prices, int[] stock, int[][] orders) {
        double total = 0;
        for (int i = 0; i < orders.length; i++) {
            int item = orders[i][0], qty = orders[i][1];
            double price = calculateOrderPrice(prices[item], qty);
            stock[item] -= qty;
            total += price;
            String bulk = qty >= BULK_MIN ? " (BULK)" : "";
            System.out.printf("Order %d: %-15s x%-2d - $%.2f%s%n", i + 1, items[item], qty, price, bulk);
        }
        return total;

}

    public static void printStock(String[] item, int[] stock){
        System.out.println("=== REMAINING STOCK ===");
        for (int i = 0; i < item.length; i++) {
            System.out.printf("%-15s : %d%n", item[i], stock[i]);
        }
    }
}
