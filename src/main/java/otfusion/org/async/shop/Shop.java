package otfusion.org.async.shop;

import otfusion.org.async.AsyncUtils;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private final String name;

    public Shop(String name) {
        this.name = name;
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = getPrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    private double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        AsyncUtils.delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

}
