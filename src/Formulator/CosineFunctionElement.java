package Formulator;
import java.math.*;
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
	public void addArguments(FormulaElement e){
		if(argumentsFlag==false){
			getArguments().add(e);
		}
	}
	public double getValue(){
		double temp=(this.getArguments().elementAt(0).getValue());
		//System.out.println(Math.toRadians(this.getArguments().elementAt(0).getValue()));
		return Math.round(Math.cos(Math.toRadians(temp)));
	}

	public String toString() {
		String s = "Cos";
		if(argumentsFlag){
			s+="("+getArguments().elementAt(0)+")";
		}
		return s;
	}
}
