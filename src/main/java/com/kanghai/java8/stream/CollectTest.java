package com.kanghai.java8.stream;

import com.google.common.collect.Lists;
import com.kanghai.java8.dish.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/27 0:42
 * @description
 */

public class CollectTest {
    public static void main(String[] args) {
        List<Dish> menu = Lists.newArrayList();
        menu.add(new Dish("水煮如片", 123,Dish.Type.FISH, Dish.CaloricLevel.DIET));
        menu.add(new Dish("小炒肉", 240,Dish.Type.MEAT,Dish.CaloricLevel.FAT));
        menu.add(new Dish("麻婆豆腐", 120,Dish.Type.MEAT, Dish.CaloricLevel.NORMAL));

      //  test(menu);

        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
      //  System.out.println(typesCount.toString());

        Map<Dish.Type, Dish> mostCaloricByType = menu.stream().collect(
                groupingBy(Dish::getType, collectingAndThen(
                maxBy(Comparator.comparingInt(Dish::getCalories)),Optional::get)));

        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(groupingBy(Dish::getType, mapping(
                        dish -> {if(dish.getCalories() <= 120) return Dish.CaloricLevel.DIET;
                        else if(dish.getCalories() <= 240) return Dish.CaloricLevel.NORMAL;
                        else return Dish.CaloricLevel.FAT;
                        }, toCollection(HashSet::new)
                        )));

        System.out.println(caloricLevelsByType.toString());

    }

    public static void test(List<Dish> menu){
        long howManyDishes = menu.stream().collect(Collectors.counting());
        System.out.println(howManyDishes);

        long howmany  = menu.stream().count();
        System.out.println(howmany);


        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        //String shortMenu = menu.stream().collect(joining());
        System.out.println(shortMenu);

        Optional<Dish> mostCalorieDish = menu.stream().collect(
                reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)
        );
        System.out.println(mostCalorieDish.get().getName());

        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l;
                },
                (List<Integer> l1, List<Integer> l2) ->{
                    l1.addAll(l2);
                    return l1;
                }
        );

        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));

        Map<Dish.Type, Map<Dish.CaloricLevel,List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish-> {
                                    if(dish.getCalories() <=400)
                                        return Dish.CaloricLevel.DIET;
                                    else if(dish.getCalories() <=700)
                                        return Dish.CaloricLevel.NORMAL;
                                    else
                                        return Dish.CaloricLevel.FAT;
                                }))
                );


    }

    public static void test2(List<Dish> menu){
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));

        int totalCalories = menu.stream().collect(summingInt(a -> a.getCalories()));

        System.out.println(totalCalories);

        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
    }
}
