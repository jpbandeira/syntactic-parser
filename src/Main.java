import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    char[] teste = new char[0];

    public static void main(String[] args) {
        Parser parser = new Parser();

        char[] teste = new char[0];
        /*Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();*/

        List<String> inputs = new ArrayList<>();
        inputs.add("A->BC");
        inputs.add("B->d");
        inputs.add("C->c");

        String input =  "A->BC;" +
                        "B->dB|0;" +
                        "C->0;";
        //String input = "A->BC;B->dB|0;C->c|0;";

        List<Grammar> grammars = parser.preparGrammar(input);

        parser.showValuesGrammar(grammars);
        
        for(Grammar value:grammars){

            teste =parser.first(value.getVariable());
            System.out.println("Primeiro de " + value.getVariable() + " = " + Arrays.toString(teste)
            + " Contem epsilon = " + value.isContainsEpsilon());
        }
    }

    @Override
    public String toString() {
        return "Main{" +
                "teste=" + Arrays.toString(teste) +
                '}';
    }
}
