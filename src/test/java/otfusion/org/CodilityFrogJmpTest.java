package otfusion.org;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodilityFrogJmpTest {

    @Test
    public void testSolutionWithNoJumps() throws Exception {
        CodilityFrogJmp test = new CodilityFrogJmp();
        assertEquals(0, test.solution(100, 10, 1));
    }
}