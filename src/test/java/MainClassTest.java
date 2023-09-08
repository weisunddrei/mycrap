import org.junit.jupiter.api.Test;

public class MainClassTest extends MainClass{

    @Test
    public void testGetLocalNumber(){
        if (a == 14)
            System.out.println("Правда 14");
        else
            System.out.println("Не 14, точно");
    }

    @Test
    public void testGetClassNumber() {
        int number = getClassNumber();
            if (number > 45) {
                System.out.println("class_number больше 45");
            } else
                System.out.println("class_number меньше 45");
    }
}