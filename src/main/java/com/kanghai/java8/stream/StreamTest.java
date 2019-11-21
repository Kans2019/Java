package com.kanghai.java8.stream;

import com.google.common.collect.Lists;
import com.kanghai.java8.dish.Dish;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/22 0:17
 * @description
 */

public class StreamTest {
    public static void main(String[] args) {
        List<Dish> menu = Lists.newArrayList();
        menu.add(new Dish("水煮如片", 123));
        menu.add(new Dish("小炒肉", 240));
        menu.add(new Dish("麻婆豆腐", 120));
        menu.add(new Dish("辣子鸡", 540));
        menu.add(new Dish("椒盐蘑菇", 620));

        test4(menu);
    }

    public static void test(){
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }

    public static void test2(List<Dish> menu){
        List<String> names = Lists.newArrayList();
        Iterator<Dish> iterator = menu.iterator();
        while(iterator.hasNext()){
            Dish d = iterator.next();
            names.add(d.getName());
        }
    }

    public static void test3(List<Dish> menu){
        List<String> names = menu.stream().map(Dish::getName).collect(Collectors.toList());
    }

    public static void test4(List<Dish> menu){
        List<String> names =
                menu.stream()
                .filter(d -> {
                    System.out.println("filtering" + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping" + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);
    }


}
