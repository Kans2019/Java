package com.kanghai.java8.dish;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/19 0:06
 * @description
 */

public class LowCaloric {
    public static void main(String[] args) {
        List<Dish> menu = Lists.newArrayList();
        menu.add(new Dish("水煮如片", 123));
        menu.add(new Dish("小炒肉", 240));
        menu.add(new Dish("麻婆豆腐", 120));
        //test1(menu);
        //test2();

        List<String> lowCaloricDishesName = menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing((Dish d) -> d.getCalories()))
                .map((Dish d) -> d.getName())
                .collect(toList());
        System.out.println(lowCaloricDishesName.toString());
    }

    public static void test1(List<Dish> menu){
        List<Dish> lowCaloricDishes = Lists.newArrayList();
        for (Dish d : menu){
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }
    }

    public static void test2(){
        List<Dish> lowCaloricDishes = Lists.newArrayList();
        lowCaloricDishes.add(new Dish("水煮如片", 123));
        lowCaloricDishes.add(new Dish("小炒肉", 240));
        lowCaloricDishes.add(new Dish("麻婆豆腐", 120));

        Collections.sort(lowCaloricDishes, (Dish d1, Dish d2) -> Integer.compare(d1.getCalories(), d2.getCalories()));

        Comparator<Dish> s = Comparator.comparing((Dish d) -> d.getCalories() );
       //lowCaloricDishes.sort(s);

       //lowCaloricDishes.sort(Comparator.comparing((Dish d) -> d.getCalories()));

        lowCaloricDishes = Mysort(lowCaloricDishes,new DishByCaloric());

        List<String> lowCaloricDishesName = Lists.newArrayList();
        for (Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
    }

    public static List<Dish> Mysort(List<Dish> lowCaloricDish, DishByCaloric f){
        List<Dish> lowCaloricDishes = Lists.newArrayList();
        for (Dish d: lowCaloricDish){
            if(f.apply(d)){
                 lowCaloricDish.add(d);
            }
        }

        return lowCaloricDishes;
    }

}


class DishByCaloric implements Function<Dish, Boolean> {

    @Override
    public Boolean apply(Dish dish) {
        return dish.getCalories() < 150;
    }
}