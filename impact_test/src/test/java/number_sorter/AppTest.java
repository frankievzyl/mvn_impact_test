package number_sorter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Collection;
/**
 * Unit test for simple App.
 */
class AppTest {
    
    @Test
    void testGivenSample() {

        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String actualOutput = "";
        String expectedOutput = "1, 3, 6-8, 12-15, 21-24, 31";
        NumberRangeProgram nrp = new NumberRangeProgram();
        Collection<Integer> numList = nrp.collect(input);
        actualOutput = nrp.summarizeCollection(numList);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testWithUnorderedIntegers() {

        String input = "5,8,33,75,17,19,25,6,18,12";
        String actualOutput = "";
        String expectedOutput = "5, 6, 8, 12, 17-19, 25, 33, 75";
        NumberRangeProgram nrp = new NumberRangeProgram();
        Collection<Integer> numList = nrp.collect(input);
        actualOutput = nrp.summarizeCollection(numList);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testWithAddedFloats() {

        String input = "12,5,7.2,13,8,11.4,9,17,20,1";
        String actualOutput = "";
        String expectedOutput = "1, 5, 7-9, 11-13, 17, 20";
        NumberRangeProgram nrp = new NumberRangeProgram();
        Collection<Integer> numList = nrp.collect(input);
        actualOutput = nrp.summarizeCollection(numList);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testWithAddedStrings() {

        String input = "18,8,3,7,1o,22,20,19,S";
        String actualOutput = "";
        String expectedOutput = "3, 7, 8, 18-20, 22";
        NumberRangeProgram nrp = new NumberRangeProgram();
        Collection<Integer> numList = nrp.collect(input);
        actualOutput = nrp.summarizeCollection(numList);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testIncrementsOfOne() {

        String input = "2,4,2,9,5,3,6,8,7,11,14";
        String actualOutput = "";
        String expectedOutput = "2-9, 11, 14";
        NumberRangeProgram nrp = new NumberRangeProgram();
        Collection<Integer> numList = nrp.collect(input);
        actualOutput = nrp.summarizeCollection(numList);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testWithNegatives() {

        String input = "8,4,-6,3,0,-5,-3,1,5";
        String actualOutput = "";
        String expectedOutput = "-6, -5, -3, 0, 1, 3-5, 8";
        NumberRangeProgram nrp = new NumberRangeProgram();
        Collection<Integer> numList = nrp.collect(input);
        actualOutput = nrp.summarizeCollection(numList);

        assertEquals(expectedOutput, actualOutput);
    }
}
