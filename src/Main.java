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

        parser.preparGrammar(inputs);
        String teste =parser.first("C");
        System.out.println(teste);
    }
}
