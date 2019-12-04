package com.kanghai.java8.chapter7.parllerstream;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static com.kanghai.java8.chapter7.parllerstream.ParallelStreams.measureSumPerf;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/5 0:26
 * @description
 */

public class SumTest {


    public static void main(String[] args) {
//        System.out.println("Sequential sum done in:" +
//        measureSumPerf(ParallelStreams::sequentialSum, 10000000) +"msecs" );
//
//
//        System.out.println("ParallelSum sum done in:" +
//                measureSumPerf(ParallelStreams::parallelSum, 10000000) +"msecs" );
//
//        System.out.println("iterativeSum sum done in:" +
//                measureSumPerf(ParallelStreams::iterativeSum, 10000000) +"msecs" );

        System.out.println("rangedSum sum done in:" +
                measureSumPerf(ParallelStreams::rangedSum, 10000000) +"msecs" );

        System.out.println("parallelRangedSum sum done in:" +
                measureSumPerf(ParallelStreams::parallelRangedSum, 10000000) +"msecs" );



    }
}
class ParallelStreams{
    public static long sequentialSum(long n){
        return Stream.iterate(1L, i -> i+1).limit(n)
                .reduce(0L,Long::sum);
    }

    public static long parallelSum(long n){
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n){
        long result = 0;
        for (long i = 1L; i <=n; i++){
            result += i;
        }
        return result;
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n){
        long fastest = Long.MAX_VALUE;
        for(int i = 0; i < 10; i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1000000;
            if(duration < fastest)
                fastest = duration;
        }

        return fastest;
    }


    public static long rangedSum(long n){
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n){
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
