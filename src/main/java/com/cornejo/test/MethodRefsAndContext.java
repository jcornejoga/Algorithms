package com.cornejo.test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * This class shows the java 8 method reference utilization ot replace lambra expression
 * This is important since the method reference can be used in different contexts and depending on each,
 * this will work accordingly
 */
public class MethodRefsAndContext {

    public static void main(String[] args) {
        // a Supplier doesn't take any arguments, it only returns an Integer Supplier<Integer>
        // the compiler will infer it is not taking any argument but it needs to return a value
        Supplier<Integer> sl = () -> Person.howMany();
        Supplier<Integer> smr = Person::howMany;
        System.out.println(sl.get());
        System.out.println(smr.get());

        // a Function accepts one argument and returns one value Function<T, R>
        // The compiler will infer in this case, when using apply, that it needs one parameter
        // of type Person and it will return an Integer
        Function<Person, Integer> fl = person -> Person.howMany(person);
        Function<Person, Integer> fmr = Person::howMany;
        System.out.println(fl.apply(new Person()));
        System.out.println(fmr.apply(new Person()));

        // A BiFunction accepts two parameters and returns a value BiFunction<T, V, R>
        // The compiler infers the apply method is expecting two parameters of type Person
        // it will return one value of type integer, just by using the two colons just as in the other cases
        BiFunction<Person, Person, Integer> bfl = (p1, p2) -> Person.howMany(p1, p2);
        BiFunction<Person, Person, Integer> bmr = Person::howMany;
        System.out.println(bfl.apply(new Person(), new Person()));
        System.out.println(bmr.apply(new Person(), new Person()));

    }

}

class Person {
    public static Integer howMany(Person... person) {

        for(Person p: person) {
            System.out.println(p);
        }

        return person.length;
    }
}