package LabExer2;
/*
 * FABRO, DAN NINO I.			BSCpE2A_C1					OOP LabExer
 */
import LabExer2.SavingsAccount;
import LabExer2.PageLogin;

public class CoopTransaction {
	public static int numAccnt = 0;								//Number of accounts created and is initialized at zero.
	public static SavingsAccount acct[] = new SavingsAccount[numAccnt]; 		//Array instance of SavingsAccount
	
	public static void main(String[] args){
		PageLogin.firstPage();							//Directs to the pageLogin class and executed the Login window.
	}

}
