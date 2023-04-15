package stream;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by libsys on 1/6/2023.
 */
public class MainDriver {
    public static void main(String[] args){

        System.out.println(
                IntStream.of(1,2,3,4,5,5,6,4,5).boxed().collect(Collectors.toList())
                        .stream()
                        .collect(
                                Collectors.groupingBy(Function.identity(),Collectors.counting())
                        )
        );
    }
}
