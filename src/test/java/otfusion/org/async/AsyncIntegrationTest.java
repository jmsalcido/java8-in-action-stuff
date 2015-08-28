package otfusion.org.async;

import org.junit.Test;
import otfusion.org.async.shop.Shop;

import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class AsyncIntegrationTest {

    @Test
    public void test() throws Exception {
        Shop shop = new Shop("Best Shop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime()) - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        countWhileProcessing();
        try {
            double price = futurePrice.get();
            System.out.println(String.format("Price is %.2f%n", price));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrieveTime = ((System.nanoTime()) - start) / 1_000_000;
        System.out.println("Price returned after " + retrieveTime + " msecs");
    }

    private void countWhileProcessing() {
        System.out.println("We will print numbers from 1 to MAX_INTEGER while we calculate prices... and finish the count after getting the price.");
        Thread thread = new Thread(() -> IntStream.range(0, Integer.MAX_VALUE).forEach(value -> System.out.print(value + ", ")));
        thread.setDaemon(true);
        thread.start();
    }

}