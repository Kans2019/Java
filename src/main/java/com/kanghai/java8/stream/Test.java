package com.kanghai.java8.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/4 0:43
 * @description
 */

public class Test {
    public static void main(String[] args) {
        long fastest = Long.MAX_VALUE;
        for(int i = 0; i < 10; i++){
            long start = System.nanoTime();
            partitionPrimes(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if(duration < fastest)
                fastest = duration;
        }
        System.out.println("Fastest execution done in" + fastest + "msecs");
    }

    public static void partitionPrimes(int n){
        Map<Boolean, List<Integer>> partitionPrimes = IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
        System.out.println(partitionPrimes);
    }


    public static boolean isPrime(int candidate){
//        return IntStream.range(2, candidate)
//                .noneMatch(i -> candidate % i == 0);
        int candidateRoot = (int)Math.sqrt((double)candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate%i == 0);
    }
}
