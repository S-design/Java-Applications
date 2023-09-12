
/**
 * To demonstrate some methods found in the Math class.
 * 
  */
import java.util.*;
public class MathDemo
{
	
	public double squareRoot(double rootIn)
	{
	 return  Math.sqrt(rootIn);
	}
	
	public void  rollDice()
	{
	   int score;
	   score = (int) (Math.random() * 6) + 1;
	   System.out.println("You rolled a " + score);
	}
	
	public void findThePower()
	{
	   double base, exponent;
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter a number you wish to raise to the power");
	   base = sc.nextDouble();
	   System.out.println("Enter the power you wish to raise the number to");
	   exponent = sc.nextDouble();
	   System.out.print("The number " + base + " raised to the power " + exponent + " = ");
	   System.out.println(Math.pow(base,exponent));
	}
	
	public int generateLottoNumber()
	{
		int lottoNum;
		lottoNum = (int) (Math.random() * 100) +1;
		
		return lottoNum;
	}
	
	public int randomMath(int lottoNum, int score)
	{
		int random;
		random = lottoNum * score;
		return random;
	}
	
	public int randomMath(int lottoNum, int score, int random)
	{
		int aMathThing;
		aMathThing = (lottoNum * score) + random;
		return aMathThing;
	}
	public int max(int aIn, int bIn, int cIn)
	{
		
		int abc;
		abc = aIn;
		if(bIn>abc)
		{
			abc=bIn;
		}if(cIn>abc)
		{
			abc=cIn;
		}
		return abc;
	}
	
	public void bestOfThree()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Number 1.");
		int a =sc.nextInt();
		
		System.out.println("Enter Number 2.");
		int b =sc.nextInt();
		
		System.out.println("Enter Number 3.");
		int c =sc.nextInt();
		
		System.out.println(max(a,b,c));
	}
	
	
}
