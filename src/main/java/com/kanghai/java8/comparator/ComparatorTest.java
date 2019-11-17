package com.kanghai.java8.comparator;

import java.util.function.Function;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/18 1:05
 * @description
 */

public class ComparatorTest {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);  // g(f(x))
        System.out.println(result);

        Function<Integer, Integer> e = f.compose(g); //f(g(x))
        int result2 = h.apply(1);
        System.out.println(result2);

    }
}
