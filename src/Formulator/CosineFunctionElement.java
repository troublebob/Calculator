package Formulator;

public class CosineFunctionElement extends FunctionElement{

	boolean argumentsFlag=false;
	
	public CosineFunctionElement(FormulaElement f1){
		super();
		addArguments(f1);
		argumentsFlag=true;
	}
	public CosineFunctionElement(){
		super();
	}
//	public void addArguments(FormulaElement e){
//		if(argumentsFlag==false){
//			this.addArguments(e);
//		} else {
//		}
//	}

	public String toString() {
		String s = "Cos";
		if(argumentsFlag){
			s+=getArguments().elementAt(0);
		}
		return s;
	}
}
