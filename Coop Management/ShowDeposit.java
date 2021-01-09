package LabExer2;

/*
 * FABRO, DAN NINO I.			BSCpE2A_C1					OOP LabExer
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ShowDeposit {

	private JFrame frmDeposit;
	private static int idNum;
	private JLabel errorMsg;
	private JLabel lblEnterAmount;
	private JLabel lblAmount;
	private JTextField depositInput;
	private JLabel balanceLabel;
	private JButton depositBtn;
	private JButton btnBack;
	double depositMoney;
	
	public static void execute(int idSet){
		idNum = idSet;												
		ShowDeposit window = new ShowDeposit();					//instantiated this class as instance for the frame
		window.frmDeposit.setVisible(true);						//setting the visibility of this window
	}

	
	public ShowDeposit() {
		initialize();								//calls initialize() so that the text fields, buttons, and text labels are executed
	}

	
	private void initialize() {
		frmDeposit = new JFrame();									//the backbone of the text fields, text labels, and buttons (the window)
		frmDeposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//for the closing button on the upper right
		frmDeposit.getContentPane().setBackground(SystemColor.activeCaption); //serves as the background color				
		frmDeposit.setTitle("DEPOSIT");									//Title for the window
		frmDeposit.setBounds(100, 100, 448, 146);						//the size of the frame itself (x, y, width, height)
		frmDeposit.getContentPane().setLayout(null);					//this was done so that the frame and its contents can be manually made
		
		depositInput = new JTextField();							//Where the user enters how much does he/she wants to be added to his/her account
		depositInput.setBounds(99, 45, 165, 34);
		frmDeposit.getContentPane().add(depositInput);
		depositInput.setColumns(10);
		
		depositBtn = new JButton("Deposit");						//Whenever this button is clicked, the desired amount to be deposited will be set as double so any non-numerical
		depositBtn.addActionListener(new ActionListener(){			//input will display an error. When the input is valid enough, it will added into the current account balance
			public void actionPerformed(ActionEvent e){				//and eventually a message will popup prompting the user that a successful transaction occurred and the balance
				try{												//will then be updated.
					depositMoney = Double.parseDouble(depositInput.getText());	
					CoopTransaction.acct[idNum].deposit(depositMoney);				
					errorMsg.setVisible(false);						
					JOptionPane.showMessageDialog(null,"You successfully added " + depositMoney + " to your account.");	
					balanceLabel.setText("Your Balance is: " + CoopTransaction.acct[idNum].accntBal);	
					return;											//terminates the method
				}catch(Exception x){}
				errorMsg.setText("An error occured in your input");	
				errorMsg.setVisible(true);								
			}
		});
		depositBtn.setFont(new Font("AR DESTINE", Font.PLAIN, 12));
		depositBtn.setBounds(293, 45, 113, 34);
		frmDeposit.getContentPane().add(depositBtn);
		
		errorMsg = new JLabel("Either of the inputs is wrong.");		//Shows when the user has an input errors
		errorMsg.setForeground(Color.RED);								//Font color for the error
		errorMsg.setBounds(125, 166, 168, 16);							//Size
		frmDeposit.getContentPane().add(errorMsg);						//Basically, the button is now a part of the window itself.
		errorMsg.setVisible(false);										//Hides the error message if login button's not yet clicked.
		
		lblEnterAmount = new JLabel("Enter");							//additional label text
		lblEnterAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterAmount.setFont(new Font("Arial", Font.BOLD, 13));
		lblEnterAmount.setBounds(31, 45, 46, 14);						//Size
		frmDeposit.getContentPane().add(lblEnterAmount);
		
		lblAmount = new JLabel("Amount:");								//additional label text
		lblAmount.setFont(new Font("Arial", Font.BOLD, 13));
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBounds(22, 65, 67, 14);
		frmDeposit.getContentPane().add(lblAmount);
		
		balanceLabel = new JLabel("Hello! Your current balance is " + CoopTransaction.acct[idNum].accntBal);	//Updated whenever a change of balance occurs
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);				//Position
		balanceLabel.setBounds(99, 11, 292, 23);								//Size
		frmDeposit.getContentPane().add(balanceLabel);							
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener(){						//Whenever this button is clicked, the user is directed back 
			public void actionPerformed(ActionEvent e){						//to the his/her account's homepage. This frame will then be
				frmDeposit.setVisible(false);								//closed.
				UserHomepage.secondPage(idNum);								
			}
		});
		btnBack.setBounds(0, 0, 77, 23);
		frmDeposit.getContentPane().add(btnBack);
		
		
	}

}
