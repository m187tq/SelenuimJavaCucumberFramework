package practice.Stream;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class using_Sorted_Ascending_and_Descending_Order {

    @Test
    public void Sorted_Ascending_and_Descending_Order(){
        List<Integer> numbersList = Arrays.asList(1,2, 3, 4, 4, 5, 10);


        List<Integer> sortedAscendingOrder =  numbersList.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("Sorted Ascending Order: "+sortedAscendingOrder);
        System.out.println("================================================");
        List<Integer> sortedDescendingOrder =  numbersList.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted Descending Order: " +sortedDescendingOrder);

    }

}
