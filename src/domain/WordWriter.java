package domain;

import interfaces.Writer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* This class implements the Reader interface, and the readWord methods is implemented below.
In the future, should there be other readers, then they can each implement their own reader methods #OCP */
public class WordWriter implements Writer {

    /* We create the fileName variable to represent the name of the file to keep things DRY. */
    public static String fileName = "lib/dictionary.txt";


    /*Let's first see if the dictionary file exists.
    * If the file doesn't exist, then we should create the new file. This type of method with the file is checked, so it requires a try/catch block.
    * If the file doesn't exist, we run the code in try to create the new file.
    * The catch is the IOException which represents an error during input-output operations, typically errors reading from or writing to a file.
       */
    @Override
    public void forceFileExist(String target) {
        File file = new File(target); //new instance to call non-static method on it
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



    // try/with Block that uses Resource Acquisition Is Initialization; method to add words

    /* A try/with statement allows us to encapsulate the resource in this case FileWriter instance in parentheses, and what this does is allow the resource to be open as we are executing the code in the bracket after. Once done executing, the resource will automatically close. #OCP */

    /*
     * We create a new instance of fileWriter so that we can call methods on it.
     * We use append = true to ensure that any new words being correctly appended to the txt file. This is then read with the WordReader as an arrayList for further manipulation.
     */
         public static void addWord (String word, String definition, String partOfSpeech, String exampleUsage) {
             try ( FileWriter fileWriter = new FileWriter(fileName, true)) {
                 fileWriter.write(word + " | " + definition + " | " + partOfSpeech + " | " + exampleUsage + "\n");
             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }

}





// Option 1 to write the code- but commenting out as wanted to try the Try With Method
//    public static void addWord2(String word, String definition, String partOfSpeech, String exampleUsage) {
//                try {
//                    FileWriter fileWriter = new FileWriter(fileName, true);
//                    fileWriter.write(word + " | " + definition + " | " + partOfSpeech + " | " + exampleUsage + "\n");
//                    fileWriter.close(); //learned I have to add fileWriter.close or else it won't write to that file
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }



