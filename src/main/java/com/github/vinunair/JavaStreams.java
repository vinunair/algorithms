package com.github.vinunair;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    class Person {
        String name;
        int age;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
        return name;
        }
    } 
    public void printStats() {

    }

    public static void main(String args[]) {
        // List<Integer> listOfInts = Arrays.asList(1,3,2,6,4,9,7,10);
        // listOfInts.stream().filter(s -> s%2==0).sorted().map(Integer::toBinaryString).forEach(System.out::println);

        // Stream.of("d2", "a2", "b1", "b3", "c")
        // .filter(s -> {
        // System.out.println("filter: " + s);
        // return true;
        // }).forEach(s -> System.out.println("forEach: " + s));

        // Stream.of("d2", "a2", "b1", "b3", "c")
        // .map(s -> {
        // System.out.println("map: " + s);
        // return s.toUpperCase();
        // }).anyMatch(s -> {
        // System.out.println("anyMatch: " + s);
        // return s.startsWith("A");
        // });

        JavaStreams javaStreams = new JavaStreams();
        System.out.println(javaStreams.nameSeperator(Arrays.asList(  javaStreams.new Person(19,"Vinu"), javaStreams.new Person(22,"Nair"))));
       
    }

    public Map<Integer , String>  convertToMap(List<Person> listOfPersons) {
        return listOfPersons.stream().collect(Collectors.toMap(p-> p.age, p->p.name, (name1,name2) -> name1+", "+name2));    
    }

    public String nameSeperator (List<Person> listOfPersons) {
        String namesWithSeparator = listOfPersons.stream().map(p ->  p.name).collect(Collectors.toMap("|")).toString();
        return namesWithSeparator;
    }
}