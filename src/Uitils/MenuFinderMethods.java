package Uitils;

import domain.Word;
import domain.WordWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MenuFinderMethods {


    //Global history variable tht initializes an empty array
    /* Here we make it global, so we can access it outside MenuFinderMethods, i.e. when we want to display the history of searches made from Case 1: findAWord. */

    private static List<String> history = new ArrayList<>();


    //getter
    public static List<String> getHistory() {
        return history;
    }

/* Within each, method we have the parameters of scanner and array list listOfWords. For now, these are parameters, and when we call these methods again in MenuInteractions, we pass along those parameters. These parameters aren't given values until the DictionaryApp class. */

// Case 1 --- Find word(s) by search term = word
    /*We take our arrayList of word instances and stream and filter it based on matching of the word to search term.. (Each word instance has a word attribute that we access via the getWord getter.) */
    public static void findAWord(Scanner scanner, List<Word> listOfWords) {
        System.out.println("What word do you wanna search?");
        String searchTerm = scanner.nextLine();
        history.add(searchTerm);
        List<Word> filteredListOfWords = listOfWords.stream().filter(word -> {
            return word.getWord().equalsIgnoreCase(searchTerm);
        }).toList();
        // Here we have validation.

       /* If there are no matches, the filtered array list would be empty. I refer to it by its variable vs typing the whole filter array function out again to keep it #DRY. */

        /* If no matches, we display a randomized sassy message to say it's not found, else we can display a randomized sassy message to say it's found.
        * Then we iterate through the filtered array list (of type Word), and for each word instance, we print out the results- and the custom format is provided by the Override method in the Word class. */
        if (filteredListOfWords.isEmpty()) {
            System.out.println(Sassy.sayCantFind());
        } else {
            System.out.println(Sassy.sayFoundIt());
            for (Word word : filteredListOfWords) {
                System.out.println(word);
            }

        }
    }

    // Case 2 --- Find word(s) by definition
    public static void findWordByDefinition(Scanner scanner, List<Word> listOfWords) {
        System.out.println("What definition do you wanna search by?");
        String searchTermDefinition = scanner.nextLine().toLowerCase();
        List<Word> filteredListOfWordsByDefinition = listOfWords.stream().filter(word -> {return
            word.getDefinition().toLowerCase().contains(searchTermDefinition);
        }).toList();
        if (filteredListOfWordsByDefinition.isEmpty()) {
            System.out.println(Sassy.sayCantFind());
        } else {
            System.out.println(Sassy.sayFoundIt());
            for (Word word : filteredListOfWordsByDefinition) {
                System.out.println(word);
            }

        }
    }

    // Case 3 --- Find word(s)that start with

    public static void findWordsStartWithPrefix(Scanner scanner, List<Word> listOfWords) {
        System.out.println("What prefix do you wanna search by?");
        String prefix = scanner.nextLine().toLowerCase();
        List<Word> filteredWordStartWithPrefix = listOfWords.stream()
                .filter(word -> {
                    return word.getWord().toLowerCase().startsWith(prefix);
                }).toList();
        if (filteredWordStartWithPrefix.isEmpty()) {
            System.out.println(Sassy.sayCantFind());
        } else {
            System.out.println(Sassy.sayFoundIt());

            for (Word word : filteredWordStartWithPrefix) {
                System.out.println(word);
            }
        }
    }

    // Case 4 --- Find word(s) that ends with
    public static void findWordsEndWithSuffix(Scanner scanner, List<Word> listOfWords) {
        System.out.println("What suffix do you wanna search by?");
        String suffix = scanner.nextLine().toLowerCase();
        List<Word> filteredWordEndWithSuffix = listOfWords.stream()
                .filter(word -> {
                    return word.getWord().toLowerCase().endsWith(suffix);
                }).toList();
        if (filteredWordEndWithSuffix.isEmpty()) {
            System.out.println(Sassy.sayCantFind());
        } else {
            System.out.println(Sassy.sayFoundIt());

            for (Word word : filteredWordEndWithSuffix) {
                System.out.println(word);
            }
        }
    }

    // Case 5 --- Find word(s) that contain

    public static void findWordContains(Scanner scanner, List<Word> listOfWords) {
        System.out.println("Enter the search term for what word should contain");
        String containTerm = scanner.nextLine().toLowerCase();
        List<Word> filteredWordContainsString = listOfWords.stream()
                .filter(word -> {
                    return word.getWord().toLowerCase().contains(containTerm);
                }).toList();
        if (filteredWordContainsString.isEmpty()) {
            System.out.println(Sassy.sayCantFind());
        } else {
            System.out.println(Sassy.sayFoundIt());

            for (Word word : filteredWordContainsString) {
                System.out.println(word);
            }

        }

    }
}

