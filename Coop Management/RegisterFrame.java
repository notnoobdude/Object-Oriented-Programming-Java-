package LabExer2;
/*
 * FABRO, DAN NINO I.			BSCpE2A_C1					OOP LabExer
 */

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;


public class RegisterFrame {

	private JFrame frmCrtAcct;
	private JTextField fieldPinInput;
	private JTextField fieldConPin;
	private JTextField fieldEnterName;
	private JTextField fieldEnterCode;
	private JTextField fieldConCode;
	private JTextField fieldMMName;
	private JButton createBtn;
	private JLabel errorMsg;
	private JLabel labelConfirmPin;
	private JLabel lblEnterCode;
	private JLabel lblEnterMothersMaiden;
	private JLabel labelEnterName;
	private JLabel labelConfirmCode;
	private JLabel lblEnter;
	private JLabel labelEnterPin;
	

	
	public static void execute(){											
		RegisterFrame window = new RegisterFrame();					//Instance of the own class is made
		window.frmCrtAcct.setVisible(true);							//Basically, shows this frame
	}

	
	public RegisterFrame() {
		initialize();
	}

	
	private void initialize() {
		frmCrtAcct = new JFrame();									//the backbone of the text fields, text labels, and buttons (the window)
		frmCrtAcct.setTitle("REGISTRATION");						//Title for the window
		frmCrtAcct.getContentPane().setBackground(SystemColor.activeCaption);		//serves as the background color
		frmCrtAcct.setBounds(100, 100, 507, 340);					//the size of the frame itself (x, y, width, height)
		frmCrtAcct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Close button on the upper right
		frmCrtAcct.getContentPane().setLayout(null);					//to easily manipulate the text fields, buttons, and alike
		
		labelEnterPin = new JLabel("Enter PIN:");						//Label PIN
		labelEnterPin.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEnterPin.setFont(new Font("Arial Black", Font.PLAIN, 14));
		labelEnterPin.setBounds(112, 11, 88, 25);
		frmCrtAcct.getContentPane().add(labelEnterPin);
		
		fieldPinInput = new JTextField();								//Where the user inputs his/her PIN
		fieldPinInput.setBounds(203, 9, 174, 30);
		frmCrtAcct.getContentPane().add(fieldPinInput);
		fieldPinInput.setColumns(10);
			
		labelConfirmPin = new JLabel("Confirm PIN:");							//Label for confirmation of PIN
		labelConfirmPin.setFont(new Font("Arial Black", Font.PLAIN, 14));
		labelConfirmPin.setHorizontalAlignment(SwingConstants.RIGHT);
		labelConfirmPin.setBounds(95, 47, 105, 25);
		frmCrtAcct.getContentPane().add(labelConfirmPin);
		
		fieldConPin = new JTextField();										//To assure that the user correctly entered his/her PIN
		fieldConPin.setBounds(203, 46, 174, 30);
		frmCrtAcct.getContentPane().add(fieldConPin);
		fieldConPin.setColumns(10);
		
		labelEnterName = new JLabel("Enter NAME:");							//Label for user's name input
		labelEnterName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelEnterName.setFont(new Font("Arial Black", Font.PLAIN, 14));
		labelEnterName.setBounds(95, 83, 105, 25);
		frmCrtAcct.getContentPane().add(labelEnterName);
		
		fieldEnterName = new JTextField();										//Where the user inputs his/her name
		fieldEnterName.setBounds(203, 82, 174, 30);
		frmCrtAcct.getContentPane().add(fieldEnterName);
		fieldEnterName.setColumns(10);
		
		lblEnterCode = new JLabel("Enter CODE:");								//Label for the input code
		lblEnterCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterCode.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEnterCode.setBounds(95, 119, 105, 25);
		frmCrtAcct.getContentPane().add(lblEnterCode);
		
		fieldEnterCode = new JTextField();										//Where the user enters his/her code
		fieldEnterCode.setBounds(203, 119, 174, 30);
		frmCrtAcct.getContentPane().add(fieldEnterCode);
		fieldEnterCode.setColumns(10);
		
		labelConfirmCode = new JLabel("Confirm CODE:");							//Label for confirmation of code
		labelConfirmCode.setHorizontalAlignment(SwingConstants.RIGHT);
		labelConfirmCode.setFont(new Font("Arial Black", Font.PLAIN, 14));
		labelConfirmCode.setBounds(71, 155, 129, 25);
		frmCrtAcct.getContentPane().add(labelConfirmCode);
		
		fieldConCode = new JTextField();										//To assure that the user correctly entered his/her PIN
		fieldConCode.setBounds(203, 155, 174, 30);
		frmCrtAcct.getContentPane().add(fieldConCode);
		fieldConCode.setColumns(10);
		
		lblEnterMothersMaiden = new JLabel("MOTHER'S MAIDEN NAME:");					//Label for input of mother's maiden name
		lblEnterMothersMaiden.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterMothersMaiden.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblEnterMothersMaiden.setBounds(26, 196, 174, 25);
		frmCrtAcct.getContentPane().add(lblEnterMothersMaiden);
		
		lblEnter = new JLabel("Enter");											//additional text
		lblEnter.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnter.setBounds(95, 191, 46, 14);
		frmCrtAcct.getContentPane().add(lblEnter);
		
		fieldMMName = new JTextField();										//Where the user enters his/her mother's maiden name
		fieldMMName.setBounds(203, 191, 174, 30);
		frmCrtAcct.getContentPane().add(fieldMMName);
		fieldMMName.setColumns(10);
		
		createBtn = new JButton("CREATE");
		createBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){							//Once this button is clicked, 
				String codeInput, pinInput, num;
				pinInput = fieldPinInput.getText();
				codeInput = fieldEnterCode.getText();
				inputcheck();													//Checks the text fields if there are any values and if none, the label is colored red.
				if(scan()){												//condition method will return a boolean value								
					CoopTransaction.numAccnt++;											//increments the numAccnt in the CoopTransaction class
					num = Integer.toString(CoopTransaction.numAccnt);					
					CoopTransaction.acct = (LabExer2.SavingsAccount[]) Arrays.copyOf(CoopTransaction.acct, CoopTransaction.acct.length+1);	//Increases the array size and passes the values to the newly increased size of array
					CoopTransaction.acct[CoopTransaction.numAccnt-1] = new LabExer2.SavingsAccount(fieldEnterName.getText(), num, pinInput, codeInput, fieldMMName.getText()); //The information entered by the user is initialized.
					errorMsg.setVisible(false);									//Error message is hidden if visible.
					JOptionPane.showMessageDialog(null, "Your account was successfully created!");	//This dialog box will occur if the flow runs smoothly
					frmCrtAcct.setVisible(false);									//Closes the Registration frame and the user is directed back to the login frame
					PageLogin.firstPage();											
				}
				else{												//This will occur when the returned value is false.					
					if(!errorMsg.isVisible())
					{									
						errorMsg.setVisible(true);								
					}
				}
			}
			
			public boolean scan(){									//This method, which is initialized at zero, scans each text fields which
				int i = 0;											//If a field is empty, then i is incremented, however, if every field has			
				if(fieldPinInput.getText().equals(""))				//values in it, i == 0, hence, the if statement above is executed and stores
				{													//all the information to their designated fields/variables.
					i++;							
				}
				else if(fieldEnterCode.getText().equals(""))
				{
					i++;							
				}
				else if(fieldConPin.getText().equals(""))
				{
					i++;
				}
				else if(fieldConCode.getText().equals(""))
				{
					i++;
				}
				else if(fieldEnterName.getText().equals(""))
				{
					i++;
				}
				else if(fieldMMName.getText().equals(""))
				{
					i++;
				}
				if(i == 0)
				{														
					return true;
				}
				else{
					return false;
				}
			}
			
			public void inputcheck(){		//this will turn the label of fields to color red if no input inside the fields
				fpCheck();					//calls out method fpCheck()
				cpCheck();					//calls out method cpCheck()
				cfpCheck();					//calls out method cfpCheck()
				cfcCheck();					//calls out method cfcCheck()
				nfCheck();					//calls out method nfCheck()
				mmnCheck();					//calls out method mmnCheck()
			}
			
			public void fpCheck(){
				if(fieldPinInput.getText().equals("")){								
					if(labelEnterPin.getForeground()!=Color.RED){						
						labelEnterPin.setForeground(Color.RED);						
					}
				}
				else{															
					if(labelEnterPin.getForeground()!=Color.DARK_GRAY){				
						labelEnterPin.setForeground(Color.DARK_GRAY);					
					}
				}	
			}
			
			
			public void cpCheck(){
				if(fieldEnterCode.getText().equals("")){
					if(lblEnterCode.getForeground()!=Color.RED){
						lblEnterCode.setForeground(Color.RED);
					}
				}else{
					if(lblEnterCode.getForeground()!=Color.DARK_GRAY){
						lblEnterCode.setForeground(Color.DARK_GRAY);
					}
				}
			}
			
			public void cfpCheck(){
				if(fieldConPin.getText().equals("")){
					if(labelConfirmPin.getForeground()!=Color.RED){
						labelConfirmPin.setForeground(Color.RED);
					}
				}
				else{
					if(labelConfirmPin.getForeground()!=Color.DARK_GRAY){
						labelConfirmPin.setForeground(Color.DARK_GRAY);
					}
				}
			}
			
			public void cfcCheck(){
				if(fieldConCode.getText().equals("")){
					if(labelConfirmCode.getForeground()!=Color.RED){
						labelConfirmCode.setForeground(Color.RED);
					}
				}else{
					if(labelConfirmCode.getForeground()!=Color.DARK_GRAY){
						labelConfirmCode.setForeground(Color.DARK_GRAY);
					}
				}
			}
			
			public void nfCheck(){
				if(fieldEnterName.getText().equals("")){
					if(labelEnterName.getForeground()!=Color.RED){
						labelEnterName.setForeground(Color.RED);
					}
				}
				else{
					if(labelEnterName.getForeground()!=Color.DARK_GRAY){
						labelEnterName.setForeground(Color.DARK_GRAY);
					}
				}
			}
			
			public void mmnCheck(){
				if(fieldMMName.getText().equals("")){
					if(lblEnterMothersMaiden.getForeground()!=Color.RED){
						lblEnterMothersMaiden.setForeground(Color.RED);
					}
				}
				else{
					if(lblEnterMothersMaiden.getForeground()!=Color.DARK_GRAY){
					   lblEnterMothersMaiden.setForeground(Color.DARK_GRAY);
					}
				}
			}
		});
		createBtn.setFont(new Font("AR DESTINE", Font.PLAIN, 15));
		createBtn.setBounds(192, 232, 105, 30);
		frmCrtAcct.getContentPane().add(createBtn);
		
		errorMsg = new JLabel("Please fill up all correctly.");		//Shows when the user has an input errors
		errorMsg.setForeground(Color.RED);								//Font color for the error
		errorMsg.setBounds(313, 223, 168, 16);							//Size
		frmCrtAcct.getContentPane().add(errorMsg);					//Basically, the button is now a part of the window itself.
		errorMsg.setVisible(false);	
		
		JLabel lblEnteredInformationHere = new JLabel("Entered information here should be kept in private.");
		lblEnteredInformationHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnteredInformationHere.setBounds(181, 259, 310, 42);
		frmCrtAcct.getContentPane().add(lblEnteredInformationHere);
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrtAcct.setVisible(false);										//this will make the whole window to close (but data is still in the ram)
				PageLogin.firstPage();												//start the GUI of the loginGUI
			}
		});
		loginBtn.setFont(new Font("AR DESTINE", Font.PLAIN, 15));
		loginBtn.setBounds(10, 254, 88, 36);
		frmCrtAcct.getContentPane().add(loginBtn);
	}
}
