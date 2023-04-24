package practice.Stream;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class using_concat extends BasePage{

    public using_concat() throws IOException {
        super();
    }

    @Test
    public void all_any_non_Match() {

        getDriver().get("https://automationteststore.com/index.php?rt=product/category&path=43_46");
        wait.until(ExpectedConditions.titleIs("Face"));

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<String> originalList = itemNames.stream().map((itemName)->itemName.getText()).collect(Collectors.toList());
        List<String> items = Arrays.asList("BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML", "JASMIN NOIR BODY LOTION 6.8 FL OZ","TOTAL MOISTURE FACIAL CREAM");

        Stream<String> list1 = originalList.stream();
        Stream<String> list2 = items.stream();
        //List<String> finalList = Stream.concat(list1, list2).collect(Collectors.toList());
        Stream.concat(list1, list2).forEach(f->System.out.println(f));
        getDriver().quit();
    }


}
