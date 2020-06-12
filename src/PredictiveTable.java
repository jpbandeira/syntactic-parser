public class PredictiveTable {

    private String variable;
    private String terminalSymbol;
    private String producion;

    public PredictiveTable(){}

    public PredictiveTable(String variable, String terminalSymbol, String producion) {
        this.variable = variable;
        this.terminalSymbol = terminalSymbol;
        this.producion = producion;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getTerminalSymbol() {
        return terminalSymbol;
    }

    public void setTerminalSymbol(String terminalSymbol) {
        this.terminalSymbol = terminalSymbol;
    }

    public String getProducion() {
        return producion;
    }

    public void setProducion(String producion) {
        this.producion = producion;
    }
}
