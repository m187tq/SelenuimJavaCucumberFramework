package practice.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class using_distinct_min_and_max {

    @Test
    public void distinct_min_max_methods(){
        List<Integer> numbersList = Arrays.asList(1,2, 3, 4, 4, 5, 10);

        // distinct method
        numbersList.stream().distinct().forEach(n->System.out.println(n));
        List<Integer> numbers =  numbersList.stream().distinct().collect(Collectors.toList());
        System.out.println(numbers);

        // min  method
        Optional<Integer> minNumber =  numbersList.stream().distinct().min((n1, n2)-> {
                                    return n1.compareTo(n2);
        });

        System.out.println("Min number: " +minNumber);


        Optional<Integer> maxNumber =  numbersList.stream().distinct().max((m1, m2)-> {
                                    return m1.compareTo(m2);
        });

        System.out.println("Max number: " +maxNumber);

        System.out.println("Max is of higher value: " + (maxNumber.get()>minNumber.get()));
        Assert.assertTrue(maxNumber.get()>minNumber.get());

        //reduce method
        Optional<Integer> reducedValue = numbersList.stream().reduce((value, valueCombined)-> {
            return value+valueCombined;
        });

        System.out.println("Reduced Values: " +reducedValue.get());
    }

}
