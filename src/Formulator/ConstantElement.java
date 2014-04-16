package Formulator;

public class ConstantElement extends FormulaElement{

	private double constantElement;

	public ConstantElement(double e){
		constantElement=e;
	}
	public double getValue() {
		return constantElement;
	}
	public String toString(){
		return String.valueOf(constantElement);
	}
	public boolean isFullyGrounded(){
		return true;
	}
}
