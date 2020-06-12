
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        char[] firsts = new char[0];
        char[] folow;

        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Digite a gramatica: ");
        input = scanner.nextLine();

        List<Grammar> grammar = parser.preparGrammar(input);

        System.out.println("\n**** Gramática Gerada ****\n");

        parser.showValuesGrammar(grammar);

        System.out.println("\n**** Tabela Preditiva ****\n");

        for(Grammar value:grammar) {
            parser.generatePredictiveTable(value);
        }

        parser.showPredictiveTable();

        String variable;

        System.out.println("Digite a variavel para testar FIRST e FOLOW: ");
        variable = scanner.nextLine();

        parser.firsts = new StringBuffer();

        firsts = parser.first(variable);
        System.out.println("\nPrimeiro de " + variable + " = " + Arrays.toString(firsts));

        folow = parser.folow(variable);
        System.out.println("\nFolow de " + variable + " = " + Arrays.toString(folow));
    }

}
