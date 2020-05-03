package pl.codeleak.samples.java10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Java 10 - Local variable type inference")
class Java10VarTests {

    @Test
    void var() {
        var var = "String"; // look the method and variable name!
        var string = "String";
        var stringList = List.of("one", "two", "three");
        var intList = List.of(1, 2, 3);
        var obj = new Object();
        var calcResult = calculate(1, 2);
    }

    @Test
    void varForLambdaExpression() {
        // the below won't compile
        // var runnable1 =  () -> System.out.println("I am running ...");

        // for Lambda expression the type cannot be inferred, hence explicit cast!
        var runnable2 = (Runnable) () -> System.out.println("I am running ...");

    }

    private int calculate(int x, int y) {
        return x + y;
    }

    @Test
    void varInLoops() {

        var numbers = List.of(1, 2, 3, 4, 5);

        for (var number : numbers) {

        }

        for (var i = 0; i < numbers.size(); i++) {

        }

        var i = 0;
        while (i < numbers.size()) {
            i++;
        }
    }

    @Test
    void varInLambda() { // since Java 11
        Processor p = (var s) -> s.toUpperCase();
    }
}

interface Processor {
    String process(String s);
}
