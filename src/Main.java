import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        /*Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();*/

        List<String> inputs = new ArrayList<>();
        inputs.add("A->BC");   // A -> BC ; A -> b | & C : A -> b | C ; A -> b | c
        inputs.add("B->bB|&");
        inputs.add("C->c");

        String input = "A";

        parser.preparGrammar(inputs);
        String teste = parser.first(input);
        System.out.println("Primeiro de " + input + " = [" + teste + "] ");
    }
}
