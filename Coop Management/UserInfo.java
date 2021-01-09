package LabExer2;
/*
 * FABRO, DAN NINO I.			BSCpE2A_C1					OOP LabExer
 */


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;


public class UserInfo {

	private JFrame frmUserInfo;
	private static int idNum;
	private JLabel labelID;
	private JLabel labelName;
	private JLabel labelAcctBalance;
	private JLabel labelCode;
	private JLabel lblMothersMaidenName;
	private JLabel labelPIN;
	private JButton btnShowPin;
	private JPasswordField fieldCode;
	private JPasswordField fieldMMname;
	private JLabel errorMsg;
	private JLabel lblInputCodeAnd;
	private JButton btnBack;
	private JLabel labelUserID;
	private JLabel labelUserName;
	private JLabel labelAcctBal;

	
	public static void thirdPage(int idSet){
		idNum = idSet;												
		UserInfo window = new UserInfo();					//Instance of the own class is made
		window.frmUserInfo.setVisible(true);				//Basically, shows this frame
	}

	
	public UserInfo() {
		initialize();							//calls initialize() so that the text fields, buttons, and text labels are executed.
	}

	
	private void initialize() {
		frmUserInfo = new JFrame();
		frmUserInfo.getContentPane().setBackground(SystemColor.activeCaption);		//Background color
		frmUserInfo.setBounds(100, 100, 469, 347);									//set the frame size (x, y, width, height)
		frmUserInfo.setTitle("ACCOUNT INFORMATION");								//frame title
		frmUserInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					//Close button on the upper right
		frmUserInfo.getContentPane().setLayout(null);								//to easily manipulate the text fields, buttons, and alike
		
		labelID = new JLabel("ID:");									//ID label
		labelID.setFont(new Font("Arial Black", Font.PLAIN, 15));		//Font style and size used
		labelID.setHorizontalAlignment(SwingConstants.RIGHT);			//Position
		labelID.setBounds(142, 24, 49, 30); 							//Size
		frmUserInfo.getContentPane().add(labelID);						//Basically, the button is now a part of the window itself
		
		labelName = new JLabel("NAME:");								//Label for the user's name
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);			//Position
		labelName.setFont(new Font("Arial Black", Font.PLAIN, 15));		//Font style and size used
		labelName.setBounds(124, 65, 67, 30);							//Size
		frmUserInfo.getContentPane().add(labelName);					//Basically, the button is now a part of the window itself
		
		labelAcctBalance = new JLabel("ACCT. BALANCE:");					//Label for the user's current account balance
		labelAcctBalance.setFont(new Font("Arial Black", Font.PLAIN, 13));	//Font style and size used
		labelAcctBalance.setHorizontalAlignment(SwingConstants.RIGHT);		//Position
		labelAcctBalance.setBounds(49, 106, 142, 30);						//Size
		frmUserInfo.getContentPane().add(labelAcctBalance);					//Basically, the button is now a part of the window itself
			
		labelCode = new JLabel("CODE:");									//Label for user's code
		labelCode.setFont(new Font("Arial Black", Font.PLAIN, 15));			//Font style and size used
		labelCode.setHorizontalAlignment(SwingConstants.RIGHT);				//Position
		labelCode.setBounds(133, 155, 58, 22);								//Size
		frmUserInfo.getContentPane().add(labelCode);						//Basically, the button is now a part of the window itself
		
		lblMothersMaidenName = new JLabel("MOTHER'S MAIDEN NAME:");					//Label for the mother's maiden name of the user
		lblMothersMaidenName.setFont(new Font("Arial Black", Font.PLAIN, 12));		//Font style and size used
		lblMothersMaidenName.setHorizontalAlignment(SwingConstants.RIGHT);			//Position
		lblMothersMaidenName.setBounds(12, 188, 179, 30);							//Size
		frmUserInfo.getContentPane().add(lblMothersMaidenName);						//Basically, the button is now a part of the window itself
		
		labelPIN = new JLabel("PIN:");										//Label for PIN
		labelPIN.setFont(new Font("Arial Black", Font.PLAIN, 15));			//Font style and size used
		labelPIN.setHorizontalAlignment(SwingConstants.RIGHT);				//Position
		labelPIN.setBounds(145, 229, 46, 14);								//Size
		frmUserInfo.getContentPane().add(labelPIN);							//Basically, the button is now a part of the window itself
		
		btnShowPin = new JButton("SHOW PIN");			
		btnShowPin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				inputcheck();													//check the fields if empty then make their label color red
				String mmnameInput, codeInput, pinInput;
				codeInput = String.valueOf(fieldCode.getPassword());				//The input inside the entered code itself is converted as String type and stored into codeInput
				mmnameInput = String.valueOf(fieldMMname.getPassword());			//The input inside mother's maiden name itself is converted as String type and stored into mmnameInput
				pinInput = CoopTransaction.acct[idNum].showPin(codeInput, mmnameInput);		//SavingsAccount class is called indirectly via CoopTransaction and with that showPin is passed with the 
				if(!pinInput.equals(""))													//values codeInput and mmnameInput																						
				{																//If the assigned value for pinInput is not empty, then errorMsg is updated 
					errorMsg.setText(pinInput);									//pinInput will be shown
					errorMsg.setForeground(Color.DARK_GRAY);					//This was done so that the pinInput will not display an error-like color
					errorMsg.setVisible(true);									//visibility
				}
				else{
					errorMsg.setText("*Invalid input");							//However, this is displayed when codeInput and mmnameInput is not done correctly.
					errorMsg.setForeground(Color.RED);							
					errorMsg.setVisible(true);									
				}
			}
			
			public void inputcheck(){
				fpCheck();					//calls out method cpCheck()
				cpCheck();					//calls out method fpCheck()
			}
			
			
			public void cpCheck(){											//This method scans if Code text box contains any characters
				if(String.valueOf(fieldCode.getPassword()).equals(""))		//and if its empty, then it'll be checked if it's red
				{															//and if it's not red, then it'll be changed to red.
					if(labelCode.getForeground()!=Color.RED)				//However, if fieldPin contains characters, it'll be checked
					{														//if it's already dark gray and if it's not, then it'll be
						labelCode.setForeground(Color.RED);					//changed to dark gray.
					}
				}
				else{
					if(labelCode.getForeground()!=Color.DARK_GRAY)
					{
						labelCode.setForeground(Color.DARK_GRAY);
					}
				}
			}
			
			
			public void fpCheck(){											//This method scans if mother's maiden name text box contains any characters
				if(String.valueOf(fieldMMname.getPassword()).equals(""))	//and if its empty, then it'll be checked if it's red																	
				{															//and if it's not red, then it'll be changed to red.
					if(lblMothersMaidenName.getForeground()!=Color.RED)		//However, if fieldMMname contains characters, it'll be checked
					{														//if it's already dark gray and if it's not, then it'll be
						lblMothersMaidenName.setForeground(Color.RED);		//changed to dark gray.
					}
				}
				else{												
					if(lblMothersMaidenName.getForeground()!=Color.DARK_GRAY)					
					{													
						lblMothersMaidenName.setForeground(Color.DARK_GRAY);		
					}													
				}														
			}												
		});
		btnShowPin.setFont(new Font("AR DESTINE", Font.PLAIN, 12));
		btnShowPin.setBounds(155, 254, 99, 30);
		frmUserInfo.getContentPane().add(btnShowPin);
		
		errorMsg = new JLabel("Either of the inputs is wrong.");		//Shows when the user has an input errors
		errorMsg.setForeground(Color.RED);								//Font color for the error
		errorMsg.setBounds(192, 230, 168, 16);							//Size
		frmUserInfo.getContentPane().add(errorMsg);						//Basically, the button is now a part of the window itself.
		errorMsg.setVisible(false);										//Hides the error message if login button's not yet clicked.
		
		fieldCode = new JPasswordField();								//Where the user enters the code
		fieldCode.setBounds(192, 148, 151, 30);							//Size
		frmUserInfo.getContentPane().add(fieldCode);					//Basically, the button is now a part of the window itself
		
		fieldMMname = new JPasswordField();								//Where the users enters the mother's maiden name
		fieldMMname.setBounds(192, 189, 151, 30);						//Size
		frmUserInfo.getContentPane().add(fieldMMname);					//Basically, the button is now a part of the window itself
		
		lblInputCodeAnd = new JLabel("Input code and mother's maiden name to show PIN.");		//Prompts the user to input both code and
		lblInputCodeAnd.setHorizontalAlignment(SwingConstants.CENTER);							//and MMName to show PIN
		lblInputCodeAnd.setBounds(22, 128, 431, 22);						//Size	
		frmUserInfo.getContentPane().add(lblInputCodeAnd);					//Basically, the button is now a part of the window itself
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){							//Whenever the back button is clicked, the current window will be
				frmUserInfo.setVisible(false);									//be closed, and the user is directed back to the homepage
				UserHomepage.secondPage(idNum);											
			}
		});
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 11));				//Button text's font style and size
		btnBack.setBounds(0, 0, 67, 30);										//Size
		frmUserInfo.getContentPane().add(btnBack);								//Basically, the button is now a part of the window itself
		
		labelUserID = new JLabel(CoopTransaction.acct[idNum].accntNo);			//Displays the user's ID
		labelUserID.setBounds(201, 26, 151, 30);								//Size
		frmUserInfo.getContentPane().add(labelUserID);							//Basically, the button is now a part of the window itself
		
		labelUserName = new JLabel(CoopTransaction.acct[idNum].accntName);		//Displays the user's name
		labelUserName.setBounds(201, 67, 142, 30);								//Size
		frmUserInfo.getContentPane().add(labelUserName);						//Basically, the button is now a part of the window itself
		
		labelAcctBal = new JLabel(Double.toString(CoopTransaction.acct[idNum].accntBal));			//Displays the user's current account balance.
		labelAcctBal.setBounds(201, 116, 46, 14);													//Size
		frmUserInfo.getContentPane().add(labelAcctBal);												//Basically, the button is now a part of the window itself
		
		
		
	}
}
