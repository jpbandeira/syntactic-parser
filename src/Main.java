import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        /*Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();*/

        List<String> inputs = new ArrayList<>();
        inputs.add("A->BC");
        inputs.add("B->d");
        inputs.add("C->c");

        String input = "A->BC;B->d;C->c;";

        List<Grammar> grammars = parser.preparGrammar(input);

        parser.showValuesGrammar(grammars);
        
        for(Grammar value:grammars){
            String teste =parser.first(value.getVariable());
            System.out.println("Primeiro de " + value.getVariable() + " = " + teste);
        }
    }
}
