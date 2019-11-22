package com.kanghai.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/23 0:58
 * @description
 */

public class StreamUser {
    public static void main(String[] args) {
     test2();
    }

    public static void test(){
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream()
                .filter(i -> i%2==0)
                .distinct()
                .forEach(System.out::println);
    }

    public static void test2(){
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        for(Integer a: wordLengths){
            System.out.println(a);
        }
    }

    public static void test3(){
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
      List<Stream<String>> s =  words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

         List<String> unqiue = words.stream()
                 .map(w -> w.split(""))
                 .flatMap(Arrays::stream)
                 .distinct()
                 .collect(Collectors.toList());

    }
}
