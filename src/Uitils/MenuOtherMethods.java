package Uitils;

import domain.Word;
import domain.WordWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static domain.WordWriter.fileName;

public class MenuOtherMethods {


    // Case 6 --- Add word
    /* The system prompts the user what word they want to add, and their input is what they type on the next line.
     * We include validation to see if the word already exists by filtering the list of words to see if any matches to this added word.
     * If there's a match, that list would not be empty- and hence we would let the user know that the word already exists.
     * If not, then the user is prompted to enter the other attributes of the word. The addWord method from WordWriter is then executed to append the new words to the txt file.
     * Lastly listOfWords.add is used to add the new word the array list as well. */
    public static void addAWord(Scanner scanner, List<Word> listOfWords) {

        System.out.println("What word do you want to add?");
        String word = scanner.nextLine();

        List<Word> filteredListOfWords = listOfWords.stream().filter(eachWord -> {
            return eachWord.getWord().equalsIgnoreCase(word);
        }).toList();
        if (!filteredListOfWords.isEmpty()) {
            System.out.println("Word already exists duh!");
        } else {
            System.out.println("Enter the definition:");
            String definition = scanner.nextLine();

            System.out.println("Enter the part of speech:");
            String partOfSpeech = scanner.nextLine();

            System.out.println("Enter the example usage:");
            String exampleUsage = scanner.nextLine();

            //These two lines below create a new Word object with the provided word, definition, partOfSpeech, and exampleUsage parameters from above, and adds this new Word object to the listOfWords list. Keep in mind, the constructor we had in Word class is what allows the system to know that the parameter values obtained from user input are to be associated with ath Word instance.
            WordWriter.addWord(word, definition, partOfSpeech, exampleUsage);
            listOfWords.add(new Word(word, definition, partOfSpeech, exampleUsage));
            System.out.println("Word added: " + word + "\n" + "But are you gonna add to my salary?");
        }

    }

    // Case 7 --- Delete Word
    /* System gets the word that should be deleted. Then, we stream the array list of words to include only words that shouldn't be deleted.*/
    public static void deleteAWord(Scanner scanner, List<Word> listOfWords) {
        System.out.println("What word do you wanna delete?");
        String wordToDelete = scanner.nextLine();

        List<Word> filteredWordsWithoutDeleted = listOfWords.stream()
                .filter(word -> {
                    return !word.getWord().equalsIgnoreCase(wordToDelete);
                }).toList();
        /* Validation is utilized by then comparing the list array and the filtered list array size. This is to ensure that the word to be deleted exists. If so, then the filtered array size should be less than the original list array.
         * If word to delete doesn't exist, an error message appears.
         * If the word does exist, then we write that filtered array list back to the text file (overriding the existing content).
         * With while(true) loop in DictionaryApp main class, since the fileReader reads at the start of each loop, when the loop re-runs to search, it's reading the updated filtered txt into an arraylist- ensuring the deleted word is not searchable.
         */
        if (listOfWords.size() == filteredWordsWithoutDeleted.size()) {
            System.out.println("Duh! Can't delete because word not found");
        } else {

            try {
                FileWriter fileWriter = new FileWriter(fileName);
                for (Word word : filteredWordsWithoutDeleted) {
                    fileWriter.write(word.toString() + "\n");
                    //using the override toString method from Word to reprint them out
                }
                System.out.println("Word deleted: " + wordToDelete + "\n" + "Now, delete your frown and smile.");
                fileWriter.close(); //have to close, or else won;t save things properly and may block other FileWriters from working
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    // Case 8 --- History

    /* This essentially prints out the history, which we obtain via a getter. Remember the history was initialized as an empty array in MenuFinderMethods. Then as each word is searched, the search term is then added to the history array. We then print this array here. */
    public static void displayHistory(Scanner scanner, List<Word> listOfWords) {
        System.out.println(MenuFinderMethods.getHistory());
    }


    // Case 10 --- Exit
    public static void sayGoodbye() {
        System.out.println(Sassy.sayRandomGoodbye());
    }

}



