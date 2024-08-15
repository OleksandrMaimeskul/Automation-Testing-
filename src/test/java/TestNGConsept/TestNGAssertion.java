package TestNGConsept;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    public int multiplication (int number1, int number2){
        return number1*number2;
    }
    @Test
    public void validateHappyPathMultiplication(){
        int actualResult = multiplication(4,3);
        int expectedResult = 12;
        System.out.println(actualResult==expectedResult? "Correct":"Incorrect");
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void validagteZeroLogic(){
        int actualResult = multiplication(0,9999);
        int expected = 0;
        Assert.assertTrue(actualResult==expected);
    }
}
