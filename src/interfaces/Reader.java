package interfaces;

import domain.Word;

import java.util.ArrayList;

public interface Reader {
    public ArrayList<Word> readWords();
}

//We use interface so other classes, say if we have multiple readers can implement this method.