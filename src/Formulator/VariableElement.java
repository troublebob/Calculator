package Formulator;

public class VariableElement extends FormulaElement {

	private String variableElement;
	private double value;
	boolean isFullyGrounded;
	
	public VariableElement(String e){
		//super();
		variableElement=e;
		isFullyGrounded = false;
	}
	public String getVariableElement() {
		return variableElement;
	}

	public double getValue() {
		return value;
	}
	public void setVariableValue(String varName, double value){
		if(varName.equals(variableElement)){
			this.value = value;
			isFullyGrounded = true;
		}
	}
	public String toString(){
		if(this.isFullyGrounded){
			String s="";
			s+=getVariableElement()+"(With Value of:" + getValue()+")";
			return s;
		}else{
			return variableElement;
		}
		
	}
	public boolean isFullyGrounded(){
		return isFullyGrounded;
	}
}
