import org.junit.jupiter.api.Test;

public class MainClass {

    public int firstTest = 14;
    private int classNumber = 20;
    private String classString = "Hello, world";

    public String getClassString(){
        return classString;
    }

    public int getLocalNumber(){
        return firstTest;
    }

    public int getClassNumber(){
        return classNumber;
    }
}