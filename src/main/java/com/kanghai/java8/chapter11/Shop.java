package com.kanghai.java8.chapter11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/12/14 15:41
 * @description
 */

public class Shop {

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    private double getPrice(String product){
        return calculatePrice(product);
    }

    private double calculatePrice(String product){
        delay();
        Random random = new Random(1);
        return random.nextDouble()* product.charAt(0) + product.charAt(1);
    }

    public static void delay(){
        try{
            Thread.sleep(100L);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {

                double price = calculatePrice(product);
                futurePrice.complete(price);
            }catch (Exception ex){
                futurePrice.completeExceptionally(ex);
            }
        }).start();

        return futurePrice;
    }
}
