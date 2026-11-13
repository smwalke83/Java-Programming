// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Project: Loan Calculator Demo

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.text.*;

// LoanCalculator class, inherits from JFrame
public class LoanCalculator extends JFrame {
	
	// Text fields for the loan calulator, a button to calculate the loan, and a formatter to display results as currency
	private JTextField jtfAnnualInterestRate;
	private JTextField jtfNumberOfYears;
	private JTextField jtfLoanAmount;
	private JTextField jtfMonthlyPayment;
	private JTextField jtfTotalPayment;
	private JButton jbtComputeLoan;
	private NumberFormat currencyFormatter;
	
	// constructor, initializes each field and the formatter, and adds an action listener to the button
	public LoanCalculator() {
		initComponents();
		currencyFormatter = NumberFormat.getCurrencyInstance();
		jbtComputeLoan.addActionListener(new ButtonListener());
	}
	
	// initializes components, called in constructor
	private void initComponents() {
		
		// creates each text field and the button (with colors)
		jtfAnnualInterestRate = new JTextField();
		jtfNumberOfYears = new JTextField();
		jtfLoanAmount = new JTextField();
		jtfMonthlyPayment = new JTextField();
		jtfTotalPayment = new JTextField();
		jbtComputeLoan = new JButton("Compute Payment");
		Color newColor = new Color(225, 100, 50);
		jbtComputeLoan.setBackground(newColor);
		jbtComputeLoan.setForeground(Color.WHITE);
		
		// creates a panel for the text fields, and creates a label for each one in a 2 x 5 grid layout
		JPanel p1 = new JPanel(new GridLayout(5, 2));
		p1.add(new JLabel("Annual Interest Rate"));
		p1.add(jtfAnnualInterestRate);
		p1.add(new JLabel("Number of Years"));
		p1.add(jtfNumberOfYears);
		p1.add(new JLabel("Loan Amount"));
		p1.add(jtfLoanAmount);
		p1.add(new JLabel("Monthly Payment"));
		p1.add(jtfMonthlyPayment);
		p1.add(new JLabel("Total Payment"));
		p1.add(jtfTotalPayment);
		
		// adds a titled border with custom font to the panel
		TitledBorder newTB = new TitledBorder("Enter loan amount, interest rate, and years");
		Font myFont = new Font("Serif", Font.BOLD + Font.ITALIC, 18);
		newTB.setTitleFont(myFont);
		p1.setBorder(newTB);
		
		// adds another panel for the compute loan button, which will be right justified in the panel
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtComputeLoan);
		
		// adds the panels to the main window
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
	}
	
	// button listener inner class
	private class ButtonListener implements ActionListener {
		// overriding the actionPerformed method to get user inputs, calculate loan amounts, and display them to the user. I added very basic try/catch verification
		@Override
		public void actionPerformed(ActionEvent e) {
			double interest;
			int year;
			double loanAmount;
			try {
				interest = Double.parseDouble(jtfAnnualInterestRate.getText());
				year = Integer.parseInt(jtfNumberOfYears.getText());
				loanAmount = Double.parseDouble(jtfLoanAmount.getText());
			}
			catch (Exception) {
				interest = 0;
				year = 0;
				loanAmount = 0;
			}
			
			Loan loan = new Loan(interest, year, loanAmount);
			
			jtfMonthlyPayment.setText(currencyFormatter.format(loan.getMonthlyPayment()));
			jtfTotalPayment.setText(currencyFormatter.format(loan.getTotalPayment()));
		}
	}
}