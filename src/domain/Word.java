package domain;

//Word class represents the fundamental unit of the dictionary application
/* We define the key attributes the Word class has and the data type.
Additionally we show a */
public class Word  {
    private String word;
    private String definition;
    private String partOfSpeech;
    private String exampleUsage;

    // This is the constructor for the Word that is used when we add a word in wordReader.
    /* As each newWord instance is created there, the specific parameters values in each respective constructor are assigned as attributes to that newWord. For example that instance's word would be the word value as the reader reads that particular line.*/
    public Word(String word, String definition, String partOfSpeech, String exampleUsage) {
        this.word = word;
        this.definition = definition;
        this.partOfSpeech = partOfSpeech;
        this.exampleUsage = exampleUsage;
    }

    // Here are getters and setters to access private fields in the Word class.
    /* These come into handy when used in the "conditional" in the return statement of the filter stream method in ArrayList.*/
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getExampleUsage() {
        return exampleUsage;
    }

    public void setExampleUsage(String exampleUsage) {
        this.exampleUsage = exampleUsage;
    }


    //This is so when we sout or call toString on an instance of Word, it displays with this format.
    /* You can see this used for example, when displaying the results in our MenuFinderMethods and MenuOtherMethods. */
    @Override
    public String toString() {
        return String.format ("%s | %s | %s | %s", word, definition, partOfSpeech, exampleUsage);
    }

}

