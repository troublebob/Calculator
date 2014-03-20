package Formulator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaElement {

	private Vector<Object> ob = new Vector<Object>();

	public double getValue() {
		return 0;
	}
	public void parseFormula(String s){
		Pattern p= Pattern.compile("[A-Za-z]+|[0-9]+|[+]|-|/|\\^|\\(|\\)| |\t|(Cos)|(Sin)");
		Matcher m= p.matcher(s);

		while(m.find()){
			ob.add(m.group());
			//System.out.println(m.group());
		}

		for (int i = 0; i < ob.size(); i++) {
			if(Pattern.matches("\\d+", ob.elementAt(i).toString())){			
				//If numbers change to Constants
				ConstantElement ce = new ConstantElement(Double.parseDouble((String) ob.elementAt(i)));
				ob.set(i, ce);
			}else if(ob.elementAt(i).toString().equals("Cos")){
				CosineFunctionElement cs = new CosineFunctionElement();
				ob.set(i, cs);
			}else if(ob.elementAt(i).toString().equals("Sin")){
				SineFunctionElement ss = new SineFunctionElement();
				ob.set(i, ss);				
			}else if(Pattern.matches("[+]|-|/|\\^|\\(|\\)", ob.elementAt(i).toString())){
				//Leave Delimiters as is for the moment
			}else{
				//Change words except Cos and Sin to variable elements
				VariableElement ve = new VariableElement(ob.elementAt(i).toString());
				ob.set(i,ve);
			}
		}
		testString(ob,"V C Cos Sin");
		for (int i = 1; i < ob.size(); i++) {
			if(ob.elementAt(i) instanceof ConstantElement){
				if(ob.elementAt(i-1) instanceof VariableElement){
					MultipleFunctionElement mu = new MultipleFunctionElement();
					mu.addArguments((ConstantElement) ob.elementAt(i));
					mu.addArguments((VariableElement)ob.elementAt(i-1));
					ob.set(i-1, mu);
					ob.remove(i);
					i--;
				}
			}
			if(ob.elementAt(i) instanceof VariableElement){
				if(ob.elementAt(i-1) instanceof ConstantElement){
					MultipleFunctionElement mu = new MultipleFunctionElement();
					mu.addArguments((ConstantElement) ob.elementAt(i-1));
					mu.addArguments((VariableElement) ob.elementAt(i));
					ob.set(i-1, mu);
					ob.remove(i);
					i--;
				}
			}
		}
		testString(ob,"Mult");
		//Have done the power function pre Cos and Sin as example in assignment doc has powerfunctionelement as argument for Cos
		for (int i = 1; i < ob.size(); i++) {
			if(ob.elementAt(i).toString().equals("^")){
				PowerFunctionElement pw = new PowerFunctionElement((FormulaElement)ob.elementAt(i-1), (FormulaElement)ob.elementAt(i+1));
				ob.set(i-1, pw);
				ob.remove(i);
				ob.remove(i);
				i--;
			}
		}
		testString(ob,"Pow");
		for (int i = 0; i < ob.size(); i++) {
			if(ob.elementAt(i).toString().equals("Cos")){
				//Add item between brackets to Element
				ob.set(i, new CosineFunctionElement((FormulaElement)ob.elementAt(i+2)));
				//remove '('
				ob.remove(i+1);
				//Remove 'FormulaElement'
				ob.remove(i+1);
				//Remove ')'
				ob.remove(i+1);
				i--;
			}
			if(ob.elementAt(i).toString().equals("Sin")){
				ob.set(i, new SineFunctionElement((FormulaElement)ob.elementAt(i+2)));
				ob.remove(i+1);
				ob.remove(i+1);
				ob.remove(i+1);
				i--;
			}
		}

		testString(ob,"Trig");
		for (int i = 0; i < ob.size() - 1; i++){
			if((ob.elementAt(i) instanceof FormulaElement) && (ob.elementAt(i+1) instanceof FormulaElement)){
				MultipleFunctionElement mu = new MultipleFunctionElement();
				mu.addArguments((FormulaElement) ob.elementAt(i));
				mu.addArguments((FormulaElement) ob.elementAt(i+1));
				ob.set(i, mu);
				ob.remove(i+1);
				i--;
			}
			if(ob.elementAt(i).toString().equals("/")){
				DivideFunctionElement div = new DivideFunctionElement();
				div.addArguments((FormulaElement) ob.elementAt(i-1));
				div.addArguments((FormulaElement) ob.elementAt(i+1));
				ob.set(i-1,(FormulaElement)div);
				ob.remove(i);
				ob.remove(i);
				i--;
			}
		}
		testString(ob,"Mult+/");
		for (int i = 1; i < ob.size() - 1; i++){
			if(ob.elementAt(i).toString().equals("+")){
				PlusFunctionElement pl = new PlusFunctionElement();
				pl.addArguments((FormulaElement) ob.elementAt(i-1));
				pl.addArguments((FormulaElement) ob.elementAt(i+1));
				ob.set(i-1,(FormulaElement)pl);
				ob.remove(i);
				ob.remove(i);
				i--;
			}
			if(ob.elementAt(i).toString().equals("-")){
				MinusFunctionElement pl = new MinusFunctionElement();
				pl.addArguments((FormulaElement) ob.elementAt(i-1));
				pl.addArguments((FormulaElement) ob.elementAt(i+1));
				ob.set(i-1,(FormulaElement)pl);
				ob.remove(i);
				ob.remove(i);
				i--;
			}
		}
		testString(ob,"+Or-");
	}
	public void testString(Vector<Object> ob,String run){
		for(int i=0;i<ob.size();i++){
			System.out.println(run+"<"+i+"> Current Class:"+ob.elementAt(i).getClass()+" Current to_String:"+ob.elementAt(i).toString());
		}
	}

}
