package otfusion.org.async;

public class AsyncUtils {

    public static  void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
