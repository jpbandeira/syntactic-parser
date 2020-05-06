import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        /*Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();*/

        List<String> inputs = new ArrayList<>();
        inputs.add("A->a");
        inputs.add("B->b");
        inputs.add("C->c");

        parser.first(inputs);
    }
}
