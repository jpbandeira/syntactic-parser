import java.util.List;

public interface ParserInterface {

    public List<Grammar> preparGrammar(String grammars);
    public char[] first(String grammar);
    public void folow(String grammar);
}
