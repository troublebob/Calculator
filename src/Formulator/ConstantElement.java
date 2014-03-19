package Formulator;

public class ConstantElement extends FormulaElement{

	private double constantElement;

	public ConstantElement(double e){
		constantElement=e;
	}
	public double getValue() {
		return constantElement;
	}
}
