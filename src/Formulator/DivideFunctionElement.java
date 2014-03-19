package Formulator;

import java.util.Vector;

public class DivideFunctionElement extends FunctionElement {

	public String toString() {
		StringBuffer st = new StringBuffer();
		Vector<FormulaElement> args=super.getArguments();
		for (int i = 0; i < args.size()-1; i++) {
			st.append(args.get(i).toString()+"/");
		}
		st.append(args.get(args.size()-1).toString());
		return st.toString();
	}
}
