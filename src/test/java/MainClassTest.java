
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainClassTest extends MainClass {

    @Test
    public void testGetLocalNumber() {
        int firstTest = getLocalNumber();
        Assertions.assertEquals(14, firstTest, "Variable firstTest is not equal to 14");
    }

    @Test
    public void testGetClassNumber() {
        int number = getClassNumber();
        Assertions.assertTrue(number > 45, "Number less than 45");
    }

    @Test
    public void testGetClassString() {
        String Str = getClassString();
        Assertions.assertSame("Hello, world", Str, "Cannot see the greetings");
    }
}