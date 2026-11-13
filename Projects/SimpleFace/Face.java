//Ivonne Nelson
//Face class

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class Face extends JFrame{
	
	public static final int FACE_DIAMETER = 200;
	public static final int X_FACE = 100;
	public static final int Y_FACE = 100;
	
	public static final int EYE_WIDTH = 20;
	public static final int X_RIGHT_EYE = X_FACE + 55;
	public static final int Y_RIGHT_EYE = Y_FACE + 60;
	public static final int X_LEFT_EYE = X_FACE + 130;
	public static final int Y_LEFT_EYE = Y_FACE + 60;
	
	public static final int MOUTH_WIDTH = 100;
	public static final int X_MOUTH = X_FACE + 50;
	public static final int Y_MOUTH = Y_FACE + 150;
	
	public Face(){
		super("First Graphics Demo");
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawOval(X_FACE, Y_FACE, FACE_DIAMETER, FACE_DIAMETER);
		
		//Draw eyes
		g.drawLine(X_RIGHT_EYE, Y_RIGHT_EYE, X_RIGHT_EYE + EYE_WIDTH, Y_RIGHT_EYE + EYE_WIDTH);
		g.drawLine(X_LEFT_EYE, Y_LEFT_EYE, X_LEFT_EYE + EYE_WIDTH, Y_LEFT_EYE + EYE_WIDTH);
		
		//Draw Mouth
		g.drawLine(X_MOUTH, Y_MOUTH, X_MOUTH + MOUTH_WIDTH, Y_MOUTH);
	}
	
}