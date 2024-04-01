package Uitils;

import java.util.Scanner;

public class InputHandler {

    /* Here we create a new scanner instance that reads from the System.in which
    is the standard input stream (console input)
     */
    public static Scanner scanner  = new Scanner(System.in);

    //We use a getter to get this scanner when called in our main DictionaryApp class
    public static Scanner getScanner() {
        return scanner;
    }

/* Below, we are getting the users' input choice from the menu of options.
We use a try catch block to catch inputs that are non-integers.
* Within the try block, we first assign the userChoice variable to the integer
the user types.
* The scanner will only read up to that integer. To ingest the \n character,
we call scanner.nextLine();
* This function returns userChoice which is just the integer. This way,
when we call this method in the main DictionaryApp, we can access what the user's
choice was.
*/

    public static int getUserInput () {
    try {
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        return userChoice;
    } catch (Exception e) {
        System.out.println("You've put an invalid input");
        scanner.next();
      return -1; // if not an integer, then we return -1 (and this value is used in a conditional in our main DictionaryApp- allowing us to restart the main while(true) loop and re-display the menu of options if input is not valid
        }
     }

     /* Without the scanner.next(), it causes an infinite loop where Sassy AI goes "rogue." ;) This is because after the input is typed, the \n still remains in the buffer. Scanner.next() is needed to confirm that character, else /n will indefinitely remain in the buffer, triggering nonstop restarts of the loop.
      */


    // method to display list of options 1-10
    public static void printMenu () {
        System.out.println("**********");
        System.out.println("1. Find a word.");
        System.out.println("2. Find words by definition");
        System.out.println("3. Find all words that start with");
        System.out.println("4. Find all words that end with -");
        System.out.println("5. Find all words containing -");
        System.out.println("6. Add a word");
        System.out.println("7. Delete a word");
        System.out.println("8. History");
        System.out.println("9. Creator");
        System.out.println("10. Exit");

    }



    }
