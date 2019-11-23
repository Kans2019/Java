package com.kanghai.java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .collect(toList());

        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .map(t -> t[0]).collect(toList());

        Stream.generate(Math::random)
                .limit(10)
                .map(t -> t*10)
                .forEach(System.out::println);

        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValues = oldPrevious + this.current;
                this.previous = this.current;
                this.current = nextValues;
                return oldPrevious;


            }
        }
    }

    public static void fileTest(){
        long unqiueWords = 0;
        try(Stream<String> lines =
                    Files.lines(Paths.get("data.txt"),Charset.defaultCharset())){
            unqiueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct().count();
        }catch (IOException e){

        }
    }


    public static void test(){
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream()
                .filter(i -> i%2==0)
                .distinct()
                .forEach(System.out::println);
        Stream<String> stream = Stream.of("Java8", "Lambdas","In","Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();

        int[] numbers1 = {1,2,3,4,4,5};
        int sum = Arrays.stream(numbers1).sum();
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

    public static void test4(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> squares = numbers
                .stream()
                .map(n -> n*n)
                .collect(toList());
        squares.stream()
                .forEach(System.out::println);
    }

    public static void test5(){
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        List<int[]> list =  numbers1.stream()
                .flatMap(i ->
                        numbers2.stream()
                                .filter(j -> (i+j)%3 == 0)
                                .map(j -> new int[] {i,j}))
                .collect(toList());
        for (int[] a :list){
            System.out.print("(");
            for (int b :a) {
                System.out.print(b);
            }
            System.out.print(")");
        }
        System.out.println();
        list.stream().forEach(a -> {
            System.out.print("（");
            Arrays.stream(a).forEach(System.out::print);
            System.out.print(")");
        });

//        list.stream().forEach(System.out::println);
//        for(int[] a : list){
//            for (int b : a){
//                System.out.println(b);
//            }
//        }

    }
}
