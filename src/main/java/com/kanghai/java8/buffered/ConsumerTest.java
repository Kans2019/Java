package com.kanghai.java8.buffered;

import com.google.common.collect.Lists;
import com.kanghai.java8.apple.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/17 18:31
 * @description
 */

public class ConsumerTest {
    public static void main(String[] args) {
       List<String> strList = new ArrayList<>();
       strList.add("a");
       strList.add("b");
     //   forEach(strList,
     //           (String s) -> System.out.println(s));
        Apple apple1 = new Apple(12,"red");
        Apple apple2 = new Apple(15, "whilte");
        List<Apple> appleList = Lists.newArrayList();
        appleList.add(apple1);
        appleList.add(apple2);
        List<Integer> l = map(appleList, (Apple apple) -> apple.getHeavy());
        System.out.println(l.toString());

        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        evenNumbers.test(1000);

        Predicate<Integer> even = (Integer i) -> i % 2 ==0;
        even.test(100);
     }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T element:list){
          c.accept(element);
        }

    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f){
        List<R> result = Lists.newArrayList();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }
}
