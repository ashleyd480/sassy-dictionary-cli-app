import Uitils.InputHandler;
import Uitils.MenuOtherMethods;
import Uitils.Sassy;
import domain.MenuInteractions;
import domain.Word;
import domain.WordReader;
import domain.WordWriter;

import java.util.List;
import java.util.Scanner;

import static Uitils.InputHandler.scanner;


//This is the entry point of the application where the main method resides

public class DictionaryApp {


    public static void main(String[] args) {
        //Checking if the dictionary file exists and if not, create it
        /*We want to create instances because the methods are not static.
        We use non-static methods when there can be multiple instances of an object, such as in future iterations of this project, we would have multiple types of WordReaders and WordWriters that interact with sentences and more. #OCP
        */
        WordWriter wordWriter = new WordWriter();
        wordWriter.forceFileExist(WordWriter.fileName);

        //creating new instance of wordReader so we can call methods on it
        WordReader wordReader = new WordReader();

        //This is how the welcome messages and instructions are displayed
        Sassy.sayRandomWelcome();
        Sassy.saySteps();

        // The while (true) loop allows the menu to persist.
        /*Side note: List is an interface and arraylist is a class that implements that interface.
By defining it with type List, it allows me flexibility down the line, say if I want to change the implementation of my list to a LinkedList, etc. #OCP */
        while (true) {
            List<Word> listOfWords = wordReader.readWords(); //initial logic to read file first, we have this here so that it reads the updated file (i.e. say if I deleted or added a word- and then want to search)
            InputHandler.printMenu();
            int userInput = InputHandler.getUserInput();
            // We validate if user input from the menu is an integer or not, and if not, then the loop restarts
            if (userInput == -1) {
                continue; //This skips the current loop and restarts it by re-displaying the menu
            }

            //If the user input is an integer, then we handle the userInput
            /*We pass along the variables defined in this method to the parameters
            #OCP. I also define the variables to avoid repeating myself. #DRY
             */
            Scanner inputScanner = InputHandler.getScanner();
            MenuInteractions.handleUserInput(userInput, inputScanner, listOfWords);

            //Once input is handled, user is prompted if they need more help.
            // \n is used for accessibility, as spacing makes it easier to read
            System.out.println("\n" + "Do you still need help? Yes or No?");
            /*We check if the user answers Yes or No.
            * If the user no longer needs help, then the system says googdbye, and the loop is "broken."
            * Else... a sassy reply is generated and the user is prompted to press Enter to continue- and the loop starts over with the menu displayed.*/
            String response = inputScanner.nextLine();
            if (!response.equalsIgnoreCase("Yes")) {
                MenuOtherMethods.sayGoodbye();
                break; // Exit the loop
            } else {
                System.out.println(Sassy.replyForMoreHelp());
                System.out.println("Press Enter to continue...");
                inputScanner.nextLine(); // Wait for the user to press Enter
                // #UX for the above - empowers user to pick and allows more streamlined looping

            }


        }
        /* We close the scanner after all operations are done (after the while loop)
        This is done for security
        */
        scanner.close();

    }
}