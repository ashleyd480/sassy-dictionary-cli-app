package interfaces;

public interface Writer {public void forceFileExist(String target);
}

//We use interface so other classes, say if we have multiple writers can implement this method.