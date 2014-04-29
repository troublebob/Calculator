import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;



import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.text.TextAction;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.ObjectInputStream.GetField;
import java.sql.Savepoint;

public class MainWindow {

	public final int EVALUATE = 42;
	public final int PARSE = 43;
	public final int GRAPH = 44;
	public final int CHANGEVAR = 45;
	private JFrame frame;
	private JTextField inputString;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_zero;
	private JButton button_clear;
	private JButton button_eq;
	private JButton button_plus;
	private JButton button_minus;
	private JButton button_mult;
	private JButton button_divide;
	private JButton button_delete;
	private JButton button_lpar;
	private JButton button_rpar;
	private JButton button_pow;
	private JButton button_sin;
	private JButton button_cos;
	private JButton button_graph;
	private JButton button_diff;
	private JButton button_save;
	private JButton button_load;

	ImageIcon saveIcon = new ImageIcon("filesave.png");

	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 }

	 /**
	  * Create the application.
	  */
	 public MainWindow() {
		 initialize();
	 }

	 /**
	  * Initialize the contents of the frame.
	  */
	 private void initialize() {
		 frame = new JFrame("~ I drop");
		 frame.setResizable(false);
		 frame.setBounds(100, 100, 450, 300);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.getContentPane().setLayout(null);
		 frame.setName("~ I drop!");

		 final Decider decider = new Decider();
		 inputString = new JTextField();
		 inputString.setBounds(10, 11, 414, 39);
		 frame.getContentPane().add(inputString);
		 inputString.setColumns(10);
		 inputString.setBackground(Color.WHITE);
		 inputString.setFont(new Font("Courier New", Font.BOLD, 16));
		 button_1 = new JButton("1");
		 button_1.setBounds(10, 61, 60, 33);
		 frame.getContentPane().add(button_1);
		 button_1.addActionListener(new ActionListener() {              
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "1");
			 }
		 });

		 button_2 = new JButton("2");
		 button_2.setBounds(70, 61, 60, 33);
		 frame.getContentPane().add(button_2);
		 button_2.addActionListener(new ActionListener() {              
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "2");
			 }
		 });


		 button_3 = new JButton("3");
		 button_3.setBounds(130, 61, 60, 33);
		 frame.getContentPane().add(button_3);
		 button_3.addActionListener(new ActionListener() {              
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "3");
			 }
		 });

		 button_4 = new JButton("4");
		 button_4.setBounds(10, 94, 60, 33);
		 frame.getContentPane().add(button_4);
		 button_4.addActionListener(new ActionListener() {              
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "4");
			 }
		 });

		 button_5 = new JButton("5");
		 button_5.setBounds(70, 94, 60, 33);
		 frame.getContentPane().add(button_5);
		 button_5.addActionListener(new ActionListener() {              
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "5");
			 }
		 });

		 button_6 = new JButton("6");
		 button_6.setBounds(130, 94, 60, 33);
		 frame.getContentPane().add(button_6);
		 button_6.addActionListener(new ActionListener() {              
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "6");
			 }
		 });

		 button_7 = new JButton("7");
		 button_7.setBounds(10, 127, 60, 33);
		 frame.getContentPane().add(button_7);
		 button_7.addActionListener(new ActionListener() {              
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "7");
			 }
		 });

		 button_8 = new JButton("8");
		 button_8.setBounds(70, 127, 60, 33);
		 frame.getContentPane().add(button_8);
		 button_8.addActionListener(new ActionListener() {              
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "8");
			 }
		 });

		 button_9 = new JButton("9");
		 button_9.setBounds(130,127, 60, 33);
		 frame.getContentPane().add(button_9);
		 button_9.addActionListener(new ActionListener() {              
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "9");
			 }
		 });

		 button_clear = new JButton("C");
		 button_clear.setBounds(10,160, 60, 33);
		 frame.getContentPane().add(button_clear);
		 button_clear.addActionListener(new ActionListener() {          
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText("");
			 }
		 });

		 button_zero = new JButton("0");
		 button_zero.setBounds(70,160, 60, 33);
		 frame.getContentPane().add(button_zero);
		 button_zero.addActionListener(new ActionListener() {           
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "0");
			 }
		 });

		 button_delete = new JButton("Del");
		 button_delete.setBounds(130,160, 60, 33);
		 frame.getContentPane().add(button_delete);
		 button_delete.addActionListener(new ActionListener() {         
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub

				 //String text = JTextField.;
				 inputString.setText(inputString.getText().substring(0, inputString.getText().length() -1));
			 }
		 });

		 button_plus = new JButton("+");
		 button_plus.setBounds(244, 61, 60, 33);
		 frame.getContentPane().add(button_plus);
		 button_plus.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "+");
			 }
		 } );

		 button_minus = new JButton("-");
		 button_minus.setBounds(304, 61, 60, 33);
		 frame.getContentPane().add(button_minus);
		 button_minus.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "-");
			 }
		 } );

		 button_mult = new JButton("*");
		 button_mult.setBounds(364, 61, 60, 33);
		 frame.getContentPane().add(button_mult);
		 button_mult.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "*");
			 }
		 } );

		 button_divide = new JButton("/");
		 button_divide.setBounds(244, 94, 60, 33);
		 frame.getContentPane().add(button_divide);
		 button_divide.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "/");
			 }
		 } );

		 button_lpar = new JButton("(");
		 button_lpar.setBounds(304, 94, 60, 33);
		 frame.getContentPane().add(button_lpar);
		 button_lpar.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "(");
			 }
		 } );

		 button_rpar = new JButton(")");
		 button_rpar.setBounds(364, 94, 60, 33);
		 frame.getContentPane().add(button_rpar);
		 button_rpar.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + ")");
			 }
		 } );

		 button_pow = new JButton("^");
		 button_pow.setBounds(244, 127, 60, 33);
		 frame.getContentPane().add(button_pow);
		 button_pow.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "^");
			 }
		 } );

		 button_sin = new JButton("Sin");
		 button_sin.setBounds(304, 127, 60, 33);
		 frame.getContentPane().add(button_sin);
		 button_sin.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "Sin(");
			 }
		 } );

		 button_cos = new JButton("Cos");
		 button_cos.setBounds(364, 127, 60, 33);
		 frame.getContentPane().add(button_cos);
		 button_cos.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(inputString.getText() + "Cos(");
			 }
		 } );

		 button_eq = new JButton("Eval");
		 button_eq.setBounds(244, 160, 60, 33);
		 frame.getContentPane().add(button_eq);
		 button_eq.addActionListener(new ActionListener() {

			 @Override
			 //add solve before string
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText(decider.answer(EVALUATE, inputString.getText()));
			 }
		 } );

		 button_graph = new JButton("dral");
		 button_graph.setBounds(304, 160, 60, 33);
		 frame.getContentPane().add(button_graph);
		 button_graph.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText("graph " + inputString.getText());
			 }
		 } );

		 button_diff = new JButton("diff");
		 button_diff.setBounds(364, 160, 60, 33);
		 frame.getContentPane().add(button_diff);
		 button_diff.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 inputString.setText("diffrenciate " + inputString.getText());
			 }
		 } );

		 button_save = new JButton("Save");
		 button_save.setBounds(61, 204, 80, 40);
		 frame.getContentPane().add(button_save);
		 button_save.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub

				 //                         	 JFileChooser chooser = new JFileChooser();
				 //                        	 FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "Text Files");
				 //                        	    chooser.setFileFilter(filter);
				 //                        	    int returnVal = chooser.showOpenDialog(chooser);
				 //                        	    if(returnVal == JFileChooser.APPROVE_OPTION) {
				 //                        	       System.out.println("You chose to save this file: " +
				 //                        	            chooser.getSelectedFile().getName());
				 //                        	       
				// saveFile saving = null;
				 String formula = inputString.getText();
				 System.out.println(formula);
			//	 saving.save(formula);

			 }               

		 }
		 //           }
				 );





		 button_load = new JButton("Load");
		 button_load.setBounds(293, 204, 80, 40);
		 frame.getContentPane().add(button_load);
		 button_load.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub

				 JFileChooser chooser = new JFileChooser();
				 FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "Text Files");
				 chooser.setFileFilter(filter);
				 int returnVal = chooser.showOpenDialog(chooser);
				 if(returnVal == JFileChooser.APPROVE_OPTION) {
					 System.out.println("You chose to load this file: " +
							 chooser.getSelectedFile().getName());


				 } 
			 }
		 } );



	 }
}