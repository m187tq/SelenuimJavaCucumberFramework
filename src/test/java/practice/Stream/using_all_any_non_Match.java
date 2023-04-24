package practice.Stream;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class using_all_any_non_Match extends BasePage {

    public using_all_any_non_Match() throws IOException {
        super();
    }

    @Test
    public void all_any_non_Match() {

        getDriver().get("https://automationteststore.com/index.php?rt=product/category&path=43_46");
        wait.until(ExpectedConditions.titleIs("Face"));

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<String> originalList = itemNames.stream().map((itemName)->itemName.getText()).collect(Collectors.toList());

        List<String> items = Arrays.asList("BODY CREAM BY BULGARI", "CREME PRECIEUSE NUIT 50ML", "JASMIN NOIR BODY LOTION 6.8 FL OZ","TOTAL MOISTURE FACIAL CREAM");

        System.out.println("Original List: " + originalList);

        boolean anyMatchFlag = originalList.stream().anyMatch(s->s.equalsIgnoreCase("BODY CREAM BY BULGARI"));
        Assert.assertTrue(anyMatchFlag);

        boolean flag = originalList.stream().anyMatch(s->s.startsWith("BODY"));
        Assert.assertTrue(flag);

        boolean allMatchFlag = originalList.stream().allMatch(s->s.startsWith("BODY"));
        Assert.assertFalse(allMatchFlag);

        boolean noneMatchFlag = originalList.stream().noneMatch(s->s.startsWith("BODY"));
        Assert.assertFalse(noneMatchFlag);
        getDriver().quit();
    }


}
