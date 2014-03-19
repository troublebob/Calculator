import Formulator.*;

public class TestCode {

	public static void main(String[] args) {
		ConstantElement ce1 = new ConstantElement(2);
		ConstantElement ce2 = new ConstantElement(7);
		VariableElement ve1 = new VariableElement("X");
		
		MultipleFunctionElement mfe = new MultipleFunctionElement();
		MinusFunctionElement mife = new MinusFunctionElement();
		
		mfe.addArguments(ce1);
		mfe.addArguments(ve1);
		
		mife.addArguments(mfe);
		
		mife.addArguments(ce2);
		//mife now contains 2X-7
		
		VariableElement ve2 = new VariableElement("Y");
		MultipleFunctionElement mfe1 = new MultipleFunctionElement();
		mfe1.addArguments(ve2);
		mfe1.addArguments(ve2);
		
		
		MultipleFunctionElement mfe2 = new MultipleFunctionElement();
		mfe2.addArguments(ve1);
		mfe2.addArguments(ve1);
		PlusFunctionElement pl = new PlusFunctionElement();
		pl.addArguments(mfe2);
		pl.addArguments(ce1);
		
		DivideFunctionElement dfe = new DivideFunctionElement();
		dfe.addArguments(mfe1);
		dfe.addArguments(pl);
		//Now Contains Y^2/(X^2 + 2)
	}

}
