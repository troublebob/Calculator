package Formulator;

public class SineFunctionElement extends FunctionElement{

	boolean argumentsFlag=false;
	
	public SineFunctionElement(FormulaElement e){
		super();
		addArguments(e);
		argumentsFlag=true;
	}
//	public SineFunctionElement(){
//		super();
//	}
//	public void addArguments(FormulaElement e){
//		if(argumentsFlag==false){
//			addArguments(e);
//		} else {
//			
//		}
//	}
	public String toString() {
		String s = "";
		s+="Sin "+getArguments().elementAt(0);
		return s;
	}
}
