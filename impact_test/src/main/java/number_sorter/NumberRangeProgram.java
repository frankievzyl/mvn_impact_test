package number_sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

public class NumberRangeProgram implements NumberRangeSummarizer {

    /**
     * Splits a string as denoted with commas. Determines whether resulting array values
     * are integers, floats or strings. Adds integer and rounded float values to an array list,
     * warning the user of accidental string usages.
     * @param input String containing possible integer values separated by commas.
     * @return An ArrayList of the detected integer and rounded float values.
     */
    @Override
    public Collection<Integer> collect(String input) {

        if (input.isEmpty()) return null;

        String rawNumbers[] = input.split(",");
        ArrayList<Integer> properInts = new ArrayList<>();
        
        for (String sNum : rawNumbers) {
            
            try {

                float f = Float.parseFloat(sNum.trim());
                int properInt = Math.round(f);

                if (!properInts.contains(properInt)) properInts.add(properInt);

            } catch (NumberFormatException noFloat) {
                System.out.println(sNum + " is not a recognized number.");  
            }
        }

        return properInts;
    }

    /**
     * 
     * @param input A collection of integers.
     * @return A string containing a sorted set of numbers and number ranges.
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {

        String summary = "";
        Adder myAdder = new Adder(input.size());
        Integer[] numArray;
        int current = 1, start = 0, end = 0;
        boolean loop = true;

        input.forEach(myAdder);
        numArray = myAdder.getIntArray();
        Arrays.sort(numArray);
        
        while (loop) {

            if (current == numArray.length) {

                current = 0;
                loop = false;
            } 

            if (Math.abs(numArray[current] - numArray[end]) != 1) {

                if (summary.length() != 0) summary += ", ";

                if (end - start > 1) {

                    summary += numArray[start] + "-" + numArray[end];
                    
                       
                } else if (start == end) {

                    summary += numArray[start];

                } else {

                    summary += numArray[start] + ", " + numArray[end];
                }
                start = current;  
            }
            end = current++;
        }      
        return summary;
    }

    /**
     * Class that creates a new integer array from an integer collection
     */
    class Adder implements Consumer<Integer> {

        private int current = 0;
        private Integer[] numArray;

        public Adder(int arrSize) {
            numArray = new Integer[arrSize];
        }

        public void accept(Integer t) {
            numArray[current++] = t;        
        }

        public Integer[] getIntArray() {
            return numArray;
        }
    }
}