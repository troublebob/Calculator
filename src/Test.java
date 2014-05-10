import Formulator.*;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="x*y+3^4";
		FormulaElement f = FormulaElement.parseFormula(input);
		System.out.println(f.toString());
		
	}

}
