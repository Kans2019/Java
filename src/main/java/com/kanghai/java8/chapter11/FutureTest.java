package com.kanghai.java8.chapter11;

import java.util.concurrent.Future;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/14 15:26
 * @description
 */

public class FutureTest {
    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");

        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start)) / 1000000;
        System.out.println("Invocation returned after " + invocationTime + "msecs");

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
