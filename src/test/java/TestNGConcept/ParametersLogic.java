package TestNGConcept;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersLogic {
    @Parameters("firstName")
    @Test
    public void Person(String name) {
        System.out.println(name);
    }

    @Parameters({"firstName", "first", "second", "third"})
    @Test
    public void pairs(String name, String first, String second, String third) {
        System.out.println(name + first + second + third);
    }
}

