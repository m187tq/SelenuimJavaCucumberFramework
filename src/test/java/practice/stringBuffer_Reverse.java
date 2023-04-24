package practice;

import org.testng.annotations.Test;

public class stringBuffer_Reverse {

    @Test
    public void stringReverse(){

        StringBuffer sb = new StringBuffer("Benjamin");
        System.out.println(sb.reverse());
        System.out.println(sb.append("Azeta"));
    }
}