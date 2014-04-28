package Formulator;

import java.util.Vector;
import java.math.*;
public class PowerFunctionElement extends FunctionElement{
	
	public PowerFunctionElement(){
		super();
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
		FunctionElement f = (FunctionElement)this;
		double temp=0;
		for (int i = f.getArguments().size()-1; i >= 1 ; i--) {
			if(temp==0){
				temp = Math.pow(f.getArguments().elementAt(i-1).getValue(), f.getArguments().elementAt(i).getValue());
			}else{
				temp = Math.pow(f.getArguments().elementAt(i-1).getValue(), temp);
			}
		}
		return temp;
	}
}
