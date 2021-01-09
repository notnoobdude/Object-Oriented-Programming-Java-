package LabExer2;
/*
 * FABRO, DAN NINO I.			BSCpE2A_C1					OOP LabExer
 */

import java.awt.Color;
import javax.swing.JFrame;
import LabExer2.ShowWithdraw;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class ShowWithdraw {

	private JFrame frmWithdraw;
	private JTextField withdrawInput;
	private JButton withdrawBtn;
	private static int idNum;
	private JLabel errorMsg;
	private JLabel lblEnterAmount;
	private JLabel lblAmount;
	private JButton btnBack;
	double withdrawnMoney;
	double wm;


	public static void execute(int idSet){
		idNum = idSet;												
		ShowWithdraw window = new ShowWithdraw();					//Instance of the own class is made
		window.frmWithdraw.setVisible(true);						//Basically, shows this frame
	}

	
	public ShowWithdraw() {
		initialize();
	}

	
	private void initialize() {
		frmWithdraw = new JFrame();
		frmWithdraw.getContentPane().setBackground(SystemColor.activeCaption);
		frmWithdraw.setTitle("WITHDRAW");									//Title for the window
		frmWithdraw.setBounds(100, 100, 448, 146);							//the size of the frame itself (x, y, width, height)
		frmWithdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//for the closing button on the upper right
		frmWithdraw.getContentPane().setLayout(null);						//this was done so that the frame and its contents can be manually done
		
		withdrawInput = new JTextField();								//Where the user will input how much he/she wants to withdraw
		withdrawInput.setBounds(99, 45, 165, 34);
		frmWithdraw.getContentPane().add(withdrawInput);
		withdrawInput.setColumns(10);
		
		withdrawBtn = new JButton("Withdraw");							//Whenever this button is clicked, the entered amount will be set as double and becomes an error
		withdrawBtn.addActionListener(new ActionListener(){				//whenever a non-numerical input is scanned. Then, the entered amount will be subtracted to the
			public void actionPerformed(ActionEvent e){					//user's current account balance and it'll be checked if it equates to the 'must-be-maintained'
				try{													//amount and if it does, an error will be prompted to the user. On the other hand, it'll prompt the
					withdrawnMoney = Double.parseDouble(withdrawInput.getText());		//user a successful transaction.
					wm = CoopTransaction.acct[idNum].accntBal - withdrawnMoney;	
					if(wm < LabExer2.SavingsAccount.MBAL)
					{														
						errorMsg.setText("Must at least maintain a balance of 500.00");	
						errorMsg.setVisible(true);					
					}
					else{
						CoopTransaction.acct[idNum].withdraw(withdrawnMoney);			
						errorMsg.setVisible(false);					
						JOptionPane.showMessageDialog(null, "You have withdrawn " + withdrawnMoney + " from your account!");	
						errorMsg.setText("Your Balance is: " + CoopTransaction.acct[idNum].accntBal);	//Here, the account balance is updated.
					}
					return;											//terminates the method
				}catch(Exception x){}
				errorMsg.setText("An error occured in your input");	
				errorMsg.setVisible(true);							
			}
		});
		withdrawBtn.setFont(new Font("AR DESTINE", Font.PLAIN, 12));
		withdrawBtn.setBounds(293, 45, 113, 34);
		frmWithdraw.getContentPane().add(withdrawBtn);
		
		errorMsg = new JLabel("*Input error.");							//Shows when the user has an input errors
		errorMsg.setForeground(Color.RED);								//Font color for the error
		errorMsg.setBounds(99, 80, 307, 16);							//Size
		frmWithdraw.getContentPane().add(errorMsg);						//Basically, the button is now a part of the window itself.
		errorMsg.setVisible(false);										//Hides the error message if login button's not yet clicked.
		
		lblEnterAmount = new JLabel("Enter");								//additional text
		lblEnterAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterAmount.setFont(new Font("Arial", Font.BOLD, 13));
		lblEnterAmount.setBounds(31, 45, 46, 14);
		frmWithdraw.getContentPane().add(lblEnterAmount);
		
		lblAmount = new JLabel("Amount:");									//additional text for enter amount
		lblAmount.setFont(new Font("Arial", Font.BOLD, 13));
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBounds(22, 65, 67, 14);
		frmWithdraw.getContentPane().add(lblAmount);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener(){					//Whenever this button is clicked, the window for the withdraw 
			public void actionPerformed(ActionEvent e){						//is actually executed and that the user's homepage stays put.
				frmWithdraw.setVisible(false);							
				UserHomepage.secondPage(idNum);								
			}
		});
		btnBack.setBounds(0, 0, 77, 23);
		frmWithdraw.getContentPane().add(btnBack);
	}

}
