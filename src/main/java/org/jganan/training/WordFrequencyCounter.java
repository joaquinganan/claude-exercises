package org.jganan.training;

public class WordFrequencyCounter {

        public static void main() {
            String sentence = "The quick brown fox jumps over the lazy dog";

            printAnalysis(sentence);

        }

        public static int countChars(String sentence) {

            String trimmedSentence = sentence.replaceAll("\\s", "");
            return trimmedSentence.length();

        }

        public static int calculateWordCount(String sentence) {
            String[] words = sentence.split(" ");
            return words.length;
        }

        public static int countVowels(String sentence) {
            int count = 0;
            String loweredSentence = sentence.toLowerCase();
            for (int i = 0; i < loweredSentence.length(); i++) {
                char c = loweredSentence.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' ||c == 'o' || c == 'u') count++;
            }
            return count;
        }

        public static int countConsonants(String sentence) {
            return countChars(sentence) - countVowels(sentence);
        }

        public static double calculateAverageLength(String sentence) {
            return (double) countChars(sentence) / calculateWordCount(sentence);

        }

    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length())
                longest = words[i];  // store the raw word only
        }
        return "\"" + longest + "\" (" + longest.length() + " chars)";  // format at the end
    }

        public static void printAnalysis(String sentence) {
            int characters = countChars(sentence);
            int words = calculateWordCount(sentence);
            double avgLength = calculateAverageLength(sentence);
            int vowels = countVowels(sentence);
            int consonants = countConsonants(sentence);
            String longest = findLongestWord(sentence);

            System.out.println("=== TEXT ANALYSIS ===");
            System.out.printf("%-10s : \"%s\"%n", "Sentence", sentence);
            System.out.printf("%-10s : %d%n", "Characters", characters);
            System.out.printf("%-10s : %d%n", "Words", words);
            System.out.printf("%-10s : %d%n", "Vowels", vowels);
            System.out.printf("%-10s : %d%n", "Consonants", consonants);
            System.out.printf("%-10s : %.2f%n", "Avg Length", avgLength);
            System.out.printf("%-10s : %s%n", "Longest", longest);
        }
}