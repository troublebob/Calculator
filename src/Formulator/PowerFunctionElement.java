package Formulator;

import java.util.Vector;
import java.math.*;
public class PowerFunctionElement extends FunctionElement{
	
	public PowerFunctionElement(FormulaElement b,FormulaElement ex){
		super();
		addArguments(b);
		addArguments(ex);
	}
	public String toString() {
		StringBuffer st = new StringBuffer();
		Vector<FormulaElement> args=super.getArguments();
		for (int i = 0; i < args.size()-1; i++) {
			st.append(args.get(i).toString()+"^");
		}
		st.append(args.get(args.size()-1).toString());
		return st.toString();
	}
	public double getValue(){
		double temp = this.getArguments().elementAt(0).getValue();
		FunctionElement f = (FunctionElement)this;
		for (int i = 1; i < f.getArguments().size(); i++) {
			temp = Math.pow(temp, f.getArguments().elementAt(i).getValue());
		}
		return temp;
	}
}
