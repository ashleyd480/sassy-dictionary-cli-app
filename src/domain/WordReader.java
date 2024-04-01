package domain;


import interfaces.Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class WordReader implements Reader {
/* This class implements the Reader interface, and the readWord methods is implemented below.
In the future, should there be other readers, then they can each implement their own reader methods #OCP */
    /* ----- READING THE FILE ---
    [Step 1:] create fileReader to read our dictionary.
    * "When you create a new instance of FileReader, you're initializing a new FileReader object that is associated with a specific file on the disk. This object allows you to read characters from the file."
    [Step 2:] Pass new fileReader instance to BufferedReader.
    *  This  allows for more efficient reading (vs fileReader which reads line by line, and includes methods to call like readLine()
    [Step 3:] Initialize an empty variable line that is of type string.
    [Step 4:] The buffered reader will read each line and while it's not blank, we'll keep looping through each line. This text is converted into an ArrayList which we can then manipulate for filtering by words and more.
     */

    //elements in array are instances of Word class

    //array list of Word class
    @Override
    public ArrayList<Word> readWords() {
        ArrayList<Word> wordsList = new ArrayList<>(); // initializing array
        try {
            FileReader fileReader = new FileReader(WordWriter.fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                /*tl;dr
                With each iteration as it goes line by line, we are adding a single newWord instance to the array, and those words have internal list of those attributes.  [Word 1, word 2,]
                 */

                /* Each line has a string array referenced by the variable "word." The regex
                helps split up what would be a long blob of characters into separate substrings.
                Ex: a|big|long|string --> a | big | etc */
                String[] words = line.split(" \\| ");

                // assigning variable to index position in that String array list
                String word = words[0];
                String definition = words[1];
                String partOfSpeech = words[2];
                String exampleUsage = words[3];//putting the chopped up substrings obtained from splitting into a word object (aka instance of Word). This called along with the Word class constructor will allow the program to know that words[0] corresponds to word, etc

                // With each line iteration a newWord instance is made by the Word constructor, defined in our Word class
                /* That constructor says that this.word= word, etc. So essentially, the parameters passed along, which we obtain from the index position in each String Array will be that newWord's attributes. ins*/
                Word newWord = new Word(word, definition, partOfSpeech, exampleUsage);


                wordsList.add(newWord); // adds the newly created Word object newWord to a list named wordsList. This array list is an array of newWord objects

            }
            fileReader.close(); //put outside while loop to close after use
            bufferedReader.close(); //close bufferedReader as well = they are both readers that implement the same interface method of close, so can close both

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex); // use try catch because this is a checked exception
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return wordsList; // Return the arrayList, and  we want it outside the try/catch, so it's returned regardless of error not
    }

}
