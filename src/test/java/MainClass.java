import org.junit.jupiter.api.Test;

public class MainClass {

    public int a = 14;
    private int class_number = 20;

    private String class_string = "Hello, world";

    @Test

    public String getClassString(){
        return class_string;
    }

    @Test

    public int getLocalNumber(){
        return a;
    }
    @Test
    public int getClassNumber(){
        return class_number;
        }

}