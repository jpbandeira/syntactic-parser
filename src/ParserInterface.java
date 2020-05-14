import java.util.List;

public interface ParserInterface {

    public List<Grammar> preparGrammar(List<String> grammars);
    public String first(Grammar grammar);
    public void folow(String grammar);
}
