// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Project: Text Area Demo

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DescriptionPanel extends JPanel{
	private JLabel jlblImageTitle = new JLabel();
	private JTextArea jtaDescription = new JTextArea();
	
	public DescriptionPanel(){
		initComponents();
	}

	private void initComponents(){
		//Center the icon and place the text under the icon
		jlblImageTitle.setHorizontalAlignment(JLabel.CENTER);
		jlblImageTitle.setHorizontalTextPosition(JLabel.CENTER);
		jlblImageTitle.setVerticalTextPosition(JLabel.BOTTOM);
		//Set the font in the label and the textarea
		jlblImageTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
		jtaDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		//create a JScrollPane to hold the text area
		JScrollPane scrollPane = new JScrollPane(jtaDescription);
		//set lineWrap and wrapStyleWord to true for the text area
		setLayout(new BorderLayout(5,5));
		add(scrollPane, BorderLayout.CENTER);
		add(jlblImageTitle, BorderLayout.WEST);
	}
	//Set the title
	public void setTitle(String title){
		jlblImageTitle.setText(title);
	}
	//Set the image icon
	public void setImageIcon(ImageIcon icon){
		jlblImageTitle.setIcon(icon);
	}
	//Set the text description
	public void setDescription(String text){
		jtaDescription.setText(text);
	}
}

