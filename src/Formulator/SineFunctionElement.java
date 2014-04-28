package Formulator;
import java.math.*;

public class SineFunctionElement extends FunctionElement{

	boolean argumentsFlag=false;
	
	public SineFunctionElement(FormulaElement e){
		super();
		addArguments(e);
		argumentsFlag=true;
	}
	public SineFunctionElement(){
		super();
	}
	public double getValue(){
		return Math.round(Math.sin(Math.toRadians(this.getArguments().elementAt(0).getValue())));
	}
	public void addArguments(FormulaElement e){
		if(argumentsFlag==false){
			getArguments().add(e);
		}
	}
	public String toString() {
		String s = "Sin";
		if(argumentsFlag){
			s+="("+getArguments().elementAt(0)+")";
		}
		return s;
	}
}
