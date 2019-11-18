package com.kanghai.java8.apple;

import com.kanghai.java8.apple.ApplePredicate.AppleGreenColorPredicate;
import com.kanghai.java8.apple.ApplePredicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/17 14:20
 * @description
 */

public class FilterApplePredicate {
    public static void main(String[] args) {
        Apple apple1 = new Apple(150, "red");
        Apple apple2= new Apple(120, "green");
        Apple apple3 = new Apple(130, "yellow");
        List<Apple> list = new ArrayList<>();
        list.add(apple1);
        list.add(apple2);
        list.add(apple3);
        list = filterApples(list, new AppleGreenColorPredicate());
       for (Apple apple:list){
           System.out.println(apple.toString());
       }

    }

    public static  List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
