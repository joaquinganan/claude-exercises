package org.jganan.training;

import java.util.Locale;

public class StringWorkshop {

    public static void main() {
        String sentence = "The quick brown fox";
        double price = 9.5;

        char firstCharacter = sentence.charAt(0);
        char lastCharacter = sentence.charAt(sentence.length() - 1);

        System.out.println("Original: " + sentence);
        System.out.println("Upper: " + sentence.toUpperCase());
        System.out.println("Length: " + sentence.length());
        System.out.println("First char: " + firstCharacter);
        System.out.println("Last char: " + lastCharacter);
        System.out.println("Contains fox: " + sentence.contains("fox"));
        System.out.println("Replaced: " + sentence.replace("fox", "cat"));
        System.out.printf("Price: $%.2f%n", price);
    }
}