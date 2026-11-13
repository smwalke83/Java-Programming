//Class for main method

import javax.swing.JFrame;

public class MainFigure{
	TestFigurePanel frame;
	
	
	public static void main(String[] args) {
		MainFigure app = new MainFigure();
    }
	
	public MainFigure(){	
	frame = new TestFigurePanel();
    frame.setSize(400, 200);
    frame.setTitle("TestFigurePanel");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
	}
	
  
 }