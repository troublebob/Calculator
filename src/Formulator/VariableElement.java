package Formulator;

public class VariableElement extends FormulaElement {

	private String variableElement;
	private double value;

	public VariableElement(String e){
		variableElement=e;
	}
	public String getVariableElement() {
		return variableElement;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
}
