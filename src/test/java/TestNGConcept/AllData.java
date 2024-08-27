package TestNGConcept;

import org.testng.annotations.DataProvider;

public class AllData {
    @DataProvider(name = "pairs")
    public Object[][] getData(){
        return new Object[][]{
                {"Oleksandr","Alina","3"},
                {"Michael", "JackSon", "1"},
                {"A", "B", "C"},
                {"D", "E", "F"}
        };
    }
}
