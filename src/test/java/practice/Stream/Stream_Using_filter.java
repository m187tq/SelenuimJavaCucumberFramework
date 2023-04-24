package practice.Stream;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_Using_filter extends BasePage {

    public Stream_Using_filter() throws IOException {
        super();
    }

    @Test
    public void using_filter_and_count() {

        getDriver().get("https://automationteststore.com/index.php?rt=product/category&path=43_46");
        wait.until(ExpectedConditions.titleIs("Face"));

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<String> originalList = itemNames.stream().map((i)->i.getText()).collect(Collectors.toList());

        List<String> items = Arrays.asList("BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML", "JASMIN NOIR BODY LOTION 6.8 FL OZ","TOTAL MOISTURE FACIAL CREAM");
        List<String> LongItemsName = new ArrayList<String>();
        LongItemsName= originalList.stream().filter(i->i.length()>4 && i.length()<8).collect(Collectors.toList());
        System.out.println("LongItemsName List: " + LongItemsName);
        getDriver().quit();
    }


}
