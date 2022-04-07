import java.util.Scanner;//import scanner
import java.util.Random;//import random

public class methods_dice_roller {//class

	public static void main(String[] args)//main method
	{
		Scanner	scnr = new Scanner(System.in);//new scanner
		
		int rollCount = 1;//variables
		int userNumber = 0;
		String userContinue = "y";
		
		System.out.println("Welcome to my dice roll game!"//prints first message and rules for craps to user
				+"\n - For craps game enter 6 for how many sides the die should have"
				+"\n - 1 and 1 is Snake Eyes"
				+"\n - 6 and 6 is Box Cars"
				+"\n - On a players first turn a 2, 3, or 12 total is a Crap Out/Pass Dice");
		/*I don't actually know the rules for Craps so sorry if this is incorrect. I tried to learn it 
		 * on google but it seems more involved than I thought. A lot of the rules seem to depend on the bet 
		 * you made as well as the person shooting/number of their roll. Anyways this is the best I could come 
		 * up with in without having to read too much about the game.*/
		
		System.out.println("How many sides should the die have?");//asks for user to give number of sides
		if(scnr.hasNextInt())//if statement to see if user entered a integer
		{
			userNumber = Integer.parseInt(scnr.nextLine());//stores int as string, for some reason I had to do this to reset the scanner not sure why 
			if (userNumber > 0)//if statement to see if positive
			{
			}
			else
			{
				System.out.println("Invalid input, goodbye!");//if negative display message then exit program
				System.exit(0);
			}
		}
		else//if not integer display message then exit program
		{
			System.out.println("Invalid input, goodbye!");
			System.exit(0);
		}
			while(userContinue.equalsIgnoreCase("y"))//loop to check for y to coninue 
				{
					System.out.println("Roll " + rollCount);//display what roll user is on
					int randomOne = (generateRandomDieRollMathClass(userNumber));//calls method one math class
					System.out.println(randomOne);//prints method one result
					int randomTwo = (generateRandomDieRollRandomClass(userNumber));//calls method two random class
					System.out.println(randomTwo);//prints method two result
					
					int total = randomOne + randomTwo;//total of both rolls
					
						if (rollCount == 1 && (total == 2 || total == 3 || total == 12))//conditions for crap out
						{
							System.out.println("You rolled Crap Out! Total: " + total);//print message plus total of rolls
						}
						else if (randomOne == 1 && randomTwo == 1)//condition for snake eyes
						{
							System.out.println("You rolled Snake Eyes! Total: " + total);// print message plus total of rolls
						}
						else if (randomOne == 6 && randomTwo == 6)//condition for box cars
						{
							System.out.println("You rolled Box Cars! Total: " + total);//prints message plug total of rolls
						}
						else
						{
							System.out.println("Total: " + total);//prints total of rolls
						}
						
					System.out.println("Roll again? (y/n)");//asks user if they want to continue
				
					userContinue = scnr.nextLine();//gets user choice
					
					while(!(userContinue.equalsIgnoreCase("y") || userContinue.equalsIgnoreCase("n")))//if not y or n repromts to enter valid input
					{
						System.out.println("Not a valid input. Please choose y to coninue or n to end");
						userContinue = scnr.nextLine();
					}
				rollCount ++;//increments counter for roll 
				
				}
		
		scnr.close();//closes scanner
	}

	public static int generateRandomDieRollMathClass (int sidesChoice) //method one for math class
	{
		int rollRandom1 = (int)((Math.random() * sidesChoice)+1);
		return rollRandom1;
		
	}
	public static int generateRandomDieRollRandomClass (int sidesChoice)//method two for random class
	{
		Random num = new Random();
		int rollRandom2 = num.nextInt(sidesChoice) + 1;
		return rollRandom2;
	}
}
