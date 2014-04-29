import Formulator.FormulaElement;

public class Decider {

	public final int EVALUATE = 42;
	public final int PARSE = 43;
	public final int GRAPH = 44;
	public final int CHANGEVAR = 45;
	
	public String answer(int inputButton, String formula){
		StringBuffer s = new StringBuffer();
		FormulaElement f = FormulaElement.parseFormula(formula);
		if(inputButton==42){

			if(f.isFullyGrounded()){
				s.append(f.getValue());
			}else{
				s.append("Is not Fully Grounded!");
			}
			
		}else if (inputButton==PARSE){
			s.append(f.toString());
		}else if (inputButton==GRAPH){
			//To Do
		}else if (inputButton==CHANGEVAR){
			//To Do			
		}
		
		return s.toString();
		
	}
}
