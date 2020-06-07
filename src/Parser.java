
import java.util.ArrayList;
import java.util.List;

public class Parser implements ParserInterface {

    List<Grammar> finalValuesGrammars = new ArrayList<>();
    String firstValueDerivation = "";
    char[] firstValueDerivationCharArry = new char[0];

    @Override
    public char[] first(String variable) {
        StringBuffer firsts = new StringBuffer();
        char[] derivacao = new char[0];
        int count = 0;
        Grammar grammar = new Grammar();
        char[] derivationToCharArray = new char[0];

        for(int i = 0; i < this.finalValuesGrammars.size(); i++) {
            grammar = this.finalValuesGrammars.get(i);
            if (variable.equals(grammar.getVariable())) {
                String first = String.valueOf(grammar.getDerivations().charAt(0));
                if (isUpperCase(grammar.getDerivations()) && first.matches("[A-Z]")) {
                    derivationToCharArray = grammar.getDerivations().toCharArray();
                    String firstValue = String.valueOf(derivationToCharArray[0]);
                    return this.first(firstValue);
                } else {
                    if(containBar(grammar.getDerivations())){
                        String finalValue = this.getfirstWithBar(finalValuesGrammars ,grammar);
                        firstValueDerivationCharArry = finalValue.toCharArray();
                    }else{
                        derivationToCharArray = grammar.getDerivations().toCharArray();
                        String firstValue = String.valueOf(derivationToCharArray[0]);
                        firstValueDerivationCharArry = firstValue.toCharArray();
                    }
                }
            }
        }
        return firstValueDerivationCharArry;
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

            if(toConcat.toString().contains("0")){
                grammar.setContainsEpsilon(true);
            }

            grammar.setDerivations(toConcat.toString());
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

    private boolean isUpperCase(String derivation){
        char[] derivations = new char[0];
        derivations = derivation.toCharArray();

        String first = String.valueOf(derivations[0]);
        if(first.toUpperCase().equals(first)){
            return true;
        }else{
            return false;
        }
    }

    private boolean containBar(String derivation){
        return derivation.contains("|") ? true : false;
    }

    private String getfirstWithBar(List<Grammar> finalValuesGrammars ,Grammar grammar){
        char[] charArryfirstsProxValue = new char[0];
        char[] charArryFirstsTopValue;

        String firstValue = "";
        String finalValue = "";
        char[] derivationToCharArray = grammar.getDerivations().toCharArray();
        Grammar valuetopGrammar = finalValuesGrammars.get(0);

        int positionBar = grammar.getDerivations().indexOf("|");
        String valueAfterBar = String.valueOf(derivationToCharArray[positionBar + 1]);
        StringBuilder firstValueToProxGrammar = new StringBuilder();

        char[] derivationValue = valuetopGrammar.getDerivations().toCharArray();
        int positionFirstValue = 0;

        String valueAfterFirstValueDerivation = String.valueOf(derivationValue[positionFirstValue + 1]);
        String variableTopValue = String.valueOf(derivationValue[0]);

        Grammar grammarTopValue = this.findGrammar(variableTopValue);

        if(valueAfterBar.equals("0") && grammar.isAnalyzeEpsilonOrNot() == true){
            for(int i = 0; i < finalValuesGrammars.size(); i++){
                if(finalValuesGrammars.get(i).getVariable().equals(valueAfterFirstValueDerivation)){
                    grammar.setAnalyzeEpsilonOrNot(false);
                    charArryfirstsProxValue = this.first(valueAfterFirstValueDerivation);
                }
            }

            for(char value:charArryfirstsProxValue){
                firstValueToProxGrammar.append(value);
            }

            charArryFirstsTopValue = grammarTopValue.getDerivations().toCharArray();
            String FirstsTopValue = String.valueOf(charArryFirstsTopValue[0]);

            finalValue = FirstsTopValue + firstValueToProxGrammar.toString();

        }else {
            charArryFirstsTopValue = this.first(String.valueOf(derivationToCharArray[0]));
            finalValue = charArryFirstsTopValue.toString() + valueAfterBar;
        }

        return finalValue;
    }

    private Grammar findGrammar(String variable){
        for(Grammar value:finalValuesGrammars){
            if (variable.equals(value.getVariable())){
                return value;
            }
        }

        return null;
    }
}
