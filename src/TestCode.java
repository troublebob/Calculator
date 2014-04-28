import Formulator.*;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.lang.reflect.Array;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Vector;

public class TestCode {

	public static void main(String[] args) {
		
		//FormulaElement result = FormulaElement.parseFormula(input);
		/*public static void main(String[] args) {
      	SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGui();
         	}
      	});*/
		ArrayList<FormulaElement> graph = new ArrayList<FormulaElement>();
		ArrayList<Integer> graphVals = new ArrayList<Integer>();
		for (int i = 0; i < 16; i++) {
			FormulaElement result = FormulaElement.parseFormula("3x+5*20");
			result.setVariableValue("x", i);
			graph.add(result);
			graphVals.add((int)result.getValue());
		}
		
		DrawGraph testGraph = new DrawGraph(graphVals);
		testGraph.createAndShowGui(graphVals);
	}

}
