import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawGraph extends JPanel {
	private static final int MAX_SCORE = 100;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 650;
	private static final int BORDER_GAP = 30;
	private static final Color GRAPH_COLOR = Color.blue;
	private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
	private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
	private static final int GRAPH_POINT_WIDTH = 10;
	private List<Double> scores;

	public DrawGraph(ArrayList<Double> scores2) {
		this.scores = scores2;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		double xScale = ((double) (getWidth()) -  BORDER_GAP) / (scores.size() - 1);
		double yScale = ((double) (getHeight()/2) -  BORDER_GAP) / (MAX_SCORE - 1);

		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < scores.size(); i++) {
			int x1 = (int) (i * xScale + BORDER_GAP);
			int y1 = (int) ((MAX_SCORE - scores.get(i)) * yScale + BORDER_GAP);
			graphPoints.add(new Point(x1, y1));
		}

		// create x and y axes
		//g2.drawLine(); 	// x axis
		//g2.drawLine();	// y axis

		Stroke oldStroke = g2.getStroke();
		g2.setColor(GRAPH_COLOR);
		g2.setStroke(GRAPH_STROKE);
		for (int i = 0; i < graphPoints.size() - 1; i++) {
			int x1 = graphPoints.get(i).x;
			int y1 = graphPoints.get(i).y;
			int x2 = graphPoints.get(i + 1).x;
			int y2 = graphPoints.get(i + 1).y;
			g2.drawLine(x1, y1, x2, y2);        
		}

		g2.setStroke(oldStroke);      
		g2.setColor(GRAPH_POINT_COLOR);
		for (int i = 0; i < graphPoints.size(); i++) {
			int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
			int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
			int ovalW = GRAPH_POINT_WIDTH;
			int ovalH = GRAPH_POINT_WIDTH;
			g2.fillOval(x, y, ovalW, ovalH);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

	static void createAndShowGui(ArrayList<Double> scores2) {
		List<Integer> scores1 = new ArrayList<Integer>();
		// Random random = new Random();
		int maxDataPoints = 16;
		int maxScore = 20;
		//      for (int i = 0; i < maxDataPoints ; i++) {
		//         scores.add(random.nextInt(maxScore));
		//      }
		DrawGraph mainPanel = new DrawGraph(scores2);

		JFrame frame = new JFrame("~ i drop");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

}