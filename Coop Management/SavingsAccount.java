package CoopManagement;

public class SavingsAccount {
	
	public static final int MBAL = 500;							//The 'must-be-maintained' amount
	public String accntName;									//user's account name
	public String accntNo;										//user's account no.
	private String accntPin;									//user's PIN no.
	private String accntCode;									//user's account code
	private String accntMM;										//an additional feature for unlocking the user's PIN
	double accntBal;											//current account balance of the user
	
	public SavingsAccount(String aName, String aNo, String aPin, String aCode, String aMM){
		accntName = aName;								//Constructor that initializes the values of the parameters 
		accntNo = aNo;									//to the respective fields' values, and initializes account balance to MBAL.
		accntPin = aPin;
		accntCode = aCode;
		accntMM = aMM;
		accntBal = MBAL;
	}
	
	public void deposit(double amt){					//The passed amount will be added into account balance.
		accntBal = accntBal + amt;
	}
	
	public void withdraw(double amt){					//The passed amount will be subtracted to the account balance.
		accntBal = accntBal - amt;
	}
	
	public double balInquiry(){							//User's account balance is returned.
		return accntBal;
	}
	
	public String showPin(String inputCode, String inputMMName){				//Returns the account's PIN whenever the user correctly entered the accntCode and the extra security feature
		if((inputCode.equals(accntCode))&&(inputMMName.equals(accntMM)))
		{
			return accntPin;
		}
		else{
			return "";
		}
	}
	
	public boolean scanPin(String pinInput){					
		if(pinInput.equals(accntPin))			
		{
			return true;							//This method has a boolean value which will be returned whenever the user correctly enters accntPIN
		}
		else{
			return false;
		}
	}
	
	public boolean scanCode(String codeInput){	
		if(codeInput.equals(accntCode))
		{											//This method has a boolean value which will be returned whenever the user correctly enters accntCode
			return true;
		}
		else{
			return false;
		}
	}

}

