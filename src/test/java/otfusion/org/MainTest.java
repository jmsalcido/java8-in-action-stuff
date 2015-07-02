package otfusion.org;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testJava8LambdasUsages() throws Exception {
        List<String> list = Arrays.asList("A", "A");
        list.forEach(s -> assertTrue(s.equals("A")));

        List<Character> lowercaseChars = Arrays.asList('a', 'b', 'c', 'd', 'e');
        List<Character> uppercaseChars = new ArrayList<>();
        lowercaseChars.forEach(c -> uppercaseChars.add(Character.toUpperCase(c)));
        assertTrue(uppercaseChars.get(0).equals('A'));
        assertTrue(uppercaseChars.get(1).equals('B'));
        assertTrue(uppercaseChars.get(2).equals('C'));
        assertTrue(uppercaseChars.get(3).equals('D'));
        assertTrue(uppercaseChars.get(4).equals('E'));
    }

    @Test
    public void testJava8LambdaWithStreams() throws Exception {
        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = someNumbers.stream().reduce(0, (initial, addition) -> initial + addition);
        assertEquals(Integer.valueOf(1+2+3+4+5+6+7+8+9+10), sum);

        someNumbers = Arrays.asList(1,2,3,4,5);
        int product = someNumbers.stream().reduce(1, (firstNumber, secondNumber) -> firstNumber * secondNumber);
        assertEquals(2 * 3 * 4 * 5, product);
    }

}