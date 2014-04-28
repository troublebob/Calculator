package Formulator;

import java.util.Vector;

public class MultipleFunctionElement extends FunctionElement {
	
	public MultipleFunctionElement(){
		super();
	}

	public String toString() {
		
		StringBuffer st = new StringBuffer();
		StringBuffer st1 =new StringBuffer();
		double tempConst = 1;
		
		Vector<FormulaElement> args=super.getArguments();
		
		for (int i = 0; i < args.size(); i++) {			
			//System.out.println("<"+i+">"+args.get(i).getClass());
			if((args.get(i).getClass() == ConstantElement.class)){
				tempConst *= args.get(i).getValue();
			}else if((args.get(i).getClass() == PlusFunctionElement.class) || (args.get(i).getClass() == MinusFunctionElement.class)){
				st.append("("+args.get(i).toString()+")");
			}else{
				st.append(args.get(i).toString());
			}
		}
		ConstantElement tc = new ConstantElement(tempConst);
		if(tc.getValue()!=1){
			st1.append(tc.toString());
		}
		return (st1.append(st.toString()).toString());
	}
	public double getValue(){
		double temp = 1;
		FunctionElement f = (FunctionElement)this;
		for(FormulaElement subf :f.getArguments()){
			temp *= subf.getValue();
			subf.checkingValue(subf, temp);	
		}
		return temp;
	}
	
}
