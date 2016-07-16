package maps;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tomek on 16.07.16.
 */

public class MapOperations {

    public static List<Person> createPeople(){
        return Arrays.asList(
                new Person("Tomek", Gender.MALE, 34),
                new Person("Tomek", Gender.MALE, 22),
                new Person("Tomek", Gender.MALE, 12),
                new Person("Basia", Gender.FEMALE, 12),
                new Person("Kasia", Gender.FEMALE, 23),
                new Person("Adam", Gender.MALE, 45)
        );
    }
    public static void main(String[] args){
        List<Person> people = createPeople();

        System.out.println(
                people.stream()
                        .collect(Collectors.toMap(
                                person -> person.getName() + "-" + person.getAge(),
                                person -> person )));

        System.out.println(
                people.stream()
                        .collect(Collectors.groupingBy(Person::getName,
                                Collectors.mapping(Person::getAge, Collectors.toList()))));
    }
}
