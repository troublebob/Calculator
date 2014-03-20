import Formulator.*;

import javax.swing.JOptionPane;

import java.util.regex.*;
import java.util.Vector;

public class TestCode {

	public static void main(String[] args) {
		String input="22X+7^6+7Cos(yX20)";
		FormulaElement f = new FormulaElement();
		f.parseFormula(input);
		
	}

}
/*
//Week2
ConstantElement ce1 =new ConstantElement(1);
ConstantElement ce2= new ConstantElement(2);
ConstantElement ce7 = new ConstantElement(7);
VariableElement veX = new VariableElement("X");
VariableElement veY = new VariableElement("Y");

MultipleFunctionElement mult = new MultipleFunctionElement();
PlusFunctionElement pl = new PlusFunctionElement();
pl.addArguments(veX);
pl.addArguments(ce7);
mult.addArguments(pl);
MinusFunctionElement ml = new MinusFunctionElement();
ml.addArguments(veX);
ml.addArguments(ce2);
mult.addArguments(ml);
pl = new PlusFunctionElement();
pl.addArguments(veX);
pl.addArguments(ce1);
mult.addArguments(pl);

//(X+7.0)(X-2.0)(X+1.0)
System.out.println(mult);

mult = new MultipleFunctionElement();
MultipleFunctionElement mult1 = new MultipleFunctionElement();
mult1.addArguments(veY);
mult1.addArguments(veY);
mult.addArguments(mult1);
mult1 = new MultipleFunctionElement();
mult1.addArguments(veX);
mult1.addArguments(veX);
pl = new PlusFunctionElement();
pl.addArguments(mult1);
pl.addArguments(ce2);
mult.addArguments(pl);		

//YY(XX+2)
System.out.println(mult);


pl = new PlusFunctionElement();
pl.addArguments(mult1);
pl.addArguments(ce7);
SineFunctionElement s = new SineFunctionElement(pl);

mult1 = new MultipleFunctionElement();
mult1.addArguments(veY);
mult1.addArguments(veY);
MinusFunctionElement mi = new MinusFunctionElement();
mi.addArguments(mult1);
mi.addArguments(ce2);
CosineFunctionElement c= new CosineFunctionElement(mi);
mult = new MultipleFunctionElement();
mult.addArguments(s);
mult.addArguments(c);

//Sin(X^2)Cos(Y^2-2)
System.out.println(mult);
*/