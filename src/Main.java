
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        char[] derivacoes;
        char[] folow;

        String input = "S -> ABCDE;" +
                "A -> a | 0;" +
                "B -> b | 0;" +
                "C -> c;" +
                "D -> d | 0;" +
                "E -> e | 0;";

        String input2 = "S -> AB;" +
                "A -> a | 0;" +
                "B -> b | c;";

        String input3 = "S -> A | B;" +
                "A -> a;" +
                "B -> b;";

        String input4 = "S -> Bb | Cd;" +
                "B -> aB|0;" +
                "C -> cC|0;";

        List<Grammar> grammar = parser.preparGrammar(input4);
        parser.showValuesGrammar(grammar);

        String variable = "C";

        derivacoes = parser.first(variable);
        System.out.println("\nPrimeiro de " + variable + " = " + Arrays.toString(derivacoes));

        folow = parser.folow(variable);
        System.out.println("\nFolow de " + variable + " = " + Arrays.toString(folow));
    }
}
