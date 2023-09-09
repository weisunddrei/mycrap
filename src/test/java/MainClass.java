import org.junit.jupiter.api.Test;

public class MainClass {

    public int firstTest = 14;
    private int classNumber = 20;
    private String classString = "Hello, world";


    @Test
    public String getClassString(){
        return classString;
    }

    @Test
    public int getLocalNumber(){
        return firstTest;
    }

    @Test
    public int getClassNumber(){
        return classNumber;
    }
}