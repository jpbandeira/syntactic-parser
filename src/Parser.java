import java.util.ArrayList;
import java.util.List;

public class Parser implements ParserInterface {

    List<Grammar> finalValuesGrammars = new ArrayList<>();
    String primeiroValorVariavel = "";

    // A -> BC ; A -> b | & C : A -> b | C ; A -> b | c

    @Override
    public String first(String grammar) {
        StringBuffer primeiro = new StringBuffer();

        char[] derivacao = new char[0];
        for(Grammar value: this.finalValuesGrammars) {
            if (value.getVariable().equals(grammar)) {
                derivacao = value.getDerivations().toCharArray();

                if (String.valueOf(derivacao[0]).toUpperCase().equals(String.valueOf(derivacao[0]))) {
                    String primeiroDerivacao = String.valueOf(derivacao[0]);
                    return this.first(primeiroDerivacao);
                }else{
                    primeiroValorVariavel = String.valueOf(derivacao[0]);
                }

            }
        }

        return primeiroValorVariavel;
    }

    @Override
    public void folow(String grammar) {
        //This method is not implemented yet
    }

    @Override
    public List<Grammar> preparGrammar(List<String> grammars){
        List<Grammar> finalValuesGrammars = new ArrayList<>();

        for(String value:grammars) {
            Grammar grammar = new Grammar();
            StringBuffer toConcat = new StringBuffer();

            String noSpaceArray = value.replaceAll("\\s*", "");
            String[] splited = noSpaceArray.split("[->]");

            grammar.setVariable(splited[0]);

            for (int i = 1; i < splited.length; i++) {
                if (!splited[i].equals("")) toConcat.append(splited[i]);
            }

            grammar.setDerivations(String.valueOf(toConcat));
            finalValuesGrammars.add(grammar);

        }

        return this.finalValuesGrammars = finalValuesGrammars;
    }

    private void showValuesGrammar(List<Grammar> grammars){
        for(Grammar value:grammars){
            if(!value.equals("")){
                System.out.println("Variavel |" + " \tDerivações" + "\n" + value.getVariable() + "\t\t |\t\t" + value.getDerivations());
                System.out.println("---------|-------------------");
            }
        }
    }
    
}
