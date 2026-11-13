//Ivonne Nelson inelson1@cnm.edu
//MainSnowMan.java

import javax.swing.JFrame;

public class MainSnowMan{
	private SnowFrame snow;
	
	public static void main(String [] args){
		MainSnowMan app = new MainSnowMan();
	}
	
	public MainSnowMan(){
		snow = new SnowFrame();
                snow.setTitle("Snowman");
		snow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		snow.setSize(300,260);
		snow.setVisible(true);
	}
}