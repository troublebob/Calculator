package Formulator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaElement {

	public void setVariableValue(String varName, double value){
		if(this instanceof VariableElement){
			((VariableElement)this).setVariableValue(varName, value);
		}else if (this instanceof ConstantElement){
		}else if (this instanceof FunctionElement){
			FunctionElement f = (FunctionElement)this;
			for(FormulaElement subf :f.getArguments()){
				subf.setVariableValue(varName,value);
			}
		}
	}
	public double getValue(){
		return 0;
	}

	public boolean isFullyGrounded(){
		if(this instanceof VariableElement){
			return ((VariableElement)this).isFullyGrounded();
		}else if (this instanceof ConstantElement){
			return ((ConstantElement)this).isFullyGrounded();
		}else if (this instanceof FunctionElement){
			FunctionElement f = (FunctionElement)this;
			for(FormulaElement subf :f.getArguments()){
				if(!subf.isFullyGrounded()){
					return false;
				}
			}
		}
		return true;
	}
	public static FormulaElement parseFormula(String s){

		Vector <Object> ob = new Vector<Object>();
		Pattern p= Pattern.compile("(Cos)|(Sin)|((?!Cos|sin)[A-Za-z])+|[0-9]+|[+]|-|/|\\^|\\(|\\)| |\t");
		//"[A-Za-z]+|[0-9]+|[+]|-|/|\\^|\\(|\\)| |\t|(Cos)|(Sin)"); //(Cos)|(Sin)|([A-Za-z](?!Cos|Sin))+|[0-9]|[+]|-|/|\\^|\\(|\\)| |\t|| 
		Matcher m= p.matcher(s);
		//System.out.println("Run/Recurse");
		while(m.find()){
			ob.add(m.group());
			//System.out.println(m.group());
		}

		//recursive part
		for (int i = 0; i < ob.size(); i++) {
			if(i==0 && Pattern.matches("\\(", ob.elementAt(i).toString())){
				//Recurse
				for (int j = i; j< ob.size();j++){
					int intNumBrackets = 0;
					if(Pattern.matches("\\(", ob.elementAt(i).toString())){
						intNumBrackets++;
					}else if(Pattern.matches("\\)", ob.elementAt(i).toString())){
						intNumBrackets--;
					}
					if(intNumBrackets==0){
						String subf = "";
						for(int k = i+1; k < j; k++){
							subf += ob.remove(i+1);
						}
						FormulaElement temp = parseFormula(subf);
						ob.set(i, temp);
						ob.remove(i+1);
					}
				}
			}else if(i>0 && Pattern.matches("\\(", ob.elementAt(i).toString()) && (ob.elementAt(i-1).toString().equals("Cos")==true||ob.elementAt(i-1).toString().equals("Sin")==true)){
				// Cosine and Sine
				//System.out.println("Triggered!!1st Case");
				int intNumBrackets = 0;
				for (int j = i; j < ob.size(); j++){
					if(Pattern.matches("\\(", ob.elementAt(j).toString())){
						intNumBrackets++;
					}else if(Pattern.matches("\\)", ob.elementAt(j).toString())){
						intNumBrackets--;
					}
					if(intNumBrackets==0){
						String subf = "";
						for(int k = i+1; k < j; k++){
							subf += ob.remove(i+1);
						}
						FormulaElement temp = parseFormula(subf);
						ob.insertElementAt(temp, i+1);
						i++;
						break;
					}
				}

			}else if(i>0 && Pattern.matches("\\(", ob.elementAt(i).toString())){
				//Recurse
				//System.out.println("Triggered!!2nd Case");
				int intNumBrackets = 0;
				for (int j = i; j < ob.size(); j++){
					if(Pattern.matches("\\(", ob.elementAt(j).toString())){
						intNumBrackets++;
					}else if(Pattern.matches("\\)", ob.elementAt(j).toString())){
						intNumBrackets--;
					}
					if(intNumBrackets==0){
						String subf = "";
						for(int k = i+1; k < j; k++){
							subf += ob.remove(i+1);
						}
						FormulaElement temp = parseFormula(subf);
						//ob.insertElementAt(temp, i+1);
						ob.set(i, temp);
						ob.remove(i+1);
						i++;
						break;
					}
				}
			}else{

			}
		}//Do the rest

		for (int i = 0; i < ob.size(); i++) {
			if(ob.elementAt(i) instanceof FormulaElement){

			}
			else if(Pattern.matches("\\d+", ob.elementAt(i).toString())){			
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
					mu.addArguments((VariableElement) ob.elementAt(i-1));
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
				PowerFunctionElement pw = new PowerFunctionElement();
				//(FormulaElement)ob.elementAt(i-1), (FormulaElement)ob.elementAt(i+1)
				if(ob.elementAt(i-1)instanceof PowerFunctionElement){
					((PowerFunctionElement) ob.elementAt(i-1)).addArguments((FormulaElement) ob.elementAt(i+1));
				}else{
					pw.addArguments((FormulaElement)ob.elementAt(i-1));
					pw.addArguments((FormulaElement)ob.elementAt(i+1));
					ob.set(i-1, pw);
				}				
				ob.remove(i);
				ob.remove(i);
				i--;
			}
		}
		testString(ob,"Pow");

		//for (int i = 0; i < ob.size(); i++) {
		//	System.out.println(">>>" + ob.get(i) + " - " + ob.get(i).getClass().getSimpleName());
		//}

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
				//i--;
			}
			if(ob.elementAt(i).toString().equals("Sin")){
				ob.set(i, new SineFunctionElement((FormulaElement)ob.elementAt(i+2)));
				ob.remove(i+1);
				ob.remove(i+1);
				ob.remove(i+1);
				//i--;
			}
		}

		testString(ob,"Trig");
		for (int i = 0; i < ob.size() - 1; i++){
			//System.out.println(i);
			testString(ob,"Inloop");
			if((ob.elementAt(i) instanceof FormulaElement) && (ob.elementAt(i+1) instanceof FormulaElement)){
				MultipleFunctionElement mu = new MultipleFunctionElement();
				mu.addArguments((FormulaElement) ob.elementAt(i));
				mu.addArguments((FormulaElement) ob.elementAt(i+1));
				ob.set(i, mu);
				ob.remove(i+1);
				//i--;
				//System.out.println(i);
			}
			//System.out.println(i);
			if(ob.elementAt(i).toString().equals("/")){
				DivideFunctionElement div = new DivideFunctionElement();
				div.addArguments((FormulaElement) ob.elementAt(i-1));
				div.addArguments((FormulaElement) ob.elementAt(i+1));
				ob.set(i-1,(FormulaElement)div);
				ob.remove(i);
				ob.remove(i);
				//i--;
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
		//System.out.println(ob.elementAt(0).getClass() + "Returns to recurse: "+ob.elementAt(0).toString());
		//validForm.add((FormulaElement) ob.elementAt(0));
		//args.add((FormulaElement) ob.elementAt(0));
		return ((FormulaElement) ob.elementAt(0));
	}

	static void testString(Vector<Object> ob,String run){
		for(int i=0;i<ob.size();i++){
			//	System.out.println(run+"<"+i+"> Current Class:"+ob.elementAt(i).getClass().getSimpleName()+" Current to_String:"+ob.elementAt(i).toString());
		}
	}
	public void checkingValue(FormulaElement subf, double temp){
		System.out.println(temp);
		System.out.println(subf.getClass());
		System.out.println(subf.toString());
	}
}