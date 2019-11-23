package com.kanghai.java8.stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/23 18:29
 * @description
 */

public class RedusceTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        Optional<Integer> min = numbers.stream().reduce(Integer::max);
        System.out.println(min);



    }

    public static void test(List<Integer> numbers){
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        //System.out.println(sum);

        int product = numbers.stream().reduce(1, (a, b) -> a*b);
        //System.out.println(product);

        Optional<Integer> sum2 = numbers.stream().reduce((a, b) -> (a + b));
        List<Integer> numbers2 = Lists.newArrayList();
        //  System.out.println(sum2);
        Optional<Integer> sum3 = numbers2.stream().reduce((a, b) -> (a + b));
        //  System.out.println(sum3);
    }
}
