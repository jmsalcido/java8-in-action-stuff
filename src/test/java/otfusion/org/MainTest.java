package otfusion.org;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testJava8LambdasUsages() throws Exception {
        List<String> list = Arrays.asList("A", "A");
        list.forEach(s -> assertTrue(s.equals("A")));
    }

}