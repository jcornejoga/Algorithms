package com.cornejo.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {

    static class Worker {
        String name;
        LocalDate joinDate;

        public Worker(String name, LocalDate joinDate) {
            this.name = name;
            this.joinDate = joinDate;
        }

        String getName() {return name;}
        LocalDate getJoinDate() {return joinDate;}

        @Override
        public String toString() {
            return "name: " + name + " joinDate: " + joinDate;
        }
    }

    static List<Worker> workers;

    public static void main(String[] args) {
        Consumer<String> sc = s -> System.out.println(s);

        sc.accept("Hello world!");

        Consumer<String> sc2 = (System.out::println);

        sc2.accept("Hello World again!!");

        workers = new ArrayList<Worker>();
        workers.add(new Worker("Juan", LocalDate.of(1981, Month.JANUARY, 12)));
        workers.add(new Worker("Pepe", LocalDate.of(2005, Month.APRIL, 6)));
        workers.add(new Worker("Lupe", LocalDate.of(2020, Month.DECEMBER, 10)));
        workers.add(new Worker("Nala", LocalDate.of(1991, Month.APRIL, 21)));

        System.out.println(workers);

        //List<Worker> sortedWorkers = workers.stream().sorted(Comparator.comparing(Worker::getJoinDate)).toList();
        List<Worker> sortedWorkers = workers.stream().sorted(Comparator.comparing(w -> w.getJoinDate())).toList();

        System.out.println(sortedWorkers);

        //List<String> workerNames = workers.stream().map(Worker::getName).toList();
        List<String> workerNames = workers.stream().map(worker -> worker.getName()).toList();

        System.out.println(workerNames);
    }
}
