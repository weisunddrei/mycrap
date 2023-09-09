import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MainClassTest extends MainClass{
    
    @Test
    public void testGetLocalNumber(){
        Assert.assertTrue("Variable A is not equal to 14", firstTest > 14 || firstTest < 14);
    }
    
    @Test
    public void testGetClassNumber() {
        int number = getClassNumber();
        Assert.assertTrue("Number less than 45", number > 45);
    }
    
    @Test
    public void testGetClassString() {
        String Str = getClassString();
        Assert.assertTrue("Hello World? No", Str == "Hello, world");
    }
}
