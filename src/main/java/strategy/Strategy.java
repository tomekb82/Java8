package strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by tomek on 16.07.16.
 */
public class Strategy {


    public static int totalValues(List<Integer> values, Predicate<Integer> selector){

        // verbose style
        /*
        int result =0;
        for(int e: values){
            if(selector.test(e)){
                result+=e;
            }
        }
        return result;*/

        //functional style
        /*return values.stream()
                    .filter(selector)
                    .reduce(0, Integer::sum);
        */

        // functional, better style */
        return values.stream()
                .filter(selector)
                .mapToInt(e->e)
                .sum();
    }
    
    public static void main(String[] args){

        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(totalValues(values, e->true));
        System.out.println(totalValues(values, Util::isEven));
        System.out.println(totalValues(values, Util::isOdd));

    }
}

class Util {

    public static boolean isEven(int number){
        return number % 2 == 0;
    }

    public static boolean isOdd(int number){
        return number % 2 != 0;
    }
}



