package com.kanghai.java8.chapter7.debug;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/8 16:42
 * @description
 */

public class Debugging {
    public static void main(String[] args) {
//        List<Point> points = Arrays.asList(new Point(12, 2), null);
//        points.stream().map(p -> p.getX()).forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        //numbers.stream().map(Debugging::divideByZero).forEach(System.out::println);
        List<Integer> result =
                numbers.stream()
                .peek(x -> System.out.println("from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x%2 == 0)
                .peek(x -> System.out.println("after filter " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit " + x))
                .collect(Collectors.toList());
    }

    public static int divideByZero(int n) {
        return n / 0;
    }

    public static void test1(List<Integer> numbers) {
        numbers.stream().map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);
    }
}
