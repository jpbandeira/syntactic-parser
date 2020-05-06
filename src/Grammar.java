public class Grammar {

    private String variable;
    private String derivations;

    public Grammar(String variable, String derivations) {
        this.variable = variable;
        this.derivations = derivations;
    }

    public Grammar() {

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
}
