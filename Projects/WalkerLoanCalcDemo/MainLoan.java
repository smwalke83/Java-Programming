// Programmer: Scott Walker
// Email: swalker62@student.cnm.edu
// Project: Loan Calculator Demo

import javax.swing.JFrame;

public class MainLoan {
	
	// main function, creates the loan calculator and sets title, size, centering, and close defaults
	public static void main(String[] args) {
		LoanCalculator frame = new LoanCalculator();
		frame.setTitle("Loan Calculator");
		frame.setSize(375, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}