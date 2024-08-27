package TestNGConcept;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLogic {

    @Test(dataProvider = "pairs", dataProviderClass = AllData.class)
    public void pairsAndChild(String first, String second, String child) {
        System.out.println(first + second + child);
    }
//    @Test
//    public void pairsAndChild1(){
//        System.out.println("John "+"Travolta" +"2");
//    }
//    @Test
//    public void pairsAndChild2(){
//        System.out.println("Mike "+"Tyson" +"4");
//    }
//    @Test
//    public void pairsAndChild3(){
//        System.out.println("Marko "+"Pollo" +"1");
//    }
//
//    @Test
//    public void pairsAndChild4(){
//        System.out.println("Michael "+"Jackson" +"4");
//    }
}
