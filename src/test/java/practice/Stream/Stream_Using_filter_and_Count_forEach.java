package practice.Stream;

import com.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_Using_filter_and_Count_forEach extends BasePage {

    public Stream_Using_filter_and_Count_forEach() throws IOException {
        super();
    }

    @Test
    public void using_filter_and_count() {

        getDriver().get("https://automationteststore.com/index.php?rt=product/category&path=43_46");
        wait.until(ExpectedConditions.titleIs("Face"));

        List<WebElement> itemNames = getDriver().findElements(By.cssSelector(".prdocutname"));
        List<String> originalList = itemNames.stream().map((itemName)->itemName.getText()).collect(Collectors.toList());
        System.out.println("Original List: " + originalList);

        Long s = originalList.stream().filter(i->i.startsWith("B")).count();
        System.out.println("NoOfItems starting with letter B : " + s);

        originalList.stream().filter(i->i.length()>4).forEach(i->System.out.println(i));
        originalList.stream().filter(i->i.length()>4).forEach(System.out :: println);

        System.out.println("==========================================");

        originalList.stream().filter(i->i.length()>5).limit(2).forEach(i->System.out.println(i));
        System.out.println("=====================================================");

        originalList.stream().filter(i->i.length()>3).limit(3).map(i->i.toUpperCase()).forEach(i->System.out.println(i));

            getDriver().quit();
    }


}
