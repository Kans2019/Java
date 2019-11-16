package com.kanghai.java8.apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/17 0:08
 * @description
 */

public class FilterApple {
    public static void main(String[] args) {
        Apple apple1 = new Apple(150, "red");
        Apple apple2= new Apple(120, "green");
        Apple apple3 = new Apple(130, "yellow");
        List<Apple> list = new ArrayList<>();
        list.add(apple1);
        list.add(apple2);
        list.add(apple3);
        //将方法作为值传递
        //list = filterApples(list, Apple::isGreenApple);
//        list = filterApples(list, (Apple a) -> "green".equals(a.getColor()));
//        list = filterApples(list, (Apple a) -> (a.getHeavy() > 130));

        //顺序处理
        List<Apple> heavyApples = list.stream().filter((Apple a) -> "green".equals(a.getColor()))
                .collect(Collectors.toList());
        //并行处理
        List<Apple> heavyApples2 = list.parallelStream().filter((Apple a) -> "green".equals(a.getColor()))
                .collect(Collectors.toList());
        for (Apple apple:heavyApples2){
            System.out.println(apple.toString());
        }
    }


    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }

        return result;
    }



}
