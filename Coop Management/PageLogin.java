package CoopManagement;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import LabExer2.PageLogin;
import LabExer2.CoopTransaction;
import LabExer2.UserHomepage;

public class PageLogin {

	private JFrame frmCoopLogin;
	private JPasswordField fieldPin;
	private JPasswordField fieldPass;
	private JLabel errorMsg;
	private JLabel labelPin;
	private JLabel labelCode;
	private JButton loginBtn;
	private JButton crAccBtn;
	
	public static void firstPage(){
		PageLogin window = new PageLogin();			//instantiated this class as instance for the frame
		window.frmCoopLogin.setVisible(true);			//setting the visibility of this window
	}

	public PageLogin() {
		initialize();					//calls initialize() so that the text fields, buttons, and text labels are executed
	}
	
	private void initialize() {
		frmCoopLogin = new JFrame();					//the backbone of the text fields, text labels, and buttons (the window)
		frmCoopLogin.getContentPane().setBackground(SystemColor.activeCaption); //serves as the background color
		frmCoopLogin.setFont(new Font("AR DESTINE", Font.BOLD, 17));		//font size = 17, font style = AR DESTINE and is bold
		frmCoopLogin.setForeground(Color.LIGHT_GRAY);						//Foreground set to light gray
		frmCoopLogin.setTitle("COOP LOGIN");								//Title for the window
		frmCoopLogin.setBounds(100, 100, 397, 332);							//the size of the frame itself (x, y, width, height)
		frmCoopLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//for the closing button on the upper right
		frmCoopLogin.getContentPane().setLayout(null);						//this was done so that the frame and its contents can be manually made
		
		loginBtn = new JButton("Login");					//If this login button is clicked, all the implementations will be executed
		loginBtn.addActionListener(new ActionListener(){			 //via ActionListener itself
			public void actionPerformed(ActionEvent e){
				String pinInput, codeInput;
				int x;
				pinInput = String.valueOf(fieldPin.getPassword());		//The input inside PIN itself is converted as String type and stored into pinInput
				codeInput = String.valueOf(fieldPass.getPassword());	//The input inside Code itself is converted as String type and stored into codeInput
				inputcheck();											//execute inputcheck() method
				for(x = 0; x < CoopTransaction.numAccnt; x++){			//Is initialized at 0 having a condition set limited to the number of created accounts and is incremented.
					if((CoopTransaction.acct[x].scanCode(codeInput)) && (CoopTransaction.acct[x].scanPin(pinInput)))	//Whenever both PIN and Code are right, then the user is
					{																									//directed to his/her own account's homepage.
						frmCoopLogin.setVisible(false);					//This window is closed whenever the user inputs the PIN and code correctly
						UserHomepage.secondPage(x);								//After that, the user's homepage will be shown.
					}
				}
				if(!errorMsg.isVisible())
				{													//then check if error msg is visible
					errorMsg.setVisible(true);						//if not visible then make visible
				}
			}
			
			public void inputcheck(){
				fpCheck();					//calls out method fpCheck()
				cpCheck();					//calls out method cpCheck()
			}
			
			
			public void cpCheck(){											//This method scans if Code text box contains any characters
				if(String.valueOf(fieldPass.getPassword()).equals(""))		//and if its empty, then it'll be checked if it's red
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
			
			
			public void fpCheck(){										//This method scans if Pin text box contains any characters
				if(String.valueOf(fieldPin.getPassword()).equals(""))	//and if its empty, then it'll be checked if it's red																	
				{														//and if it's not red, then it'll be changed to red.
					if(labelPin.getForeground()!=Color.RED)				//However, if fieldPin contains characters, it'll be checked
					{													//if it's already dark gray and if it's not, then it'll be
						labelPin.setForeground(Color.RED);				//changed to dark gray.
					}
				}
				else{												
					if(labelPin.getForeground()!=Color.DARK_GRAY)					
					{													
						labelPin.setForeground(Color.DARK_GRAY);		
					}													
				}														
			}														
		});
		loginBtn.setBackground(UIManager.getColor("Button.shadow"));			//Login button's texture
		loginBtn.setFont(new Font("AR DESTINE", Font.BOLD, 16));				//Login button's font style = AR DESTINE, font size 16 and is set to bold
		loginBtn.setBounds(139, 193, 101, 32);									//Login button's size
		frmCoopLogin.getContentPane().add(loginBtn, BorderLayout.SOUTH);		//Basically, the button is now a part of the window itself
		
		errorMsg = new JLabel("Either of the inputs is wrong.");		//Shows when the user has an input errors
		errorMsg.setForeground(Color.RED);								//Font color for the error
		errorMsg.setBounds(125, 166, 168, 16);							//Size
		frmCoopLogin.getContentPane().add(errorMsg);					//Basically, the button is now a part of the window itself.
		errorMsg.setVisible(false);										//Hides the error message if login button's not yet clicked.
		
		crAccBtn = new JButton("Register");			//Create account button
		crAccBtn.addActionListener(new ActionListener(){					//Whenever this button is clicked, the window for the creation of an account 
			public void actionPerformed(ActionEvent e){						//is actually executed, but before that, this login window is then closed.
				frmCoopLogin.setVisible(false);							
				RegisterFrame.execute();								
			}
		});
		crAccBtn.setBackground(UIManager.getColor("Button.shadow"));		//Adds a 3D effect to the button's texture
		crAccBtn.setFont(new Font("AR JULIAN", Font.BOLD, 13));				//This button's font style = AR JULIAN, font size = 13 and is bold
		crAccBtn.setBounds(127, 246, 127, 23);								//Register button's size
		frmCoopLogin.getContentPane().add(crAccBtn);						//Basically, the button is now a part of the window itself.
		
		labelPin = new JLabel("PIN:");										//Pin label itself
		labelPin.setHorizontalAlignment(SwingConstants.RIGHT);				//Refers to what part this label is placed horizontally
		labelPin.setAlignmentX(Label.RIGHT);								//Refers to what part this label is placed vertically
		labelPin.setFont(new Font("Agency FB", Font.BOLD, 18));				//Pin label's font style and size
		labelPin.setBounds(88, 65, 44, 29);									//The label's size inside the window
		frmCoopLogin.getContentPane().add(labelPin);						//Basically, the button is now a part of the window itself.
		
		fieldPin = new JPasswordField();										//The part where the PIN is entered
		fieldPin.setForeground(UIManager.getColor("TextField.darkShadow"));		//Adds a 3D effect to the text box
		fieldPin.setHorizontalAlignment(SwingConstants.LEFT);					//The text box's position
		fieldPin.setBounds(142, 62, 151, 32);									//Text box size
		frmCoopLogin.getContentPane().add(fieldPin);							//Basically, the button is now a part of the window itself.
		fieldPin.setColumns(10);
		
		fieldPass = new JPasswordField();										//The part where the Code is entered
		fieldPass.setForeground(UIManager.getColor("TextField.darkShadow"));	//Adds a 3D effect to the text box
		fieldPass.setBounds(142, 122, 151, 32);									//Text box size
		frmCoopLogin.getContentPane().add(fieldPass);							//Basically, the button is now a part of the window itself.
		fieldPass.setColumns(10);
		
		labelCode = new JLabel("Code:");										//Code label itself
		labelCode.setHorizontalAlignment(SwingConstants.RIGHT);					//Refers to what part this label is placed horizontally
		labelCode.setFont(new Font("Agency FB", Font.BOLD, 18));				//This button's font style = AR JULIAN, font size = 18 and is bold
		labelCode.setAlignmentX(Label.RIGHT);									//Refers to what part this label is placed vertically
		labelCode.setBounds(61, 122, 71, 32);									//Code label's font style and size
		frmCoopLogin.getContentPane().add(labelCode);							//Basically, the button is now a part of the window itself.
}
}
