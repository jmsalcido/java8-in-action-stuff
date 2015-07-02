package otfusion.org;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodilityTapeEquilibriumTest {

    @Test
    public void testSolutionWithDefaultTestCase() throws Exception {
        CodilityTapeEquilibrium test = new CodilityTapeEquilibrium();
        assertEquals(1, test.solution(new int[] {3,1,2,4,3}));
    }

    @Test
    public void testSolutionWith2ElementsArray() throws Exception {
        CodilityTapeEquilibrium test = new CodilityTapeEquilibrium();
        // |1-2001| == 2000
        assertEquals(2000, test.solution(new int[] {1, 2001}));
        // |0-2000| == 2000
        assertEquals(2000, test.solution(new int[] {0, 2000}));
    }
}