//Ivonne Nelson
//SimpleFace Program

//MainSimpleFace.java

import javax.swing.JFrame;
import java.awt.Color;

public class Simpleface{

	Face drawing;
	
	public static void main(String[] args){
		Simpleface app = new Simpleface();
	}
	
	public Simpleface(){
		drawing = new Face();
		drawing.setSize(400, 400);
		drawing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawing.getContentPane().setBackground(Color.white);
		drawing.setVisible(true);
	} 
}

