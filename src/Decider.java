import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import Formulator.FormulaElement;

public class Decider {

	public final int EVALUATE = 42;
	public final int PARSE = 43;
	public final int GRAPH = 44;
	public final int CHANGEVAR = 45;

	public String answer(int inputButton, String input){
		StringBuffer s = new StringBuffer();
		if(inputButton==EVALUATE){

			FormulaElement f = FormulaElement.parseFormula(input);
			if(f.equals(null)){
				s.append("Is not Fully Grounded!");
				return s.toString();

			}

			if(f.isFullyGrounded()){
				s.append(f.getValue());
			}else{
				s.append("Is not Fully Grounded!");
			}

		}else if (inputButton==PARSE){
			FormulaElement f = FormulaElement.parseFormula(input);
			s.append(f.toString());
		}else if (inputButton==GRAPH){
			String vName = "";
			String func = "";
			double lower = 0.0;
			double upper = 0.0;            
			List<String> graphlist = Arrays.asList(input.split(","));

			if(graphlist.size()!=4){
				s.append("Invalid Graph Syntax.");
				return s.toString();
			}

			if(!(graphlist.get(0) instanceof String || graphlist.get(1) instanceof String)){
				s.append("Invalid Graph Syntax.");
				return s.toString();

			}
			try {
				lower = Double.parseDouble(graphlist.get(2));
				upper = Double.parseDouble(graphlist.get(3));
			} catch (NumberFormatException | NullPointerException e) {
				s.append("Invalid Graph Syntax.");
				return s.toString();

			}

			vName = graphlist.get(0) ;
			func = graphlist.get(1);
			ArrayList<Double> points = new ArrayList<Double>();
			for (double i = lower; i <= upper; i+=0.1) {
				FormulaElement result = FormulaElement.parseFormula(func);
				result.setVariableValue(vName, i);
				Coordinate currentPoint = new Coordinate(i,((double)result.getValue()));
				points.add((double)result.getValue());
				System.out.println(currentPoint);
				//points.add(currentPoint);
			}
			DrawGraph.createAndShowGui(points);
		}      
		else if (inputButton==CHANGEVAR){
			//To Do                
		}

		return s.toString();

	}
}