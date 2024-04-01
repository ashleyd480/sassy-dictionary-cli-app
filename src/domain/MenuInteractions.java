package domain;

import Uitils.MenuFinderMethods;
import Uitils.MenuOtherMethods;

import java.util.List;
import java.util.Scanner;



public class MenuInteractions extends WordWriter {


    /*Here we practice using a private method echoChoice This method can only be called within that class.
    This method would not be needed to be called in any other class. #OCP
    Also, the parameter of choice keeps it DRY because rather than writing out each choice by hand, the system will replace the choice parmaater variable with the choice value the user chose.
     */
    private static void echoChoice (int choice) {
        System.out.println("\n" + "**********" + "\n" + "You chose " + choice);
    }

    /* In handleUserInput, we pass along parameters that are used in this method.
    Since we're defining the method here, we also must make sure to include the data type.
    These are just "variables" for now, and the value is not assigned until the main Dictionary App
    class. #OCP
 */
    public static void handleUserInput(int choice, Scanner scanner, List<Word> listOfWords) {

        // switch used to define behavior for each option that user can choose from
        /*The switch statement takes the choice parameter to determine which case to execute based on the user's input.
        A default case is defined below for if none of the options match. */
            switch (choice) {

                case 1:
                    // Find words by word match logic
                     echoChoice (choice);
                    MenuFinderMethods.findAWord(scanner, listOfWords);
                    break;
                case 2:
                    // Find words by definition logic
                    echoChoice (choice);

                    MenuFinderMethods.findWordByDefinition(scanner, listOfWords);
                    break;
                case 3:
                    // Find all words that start with logic
                    echoChoice (choice);
                    MenuFinderMethods.findWordsStartWithPrefix(scanner, listOfWords);
                    break;
                case 4:
                    // Find all words that end with logic
                    echoChoice (choice);
                    MenuFinderMethods.findWordsEndWithSuffix(scanner, listOfWords);
                    break;
                case 5:
                    // Find all words containing logic
                    echoChoice (choice);
                    MenuFinderMethods.findWordContains(scanner, listOfWords);
                    break;
                case 6:
                    // Add a word logic
                    echoChoice (choice);
                    MenuOtherMethods.addAWord(scanner, listOfWords);
                    break;
                case 7:
                    // Delete a word logic
                    echoChoice (choice);
                    MenuOtherMethods.deleteAWord(scanner, listOfWords);
                    break;
                case 8:
                    // History logic
                    echoChoice (choice);
                    MenuOtherMethods.displayHistory(scanner, listOfWords);
                    break;
                case 9:
                    // Creator logic
                    echoChoice (choice);
                    System.out.println("I was developed by Ashley");
                    System.out.println("..But this sass, it's all me!");
                    break;
                case 10:
                    // Exit logic
                    echoChoice (choice);
                    MenuOtherMethods.sayGoodbye();
                    System.exit(0); //This terminates the Java Virtual Machine aka JVM
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

