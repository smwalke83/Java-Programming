
//CIS 2235 Java Debugging Problem

// SW Had to import JFrame for line 19
import javax.swing.JFrame;


public class Main
{
	
	
	public static void main(String []args)
	{
		// SW The G in DateGenerator needed to be capitalized to match the class
		DateGenerator gen = new DateGenerator();
		MyDateFrame frame = new MyDateFrame(gen);
		frame.setTitle("CIS 2935 Java Debugging Problem");
		frame.setSize(400, 250);
		// SW JFrame was not imported
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		// SW needed a semicolon, setVisible needed a boolean argument
		frame.setVisible(true);

	}
}