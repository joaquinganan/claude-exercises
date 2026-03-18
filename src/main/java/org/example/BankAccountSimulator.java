package org.example;

import java.text.NumberFormat;

public class BankAccountSimulator {
    final static int DEPOSIT = 0;
    final static int WITHDRAW = 1;
    final static int TRANSFER = 2;
    /*
    Expected Output:
    Processing transactions...
    [OK]   Alice   DEPOSIT   +$500.00 | Balance: $1500.00
    [OK]   Bob     WITHDRAW  -$200.00 | Balance: $800.00
    [SKIP] Carol   WITHDRAW  -$5000.00 | Insufficient funds
    [OK]   Alice   TRANSFER  -$300.00 to Bob | Alice: $1200.00 Bob: $1100.00
    ---
    === FINAL BALANCES ===
    Alice   $1200.00
    Bob     $1100.00
    Carol   $750.00
     */
    public static void main() {

        String[] names    = {"Alice","Bob","Carol"};
        double[] balances = {1000.0, 1000.0, 750.0};

        // Transactions: {fromAccount, toAccount, amount, type}
        // type: 0=deposit, 1=withdraw, 2=transfer
        double[][] transactions = {
                {0, -1, 500,  DEPOSIT},
                {1, -1, 200,  WITHDRAW},
                {2, -1, 5000, WITHDRAW},
                {0,  1, 300,  TRANSFER}
        };

        System.out.println("Processing transactions...");
        processTransactions(names, balances, transactions);
        System.out.println("---");
        printReport(names, balances);

    }

    public static void deposit(double[] balances, int idx, double amount) {
        balances[idx] += amount;
    }

    public static boolean withdraw(double[] balances, int idx, double amount) {
        if (balances[idx] < amount) return false;
        balances[idx] -= amount;
        return true;
    }

    public static void processTransactions(String[] names, double[] balances, double[][] transactions) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        for (double[] txn : transactions) {
            int     from    = (int) txn[0];
            int     to      = (int) txn[1];
            double  amount  = txn[2];
            int     type    = (int) txn[3];

            if(type == DEPOSIT) {
                deposit(balances, from, amount);
                System.out.printf("[OK]   %-6s DEPOSIT   +%s | Balance: %s%n",
                        names[from], nf.format(amount), nf.format(balances[from]));
            }
            else if (type == WITHDRAW) {
                boolean ok = withdraw(balances, from, amount);
                if (ok)
                    System.out.printf("[OK]   %-6s WITHDRAW  -%s | Balance: %s%n",
                            names[from], nf.format(amount), nf.format(balances[from]));
                else
                    System.out.printf("[SKIP] %-6s WITHDRAW  -%s | Insufficient funds%n",
                            names[from], nf.format(amount));
            } else if (type == TRANSFER) {
                boolean ok = withdraw(balances, from, amount);
                if (ok) {
                    deposit(balances, to, amount);
                    System.out.printf("[OK]   %-6s TRANSFER  -%s to %s | %s: %s %s: %s%n",
                            names[from], nf.format(amount), names[to],
                            names[from], nf.format(balances[from]),
                            names[to],   nf.format(balances[to]));
                }
            }
        }
    }

    public static void printReport(String[] names, double[] balances) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("=== FINAL BALANCES ===");
        for (int i = 0; i < names.length; i++)
            System.out.printf("%-8s %s%n", names[i], nf.format(balances[i]));
    }

}