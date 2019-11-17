package com.kanghai.java8.apple;

import com.kanghai.java8.apple.PrettyPrintApple.PrettyPringAppleHeavy;
import com.kanghai.java8.apple.PrettyPrintApple.PrettyPrintApple;

import java.util.ArrayList;
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
        List<Apple> list = new ArrayList<>();
        list.add(apple1);
        list.add(apple2);
        list.add(apple3);
        toAppleString(list,new PrettyPringAppleHeavy());
    }

    public static void toAppleString(List<Apple> inventy, PrettyPrintApple p){
        for (Apple apple : inventy){
            String output = p.toString(apple);
            System.out.println(output);
        }
    }
}
