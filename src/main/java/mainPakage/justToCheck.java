package mainPakage;

import mainPakage.POJO.mainAPIContract;
import org.testng.annotations.Test;

public class justToCheck {
    @Test
    public void nemaema(){
        mainAPIContract mn = new mainAPIContract();
        System.out.println(mn.getCourses());
    }
}
