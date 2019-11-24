package com.kanghai.java8.stream;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/23 19:16
 * @description
 */

public class TranstionUse {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 300),
                new Transaction(mario, 2012, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(alan, 2012,700)
        );

        List<Trader> traders = Lists.newArrayList();
        traders.add(raoul);
        traders.add(mario);
        traders.add(alan);
        traders.add(brian);

//        Map<Currency, List<Transaction>> transactionByCurrencies =
//                transactions.stream().collect(groupingBy(Transaction::getCurrency));

    }

    public static void test6(List<Trader> traders, List<Transaction> transactions){
        List<String> names =   traders.stream()
                .map(a -> a.getName())
                .sorted((a, b) -> a.compareTo(b))
                .collect(Collectors.toList());
        names.forEach(System.out::println);
        System.out.println();

        boolean sim =  traders.stream()
                .anyMatch( a -> "Milan".equals(a.getCity()));
        System.out.println("sim:" + sim);

//        traders.stream()
//                .map(a -> "Cambridge".equals(a.getCity()))
//                .forEach(
//                        f-> {transactions.
//                                stream()
//                                .map(b -> b.getValue()).forEach(System.out::println);
//                        });

        transactions.stream()
                .filter(b ->
                        b.getTrader().getCity().equals("Cambridge"))
                .map(a -> a.getValue())
                .collect(Collectors.toList())
                .forEach(System.out::println);


        Optional<Integer> optional  = transactions.stream()
                .map(b -> b.getValue())
                .reduce(Integer::max);
        System.out.println(optional);

        Optional<Integer> optional2  = transactions.stream()
                .map(b -> b.getValue())
                .reduce(Integer::min);

        System.out.println(optional2);


    }

    public static void test(List<Transaction> transactions, List<Trader> traders){
        List<Transaction> list =  transactions.stream()
                .filter(a -> a.getYear() == 2011 )
                .sorted(comparing(t -> t.getValue()))
                // .sorted(comparing(Transactions::getValue))Va
                .collect(Collectors.toList());
        for (Transaction tr: list){
            //        System.out.println(tr.toString());
        }


        //不同的城市
        List<String> cityName =  traders.stream()
                .map(trader -> trader.getCity())
                .distinct()
                .collect(Collectors.toList());
        // cityName.forEach(System.out::println);

        List<Trader> list1 =  traders.stream()
                .filter(a -> "Cambridge".equals(a.getCity()))
                .collect(Collectors.toList());
        list.forEach(System.out::println);

    }
}
