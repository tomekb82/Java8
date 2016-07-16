package decorator;

import java.util.function.Function;

/**
 * Created by tomek on 16.07.16.
 */
public class Decorator {

    public static void main(String[] args){

        Function<Integer, Integer> inc = e -> e + 1;
        Function<Integer, Integer> doubleIt = e -> e * 2;

        doWork(5, inc);
        doWork(5, doubleIt);
        doWork(5, inc.andThen(doubleIt));
    }

    private static void doWork(int value, Function<Integer, Integer> func) {

        System.out.println(func.apply(value));

    }
}
