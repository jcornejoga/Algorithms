package com.cornejo.test.udemy.s1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Assignment1 {

    public static void main(String[] args) {
        consumer();
        supplier();
        predicate();

        List<Person> listPeople = getPeople();
        sortAge(listPeople);
        sortName(listPeople);
        sortHeight(listPeople);
    }

    private static void sortHeight(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getHeight));
        System.out.println("People by height");
        //listPeople.forEach(person -> System.out.println(person.toString()));
        listPeople.forEach(System.out::println);
        /*listPeople.forEach(person -> {
            System.out.println("Person " + person.getName() + " age " + person.getAge() + " height " + person.getHeight());
        });*/
    }

    private static void sortAge(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getAge));
        System.out.println("People by age");
        listPeople.forEach(System.out::println);
        /*listPeople.forEach(person -> {
            System.out.println("Person " + person.getName() + " age " + person.getAge() + " height " + person.getHeight());
        });*/
    }

    private static void sortName(List<Person> listPeople) {
        listPeople.sort(Comparator.comparing(Person::getName));
        System.out.println("People by name");
        listPeople.forEach(System.out::println);
        /*listPeople.forEach(person -> {
            System.out.println("Person " + person.getName() + " age " + person.getAge() + " height " + person.getHeight());
        });*/
    }

    public static void consumer() {
        // 1a
        Printable pl = s -> System.out.println(s);

        pl.print("Printable lambda");

        // 1b
        Consumer<String> cl = s -> System.out.println(s);
        Consumer<String> cmr = System.out::println;
        cl.accept("Printable consumer lambda");
        cmr.accept("Printable consumer method reference");
    }

    public static void supplier() {

        //2a
        Retrievable rl = () -> 77;
        System.out.println(rl.retrieve());

        //2b
        Supplier<Integer> sl = () -> 77;
        System.out.println(sl.get());
    }

    public static void predicate() {
        // 3a
        Evaluate el = i -> i < 0;
        System.out.println("predicate using interface 1 " + el.eval(1));
        System.out.println("predicate using interface -1 " + el.eval(-1));

        // 3b
        Predicate<Integer> pl = i -> i < 0;
        System.out.println("predicate using Predicate 1 " + pl.test(1));
        System.out.println("predicate using Predicate -1 " + pl.test(-1));

        // 3c
        System.out.println("4 is even " + check(4, n -> n % 2 == 0));
        System.out.println("7 is even " + check(7, n -> n % 2 == 0));
        System.out.println("String starts with Mr. " + check("Mr. Joe Bloggs", s -> s.startsWith("Mr.")));
        System.out.println("String starts with Mr. " + check("Ms. Ann Bloggs", s -> s.startsWith("Mr.")));

        Person p = new Person("Ann", 13, 1.4);
        Person p2 = new Person("Mike", 33, 1.8);
        System.out.println("Ann is an adult? " + check(p, ann -> ann.getAge() >= 18));
        System.out.println("Mike is an adult? " + check(p2, mike -> mike.getAge() >= 18));
    }

    public static void function() {
        // 4a
        Functionable fl = i -> "Number is " + i;
        System.out.println(fl.perform(23));

        // 4b
        Function<Integer, String> fl2 = i -> "Number is " + 1;
        System.out.println(fl2.apply(24));
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<Person>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }
    public static <T> boolean check(T t, Predicate<T> p) {
        return p.test(t);
    }
}
