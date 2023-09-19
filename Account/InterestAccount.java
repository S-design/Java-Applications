 
/**
 * class InterestAccount .
 * 
  */

public class InterestAccount extends Account
    {
    	private double monthlyIntrestRate;
    	private double addMI;
    	  /**
         * Constructor for objects of class InterestAccount
         */
    
    public InterestAccount(double balanceIn, double monthlyInterestRateIn)
    {
    	super(balanceIn);
    	monthlyIntrestRate = monthlyInterestRateIn;
    			}
    
  //Setters & getters
	public double getMonthlyIntrestRate() {
		return monthlyIntrestRate;
	}

	public void setMonthlyIntrestRate(double monthlyIntrestRateIn) {
		monthlyIntrestRate = monthlyIntrestRateIn;
	} 
	
	// calculate monthly interest
	public  double addMonthlyInterest()
    {
		return addMI = getBalance() + (getBalance() * monthlyIntrestRate)/100;
	
    }
	
	//adding to super class passing a variable into a parameter of the method credit
	public void toCredit()
	{
		credit(addMI);
	}
	@Override
	public String toString()
	{
		return super.toString() + "Intrest Account balance : " + addMI +
				'\n' + "Intrest Account monthly intrest: " + monthlyIntrestRate;
 	}
}