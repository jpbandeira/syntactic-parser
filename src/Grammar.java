import java.util.List;

public class Grammar {

    private String variable;
    private String derivations;
    private boolean analyzeEpsilonOrNot = true;

    public Grammar() {}

    public Grammar(String variable, String derivations) {
        this.variable = variable;
        this.derivations = derivations;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getDerivations() {
        return derivations;
    }

    public void setDerivations(String derivations) {
        this.derivations = derivations;
    }

    public boolean isAnalyzeEpsilonOrNot() {
        return analyzeEpsilonOrNot;
    }

    public void setAnalyzeEpsilonOrNot(boolean analyzeEpsilonOrNot) {
        this.analyzeEpsilonOrNot = analyzeEpsilonOrNot;
    }

}
