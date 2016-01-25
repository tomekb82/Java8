package stream.parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class ParallelStreams {

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static void delay1() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static int delayOperation(){
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        names.stream().map(el -> {
            try {
                delay1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return el;
        }).collect(toList());
        return 0;
    }

    public static int parallelDelayOperation(){
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        names.parallelStream().map(el -> {
            try {
                delay1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return el;
        }).collect(toList());
        return 0;
    }

    public static long sequentialSum(long n) {

        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    public static long parallelSum(long n) {
        // TODO: ?? dlaczego tak wolno ?
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    public static long rangedSum(long n) {

        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        private long total = 0;

        public void add(long value) {
            total += value;
        }
    }
}
