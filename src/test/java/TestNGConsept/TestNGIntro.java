package TestNGConsept;

import org.testng.annotations.Test;

public class TestNGIntro {
    @Test(priority = 2, invocationCount = 5)
    public void test1(){
        System.out.println("Test1");
    }
    @Test(priority = 3, invocationCount = 20)
    public void test2(){
        System.out.println("Test2");
    }
    @Test(priority = 1)
    public void test3(){
        System.out.println("Test3");
    }
}
