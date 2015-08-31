package otfusion.org.async;

import org.junit.Test;
import otfusion.org.async.shop.Shop;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AsyncIntegrationTest {

//    @Test
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

    @Test
    public void findPrices() throws Exception {
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    @Test
    public void findPricesParallel() throws Exception {
        long start = System.nanoTime();
        System.out.println(findPricesParallel("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    public List<Shop> createShops() {
        return Arrays.asList(
                new Shop("Test"),
                new Shop("Another"),
                new Shop("Buen Producto"),
                new Shop("Another Buen Producto"),
                new Shop("KJust Rename"),
                new Shop("KJlol"),
                new Shop("TestingTest"),
                new Shop("SomeProduct"),
                new Shop("Big Product"),
                new Shop("Le Prod"),
                new Shop("La Prod"),
                new Shop("Viva Producto"),
                new Shop("Espangol"),
                new Shop("Smeagol"),
                new Shop("Olorin"),
                new Shop("Ortanc"),
                new Shop("Minas Tirith"),
                new Shop("Viva Pinhata"),
                new Shop("Grande"),
                new Shop("Pequenho"),
                new Shop("Smallk"),
                new Shop("Bigk"),
                new Shop("Kahuna"),
                new Shop("Rinho"),
                new Shop("Como chinga"),
                new Shop("Buena Tiendita")
        );
    }

    public List<String> findPricesParallel(String product) {
        return createShops().parallelStream().map(shop -> String.format("%s price is %.2f%n", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    public List<String> findPrices(String product) {
        return createShops().stream().map(shop -> String.format("%s price is %.2f%n", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    private void countWhileProcessing() {
        System.out.println("We will print numbers from 1 to MAX_INTEGER while we calculate prices... and finish the count after getting the price.");
        Thread thread = new Thread(() -> IntStream.range(0, 10_000).forEach(value -> System.out.print(value + ", ")));
        thread.setDaemon(true);
        thread.start();
    }

}