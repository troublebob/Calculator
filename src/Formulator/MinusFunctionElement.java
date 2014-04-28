package Formulator;

import java.util.Vector;

public class MinusFunctionElement extends FunctionElement{

	public MinusFunctionElement(){
		super();
	}
	public String toString() {
		StringBuffer st = new StringBuffer();
		Vector<FormulaElement> args=super.getArguments();
		for (int i = 0; i < args.size()-1; i++) {
			st.append(args.get(i).toString()+"-");
		}
		st.append(args.get(args.size()-1).toString());
		return st.toString();
	}
	public double getValue(){
		FunctionElement f = (FunctionElement)this;
		double temp = f.getArguments().elementAt(0).getValue();
		for (int i = 1; i < f.getArguments().size(); i++) {
			temp -= f.getArguments().elementAt(i).getValue();
		}
		return temp;
	}
}
