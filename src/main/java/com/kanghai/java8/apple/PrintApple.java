package com.kanghai.java8.apple;

import com.kanghai.java8.apple.PrettyPrintApple.PrettyPrintApple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/17 14:41
 * @description
 */

public class PrintApple {
    public static void main(String[] args) {
        Apple apple1 = new Apple(150, "red");
        Apple apple2= new Apple(120, "green");
        Apple apple3 = new Apple(130, "yellow");
        Apple apple4 = new Apple(190, "yellow");
        List<Apple> list = new ArrayList<>();
        list.add(apple1);
        list.add(apple2);
        list.add(apple3);
        list.add(apple4);
        //toAppleString(list,new PrettyPringAppleHeavy());

        Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getHeavy());
        list.sort(c);
        System.out.println(list.toString());
    }

    public static void toAppleString(List<Apple> inventy, PrettyPrintApple p){
        for (Apple apple : inventy){
            String output = p.toString(apple);
            System.out.println(output);
        }
    }
}
