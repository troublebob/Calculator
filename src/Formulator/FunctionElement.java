package Formulator;

import java.util.Vector;

public class FunctionElement extends FormulaElement {
	private Vector<FormulaElement> arguments;
	
	public void addArguments(FormulaElement e){
		arguments.add(e);
	}
	public Vector<FormulaElement> getArguments(){
		return arguments;
	}
}
