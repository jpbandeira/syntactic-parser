import java.util.ArrayList;
import java.util.List;

public class Parser implements ParserInterface {

    @Override
    public void first(List<String> inputs) {
        List<Grammar> grammars =  this.preparGramar(inputs);
        showValuesGrammar(grammars);
    }

    @Override
    public void folow(String grammar) {
        //This method is not implemented yet
    }

    private List<Grammar> preparGramar(List<String> grammars){
        ArrayList<Grammar> values = new ArrayList<>();

        for(String value:grammars){
            Grammar grammar = new Grammar();
            StringBuffer toConcat = new StringBuffer();

            String noSpaceArray = value.replaceAll("\\s*", "");
            String[] splited = noSpaceArray.split("[->]");

            grammar.setVariable(splited[0]);

            for (int i = 1; i < splited.length; i++){
                if(!splited[i].equals("")) toConcat.append(splited[i]);
            }

            grammar.setDerivations(String.valueOf(toConcat));
            values.add(grammar);
        }

        return values;

    }

    private void showValuesGrammar(List<Grammar> grammars){
        for(Grammar value:grammars){
            if(!value.equals("")){
                System.out.println(value.getVariable() + "->" + value.getDerivations());
            }
        }
    }
}
