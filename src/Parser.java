
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser{

    List<Grammar> finalValuesGrammars = new ArrayList<>();
    List<Grammar> grammarsAnalised = new ArrayList<>();
    StringBuffer firsts = new StringBuffer();
    char[] firstToProxVariable;

    char[] firstValueDerivationCharArry = new char[0];
    private static int positionCharactere = 0;

    public char[] first(String variable) {
        Grammar grammar = new Grammar();
        char[] derivacao = new char[0];
        char[] derivationToCharArray = new char[0];
        int count = 0;

        grammar = this.findGrammar(variable);
        grammarsAnalised.add(grammar);

        if(!this.containsEpsilon(grammar.getDerivations())){
            String first = "";

            if(this.containBar(grammar.getDerivations())){
                first = this.getFirstWithBar(grammar);
            }else {
                first = this.getFirstVariable(grammar.getDerivations());
            }

            Pattern pattern = Pattern.compile("[A-Z]");
            Matcher matcher = pattern.matcher(first);

            if(matcher.find()){
                if (this.isUpperCase(matcher.group())){
                    char[] c = this.first(matcher.group());
                    //String replaced = this.replaced(c);
                    //firsts.append(replaced);
                    return firsts.toString().toCharArray();
                }
            }

            if(this.isUpperCase(first)) this.first(first);
            else return firsts.append(first).toString().toCharArray();
        }else{
            Grammar value = this.findGrammarAnalised(grammar);

            char[] firstToVariable = this.getFirstVariable(grammar.getDerivations()).toCharArray();
            String replaced =  this.replaced(firstToVariable);

            if(value != null) {
                firsts.append(replaced);
                int positionVariable = value.getDerivations().indexOf(grammar.getVariable());
                char[] derivations = value.getDerivations().toCharArray();

                if (this.isUpperCase(String.valueOf(derivations[positionVariable + 1]))) {
                    firstToProxVariable = this.first(String.valueOf(derivations[positionVariable + 1]));
                    //firsts.append(firstToProxVariable);
                }
            }else{
                firsts.append(this.getFirstWithBar(grammar));
            }
        }

        return firstValueDerivationCharArry = firsts.toString().toCharArray();
    }

    public char[] folow(String variable) {

        firsts = new StringBuffer();

        Grammar topGrammar = findGrammar("S");
        String derivationsTopGrammar = topGrammar.getDerivations();
        char[] derivationsTopGrammarCharArray = topGrammar.getDerivations().toCharArray();
        String folow = "";

        if(variable.equals("S")){
            folow = "$";
            return folow.toCharArray();
        }

        int positionVariable = derivationsTopGrammar.indexOf(variable);


        char[] firsts = this.first(String.valueOf(derivationsTopGrammarCharArray[positionVariable + 1]));



        return firsts;
    }

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
        if(first.toUpperCase().equals(first) && first.matches("[A-Z]")){
            return true;
        }else{
            return false;
        }
    }

    private boolean containBar(String derivation){
        return derivation.contains("|") ? true : false;
    }

    private String getFirstWithBar(Grammar grammar){
        char[] charArryFirstsTopValue;
        String finalValue = "";
        char[] derivationToCharArray = grammar.getDerivations().toCharArray();
        int positionBar = grammar.getDerivations().indexOf("|");
        String valueAfterBar = String.valueOf(derivationToCharArray[positionBar + 1]);

        if(isUpperCase(String.valueOf(derivationToCharArray[0]))){
            charArryFirstsTopValue = this.first(String.valueOf(derivationToCharArray[0]));
        }else{
            charArryFirstsTopValue = String.valueOf(derivationToCharArray[0]).toCharArray();
        }

        finalValue = Arrays.toString(charArryFirstsTopValue)
                .replace("[","")
                .replace("]","")
                .replace(",","")
                + valueAfterBar;

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

    private char[] getFirstWithEpsilon(String variable ,String firstsParam){
        String thisFirst = firstsParam;
        String firstReplaced = "";

        Grammar startGrammar = finalValuesGrammars.get(0);

        String derivationStartGramar = startGrammar.getDerivations();

        int positionCharacter = derivationStartGramar.indexOf(variable);

        char[] derivationStartGramarCharArray = derivationStartGramar.toCharArray();

        char proxVariable = derivationStartGramarCharArray[positionCharacter+1];

        if(isUpperCase(String.valueOf(proxVariable))){
            firstReplaced = thisFirst.replace("0", Arrays.toString(this.first(String.valueOf(proxVariable))));

            firstReplaced = firstReplaced
                    .replace("[","")
                    .replace("]","")
                    .replace(",","");
        }

            /*String variableActual = String.valueOf(derivationStartGramar[this.positionCharactere]);
            this.positionCharactere++;
            String variableAfterVariableActual = String.valueOf(derivationStartGramar[this.positionCharactere]);

            Grammar grammarTopValue = this.findGrammar(variableActual);

            for(int i = 0; i < finalValuesGrammars.size(); i++){
                if(finalValuesGrammars.get(i).getVariable().equals(valueAfterVariableActual)){
                    charArryfirstsProxValue = this.first(valueAfterVariableActual);
                }
            }

            for(char value:charArryfirstsProxValue){
                firstValueToProxGrammar.append(value);
            }

            charArryFirstsTopValue = grammarTopValue.getDerivations().toCharArray();
            String FirstsTopValue = String.valueOf(charArryFirstsTopValue[0]);

            finalValue = FirstsTopValue + firstValueToProxGrammar.toString();*/

        return firstReplaced.toCharArray();
    }

    private boolean containsUpperCase(String derivarion){
        char[] derivations = derivarion.toCharArray();
        int contador = 0;

        for(char value:derivations){
            String valueString = String.valueOf(value);
            if(valueString.toUpperCase().equals(valueString) && valueString.matches("[A-Z]")){
                contador++;
            }
        }

        if (contador > 0){
            return true;
        }

        return false;

    }

    private String getFirstVariable(String derivation){
        char[] derivations = derivation.toCharArray();

        return String.valueOf(derivations[0]);
    }

    private boolean conteinsVariable(String variable, String derivation){
        if(derivation.contains(variable)){
            return true;
        }

        return false;
    }

    private boolean containsEpsilon(String derivation){
        if(derivation.contains("0")) return true;

        return false;
    }

    private String replaced(char[] chars){
        return Arrays.toString(chars)
                .replace("[","")
                .replace("]","")
                .replace(",","");
    }

    private Grammar findGrammarAnalised(Grammar grammar) {

        for (Grammar value : grammarsAnalised) {

            if (value.getVariable() != grammar.getVariable() && this.containsUpperCase(value.getDerivations())) {
                if (this.conteinsVariable(grammar.getVariable(), value.getDerivations())) {
                    return value;
                }
            }
        }

        return null;
    }

}
