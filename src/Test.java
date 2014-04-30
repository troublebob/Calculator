import Formulator.ConstantElement;
import Formulator.FormulaElement;
import Formulator.SineFunctionElement;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="Sin(30)";
		FormulaElement f = FormulaElement.parseFormula(input);
		System.out.println(f.getValue());
		ConstantElement c = new ConstantElement(30);
		
		SineFunctionElement s = new SineFunctionElement();
		s.addArguments(c);
		System.out.println(s.getValue());
	}

}
