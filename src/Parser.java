
import com.sun.pisces.GradientColorMap;

import java.util.ArrayList;
import java.util.List;

public class Parser implements ParserInterface {

    List<Grammar> finalValuesGrammars = new ArrayList<>();
    String primeiroValorVariavel = "";

    @Override
    public String first(String grammar) {
        StringBuffer firsts = new StringBuffer();

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
        //this.showValuesGrammar(finalValuesGrammars);
        return primeiroValorVariavel;
    }

    @Override
    public void folow(String grammar) {
        //This method is not implemented yet
    }

    @Override
    public List<Grammar> preparGrammar(String grammars){
        List<Grammar> finalValuesGrammars = new ArrayList<>();

        String[] splitedFromSemicolon = grammars.split(";");

        for(String value:splitedFromSemicolon) {
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

    public void showValuesGrammar(List<Grammar> grammars){
        for(Grammar value:grammars){
            if(!value.equals("")){
                System.out.println("Variavel |" + " \tDerivações" + "\n" + value.getVariable() + "\t\t |\t\t" + value.getDerivations());
                System.out.println("---------|-------------------");
            }
        }
    }
    
}
