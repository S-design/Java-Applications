import java.util.Scanner;

/**
 * Favourite class to test a string object and it's methods.
 * 
 * @eSisley
 * @130923 (a version number or a date)
 */

public class WrappedUp
{
	static String input;
	static String favouriteAnimal = "cat";
	
	public void guessMyFavouriteThing()
	{
		
	   //Create a string object with your favourite animal, car ..whatever
//		String favouriteAnimal = "cat";
		
		Scanner sc=new Scanner(System.in);
		
		
	   //e.g String favMotorBikeManufacturer = "bmw"
	   
		System.out.println("Guess my favourite animal. It has " + favouriteAnimal.length() + " characters and begins with " + favouriteAnimal.charAt(0));
		input= sc.nextLine();
	}
	   /* Now prompt for a guess - using the Scanner class
	    
	   ** Using String methods, you should give the length 
	   ** and first letter of your favourite thing in the prompt.
	   */
		
//	  if(favouriteAnimal.contains(String.valueOf(letter))
		  
		
	  // Now test if the guess was correct - ignore case 
	 
	
	
	
	//end guessing


	public static void main(String args[]) {
		
		WrappedUp w=new WrappedUp();
		w.guessMyFavouriteThing();
		//Create WrappedUp object and test the methods
		  char letter = input.charAt(0);
		  char letter2 = input.charAt(1);
		  char letter3 = input.charAt(2);
		  
  if (favouriteAnimal.contains(String.valueOf(letter))) {
      for (int i = 0; i < favouriteAnimal.length(); i++) {
          if (favouriteAnimal.charAt(i) == letter) {
        	  System.out.println("First letter correct");
          }
      }
  } else {
      System.out.println("Incorrect guess. Try again.");
  }
  
  if (favouriteAnimal.contains(String.valueOf(letter2))) {
      for (int i = 0; i < favouriteAnimal.length(); i++) {
          if (favouriteAnimal.charAt(i) == letter2) {
        	  System.out.println("Second letter correct");
          }
      }
  } else {
      System.out.println("Incorrect guess. Try again.");
  }
  
  if (favouriteAnimal.contains(String.valueOf(letter3))) {
      for (int i = 0; i < favouriteAnimal.length(); i++) {
          if (favouriteAnimal.charAt(i) == letter3) {
        	  System.out.println("Third letter correct");
          }
      }
  } else {
      System.out.println("Incorrect guess. Try again.");
  }
	}
}
