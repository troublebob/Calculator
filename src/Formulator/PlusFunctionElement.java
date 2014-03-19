package Formulator;

import java.util.Vector;

public class PlusFunctionElement extends FunctionElement{
	
	public PlusFunctionElement(){
		super();
	}
	public String toString() {
		StringBuffer st = new StringBuffer();
		Vector<FormulaElement> args=super.getArguments();
		for (int i = 0; i < args.size()-1; i++) {
			st.append(args.get(i).toString()+"+");
		}
		st.append(args.get(args.size()-1).toString());
		return st.toString();
	}
}
