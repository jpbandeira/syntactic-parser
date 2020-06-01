import java.util.List;

public interface ParserInterface {

    public List<Grammar> preparGrammar(String grammars);
    public String first(String grammar);
    public void folow(String grammar);
}
