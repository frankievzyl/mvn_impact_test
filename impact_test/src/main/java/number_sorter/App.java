package number_sorter;

import java.io.Console;
import java.util.Collection;

public final class App {
    private App() {
    }

    /**
     * Asks the user for a set of numbers and displays a sorted, summarized list.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        NumberRangeProgram nrp = new NumberRangeProgram();
        System.out.println("Enter a list of integers separated by commas:\n");
        Console console = System.console();
        String userInput = console.readLine();
        Collection<Integer> intList = nrp.collect(userInput);
        
        if (intList != null) {
            System.out.println(nrp.summarizeCollection(intList));
        }
    }
}
