package prestassured.deepdive;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.stream.Stream;

public class LambdaFunctionDemo {
    public static void main(String[] args){

        Stream.of(2,3,4,5)
                .filter(x -> x<4)
                .forEach(System.out::println); //[2,3]

        Stream.of("Nilesh", "Poland")
                .filter(s -> s.equals("Nilesh"))
                .forEach(System.out::println);
    }

    // Functional Interface implementation
    String dateToString(LocalDate date){
        return date.getDayOfMonth() + "of" + date.getMonth();
    }

    //As
    Function<LocalDate, String> dateToString = date -> date.getDayOfMonth() + "of" + date.getMonth();


}
