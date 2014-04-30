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
		//System.out.println("Here");
		//System.out.println("args"+this.getArguments().elementAt(0).getValue());
		//System.out.println("toRads"+Math.toRadians(this.getArguments().elementAt(0).getValue()));
		//System.out.println("Sin"+Math.sin(Math.toRadians(this.getArguments().elementAt(0).getValue())));
		double value = Math.sin(Math.toRadians(this.getArguments().elementAt(0).getValue()));
		//System.out.println(value);
		return value;
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
