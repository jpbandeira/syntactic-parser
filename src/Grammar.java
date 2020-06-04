import java.util.List;

public class Grammar {

    private String variable;
    private String derivations;
    private boolean containsEpsilon;
    private int positionBar;

    public Grammar() {}

    public Grammar(String variable, String derivations, boolean containsEpsilon) {
        this.variable = variable;
        this.derivations = derivations;
        this.containsEpsilon = containsEpsilon;
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

    public boolean isContainsEpsilon() {
        return containsEpsilon;
    }

    public void setContainsEpsilon(boolean containsEpsilon) {
        this.containsEpsilon = containsEpsilon;
    }

    public int getPositionBar() {
        return positionBar;
    }

    public void setPositionBar(int positionBar) {
        this.positionBar = positionBar;
    }
}
