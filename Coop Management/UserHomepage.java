package LabExer2;
/*
 * FABRO, DAN NINO I.			BSCpE2A_C1					OOP LabExer
 */

import javax.swing.JFrame;
import LabExer2.UserHomepage;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;


public class UserHomepage {

	private JFrame frmHome;
	private static int idNum;
	private JButton withdrawBtn;
	private JButton depositBtn;
	private JButton displayBtn;
	private JButton logoutBtn;
	private JLabel userLabel;
	
	public static void secondPage(int idSet){
		idNum = idSet;												
		UserHomepage window = new UserHomepage();					//Instance of the own class is made
		window.frmHome.setVisible(true);							//Basically, shows this frame
	}

	
	public UserHomepage() {
		initialize();								//calls initialize() so that the text fields, buttons, and text labels are executed.
	}

	
	private void initialize() {
		frmHome = new JFrame();													//the backbone of the text fields, text labels, and buttons (the window)
		frmHome.getContentPane().setBackground(SystemColor.activeCaption);		//serves as the background color
		frmHome.setBounds(100, 100, 397, 332);									//the size of the frame itself (x, y, width, height)
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					//for the closing button on the upper right
		frmHome.setTitle("HOMEPAGE");											//Title for the window
		frmHome.getContentPane().setLayout(null);								//this was done so that the frame and its contents can be manually done
		
		withdrawBtn = new JButton("WITHDRAW");
		withdrawBtn.addActionListener(new ActionListener(){					//Whenever this button is clicked, the window for the withdraw 
			public void actionPerformed(ActionEvent e){						//is actually executed and that the user's homepage stays put.
				frmHome.setVisible(true);							
				ShowWithdraw.execute(idNum);								
			}
		});
		withdrawBtn.setFont(new Font("AR DESTINE", Font.PLAIN, 15));
		withdrawBtn.setBounds(30, 156, 129, 58);
		frmHome.getContentPane().add(withdrawBtn);
		
		depositBtn = new JButton("DEPOSIT");
		depositBtn.addActionListener(new ActionListener(){					//Whenever this button is clicked, the window for the deposit
			public void actionPerformed(ActionEvent e){						//is actually executed and that the user's homepage stays put.
				frmHome.setVisible(true);							
				ShowDeposit.execute(idNum);								
			}
		});
		depositBtn.setFont(new Font("AR DESTINE", Font.PLAIN, 15));
		depositBtn.setBounds(30, 64, 129, 58);
		frmHome.getContentPane().add(depositBtn);
		
		displayBtn = new JButton("SHOW ACCT INFO.");				//Button name
		displayBtn.addActionListener(new ActionListener(){			//Whenever this button is clicked, the user is directed into his/her
			public void actionPerformed(ActionEvent e){				//info page where he/she entered inside registration window.
				frmHome.setVisible(false);							
				UserInfo.thirdPage(idNum);								
			}
		});
		displayBtn.setFont(new Font("AR DESTINE", Font.PLAIN, 11));		//Button text's font style and size
		displayBtn.setBounds(222, 65, 129, 58);							//Button size
		frmHome.getContentPane().add(displayBtn);						//Basically, the button is now a part of the window itself
		
		logoutBtn = new JButton("LOGOUT");
		logoutBtn.addActionListener(new ActionListener() {			//Whenever the logout button is clicked, the user's homepage is closed
			public void actionPerformed(ActionEvent e) {			//and redirects back to the login window.
				frmHome.setVisible(false);							
				PageLogin.firstPage();									
			}
		});
		logoutBtn.setFont(new Font("AR DESTINE", Font.PLAIN, 15));
		logoutBtn.setBounds(222, 156, 129, 58);						//Logout button's size
		frmHome.getContentPane().add(logoutBtn);					//Basically, the button is now a part of the window itself
		
		userLabel = new JLabel("WELCOME, " + CoopTransaction.acct[idNum].accntName + "!");		//Greets the user
		userLabel.setFont(new Font("Arimo", Font.BOLD, 13));		//Font style and size used
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);	//Position
		userLabel.setBounds(0, 11, 381, 29);						//Size
		frmHome.getContentPane().add(userLabel);					//Basically, the button is now a part of the window itself
		
		
		
	}
}
