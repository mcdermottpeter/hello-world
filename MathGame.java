import java.util.Scanner;
import java.security.SecureRandom;
import java.util.InputMismatchException;
/**
 * play a math game
 */
public class MathGame 
{
	private Player player;
	private Scanner in;
	 /**
	  * construct a MathGame object
	  */
	public MathGame()
	{
		player = new Player();
		in = new Scanner(System.in);
	}
	/**
	 * Reads user information
	 */
	public void readPlayerInformation()
	{
		String name = "";
		System.out.print("What is your name? ");//gets the person's name and refers to it when get it right or wrong
		name = in.next();
		
		int initialLevel = 0;
		int operation = 0;
		
		boolean done = false;
		while (!done) //this while loop trys for a number and if doesn't have a number ranging to a certain place it will give you an error
		{
			System.out.print("What level do you want? 1-3 ");
			
			try
			{
				initialLevel = in.nextInt();
				
				if (initialLevel >=1 && initialLevel <= 3)
				{
					done = true;
				}
			}
			catch (InputMismatchException e)
			{
				in.next();
				System.out.println("Please enter number ranging 1-3 ");
			}
		}

		boolean finish = false;
		while (!finish) //same thing with error message for the operation
		{
			System.out.print("What operation do you want? 1-5 ");
			
			try
			{
				operation = in.nextInt();
				
				if (operation >=1 && operation <= 5)
				{
					finish = true;
				}
			}
			catch (InputMismatchException e)
			{
				in.next();
				System.out.println("Please enter number ranging 1-5 ");
			}
		}
		
		player = new Player(name, initialLevel,operation); //stores what you put down for the question
	}
	/**
	 * plays the game
	 */
	public void play()
	{
		System.out.printf("\t\tWelcome%n%n");
		readPlayerInformation(); //bringing one function to this one
		String response = "";
		boolean done = false;
		while (!done)
		{
			playRound();
			System.out.print("Do you want to play again? Y/N ");
			response = in.next();
			
			if (!response.equalsIgnoreCase("y"))//whether upper or lower it ignores it
			{
				done = true;
			}
		}
	}
	public void playRound()
	{
		int count = 0;
		int num1 = 0;
		int num2 = 0;
		int answer = 0;
		
		SecureRandom random1 = new SecureRandom(); //for num1
		SecureRandom random2 = new SecureRandom(); //for num2
		SecureRandom random3 = new SecureRandom(); //for opRandom
		
		if (player.getLevel() == 1 && player.getOperation() == 1)
		{
			
			while(count != 5)
			{
				
				num1 = random1.nextInt(9);
				num2 = random2.nextInt(9);
				answer = num1 + num2;
				
				System.out.printf("%d + %d = ", num1, num2);

				System.out.println(getResults(answer));
				count++;
			}
		}
		if (player.getLevel() == 1 && player.getOperation() == 2)
		{ 
	         while(count != 5)
				{
					
					num1 = random1.nextInt(9);
					num2 = random2.nextInt(9);
					answer = num2 - num1;
			        while (answer < 0)
			         {
			        	num1 = random1.nextInt(9);
						num2 = random1.nextInt(9);
			            answer = num2 - num1;            
			         }
			            
					System.out.printf("%d - %d = ", num2, num1);

					System.out.println(getResults(answer));
					count++;
				}
	      }	
		if (player.getLevel() == 1 && player.getOperation() == 3)
		{
			while(count != 5)
			{
				num1 = random1.nextInt(9);
				num2 = random2.nextInt(9);
				answer = num1 * num2;
				
				System.out.printf("%d * %d = ", num1, num2);

				System.out.println(getResults(answer));
				count++;
			}
		}
		if (player.getLevel() == 1 && player.getOperation() == 4)
		{
			while(count != 5)
			{
				num1 = random1.nextInt(9) + 1;
				num2 = random2.nextInt(9);

				while ((num1 % num2) != 0)
				{
					num1 = random1.nextInt(9) + 1;
					num2 = random1.nextInt(9) + 1;
     
				}
				
				answer = num1 / num2; 

				System.out.printf("%d / %d = ", num1, num2);
				System.out.println(getResults(answer));
				count++;

			}
		}
		if (player.getLevel() == 1 && player.getOperation() == 5)
		{
			while (count != 5)
			{
				int opRandom = random3.nextInt(4) + 1;
				if (opRandom == 1)
				{
					num1 = random1.nextInt(9);
					num2 = random2.nextInt(9);
					answer = num1 + num2;
					System.out.printf("%d + %d = ", num1, num2);

					System.out.println(getResults(answer));
					count++;
				}
				if (opRandom == 2)
				{
					num1 = random1.nextInt(9);
					num2 = random2.nextInt(9);
					answer = num2 - num1;
					while (answer < 0)
			         {
			        	num1 = random1.nextInt(9);
						num2 = random1.nextInt(9);
			            answer = num2 - num1;            
			         }
					System.out.printf("%d - %d = ", num2, num1);

					System.out.println(getResults(answer));
					count++;
				}
				if (opRandom == 3)
				{
					num1 = random1.nextInt(9);
					num2 = random2.nextInt(9);
					answer = num1 * num2;
					System.out.printf("%d * %d = ", num1, num2);

					System.out.println(getResults(answer));
					count++;
				}
				if (opRandom == 4)
				{
					num1 = random1.nextInt(9);
					num2 = random2.nextInt(9);
					if (num2 == 0)
					{
						num2 = random1.nextInt(9);
					}
					while (num2 % num1 != 0)
					{
						num1 = random1.nextInt(9);
						num2 = random1.nextInt(9);
						if (num2 == 0)
						{
							num2 = random1.nextInt(9);
						}
			                
					}
					answer = num2 / num1;
					System.out.printf("%d / %d = ", num2, num1);

					System.out.println(getResults(answer));
					count++;
				}
			}
		}

		if (player.getLevel() == 2 && player.getOperation() == 1)
		{
			
			while(count != 5)
			{
				
				num1 = random1.nextInt(99);
				num2 = random2.nextInt(99);
				answer = num1 + num2;
				
				System.out.printf("%d + %d = ", num1, num2);

				System.out.println(getResults(answer));
				count++;
			}
		}
		if (player.getLevel() == 2 && player.getOperation() == 2)
		{ 
	         while(count != 5)
				{
					
					num1 = random1.nextInt(99);
					num2 = random2.nextInt(99);
					answer = num2 - num1;
			        while (answer < 0)
			         {
			        	num1 = random1.nextInt(99);
						num2 = random1.nextInt(99);
			            answer = num2 - num1;            
			         }
			            
					System.out.printf("%d - %d = ", num2, num1);

					System.out.println(getResults(answer));
					count++;
				}
	      }	
		if (player.getLevel() == 2 && player.getOperation() == 3)
		{
			while(count != 5)
			{
				num1 = random1.nextInt(99);
				num2 = random2.nextInt(99);
				answer = num1 * num2;
				
				System.out.printf("%d * %d = ", num1, num2);

				System.out.println(getResults(answer));
				count++;
			}
		}
		if (player.getLevel() == 2 && player.getOperation() == 4)
		{
			while(count != 5)
			{
				num1 = random1.nextInt(99);
				num2 = random2.nextInt(99);
				if (num2 == 0)
				{
					num2 = random1.nextInt(9);
				}
	
				while (num2 % num1 != 0)
				{
					num1 = random1.nextInt(99);
					num2 = random1.nextInt(99);
					if (num2 == 0)
					{
						num2 = random1.nextInt(9);
					}
		              
				}
				 answer = num2 / num1; 
				System.out.printf("%d / %d = ", num2, num1);

				System.out.println(getResults(answer));
				count++;
			}
		}
		if (player.getLevel() == 2 && player.getOperation() == 5)
		{
			while (count != 5)
			{
				int opRandom = random3.nextInt(4) + 1;
				if (opRandom == 1)
				{
					num1 = random1.nextInt(99);
					num2 = random2.nextInt(99);
					answer = num1 + num2;
					System.out.printf("%d + %d = ", num1, num2);

					System.out.println(getResults(answer));
					count++;
				}
				if (opRandom == 2)
				{
					num1 = random1.nextInt(99);
					num2 = random2.nextInt(99);
					answer = num2 - num1;
					while (answer < 0)
			         {
			        	num1 = random1.nextInt(99);
						num2 = random1.nextInt(99);
			            answer = num2 - num1;            
			         }
					System.out.printf("%d - %d = ", num2, num1);

					System.out.println(getResults(answer));
					count++;
				}
				if (opRandom == 3)
				{
					num1 = random1.nextInt(99);
					num2 = random2.nextInt(99);
					answer = num1 * num2;
					System.out.printf("%d * %d = ", num1, num2);

					System.out.println(getResults(answer));
					count++;
				}
				if (opRandom == 4)
				{
					num1 = random1.nextInt(99);
					num2 = random2.nextInt(99);
					if (num2 == 0)
					{
						num2 = random1.nextInt(9);
					}
					while (num2 % num1 != 0)
					{
						num1 = random1.nextInt(99);
						num2 = random1.nextInt(99);
						if (num2 == 0)
						{
							num2 = random1.nextInt(9);
						}
			                
					}
					answer = num2 / num1;
					System.out.printf("%d / %d = ", num2, num1);

					System.out.println(getResults(answer));
					count++;
				}
			}
		}

		if (player.getLevel() == 3 && player.getOperation() == 1)
		{
			System.out.println("\t\tWelcome to HELL!!!\n\n");
			while(count != 5)
			{
				
				num1 = random1.nextInt(999);
				num2 = random2.nextInt(999);
				answer = num1 + num2;
				
				System.out.printf("%d + %d = ", num1, num2);

				System.out.println(getResults(answer));
				count++;
			}
		}
		if (player.getLevel() == 3 && player.getOperation() == 2)
		{ 
			System.out.println("\t\tWelcome to HELL!!!\n\n");
	         while(count != 5)
				{
					
					num1 = random1.nextInt(999);
					num2 = random2.nextInt(999);
					answer = num2 - num1;
			        while (answer < 0)
			         {
			        	num1 = random1.nextInt(999);
						num2 = random1.nextInt(999);
			            answer = num2 - num1;            
			         }
			            
					System.out.printf("%d - %d = ", num2, num1);

					System.out.println(getResults(answer));
					count++;
				}
	      }	
		if (player.getLevel() == 3 && player.getOperation() == 3)
		{
			System.out.println("\t\tWelcome to HELL!!!\n\n");
			while(count != 5)
			{
				num1 = random1.nextInt(999);
				num2 = random2.nextInt(999);
				answer = num1 * num2;
				
				System.out.printf("%d * %d = ", num1, num2);

				System.out.println(getResults(answer));
				count++;
			}
		}
		if (player.getLevel() == 3 && player.getOperation() == 4)
		{
			System.out.println("\t\tWelcome to HELL!!!\n\n");
			while(count != 5)
			{
				num1 = random1.nextInt(999);
				num2 = random2.nextInt(999);
				if (num2 == 0)
				{
					num2 = random1.nextInt(9);
				}
				while (num2 % num1 != 0)
				{
					num1 = random1.nextInt(999);
					num2 = random1.nextInt(999);
					if (num2 == 0)
					{
						num2 = random1.nextInt(9);
					}
		                
				}
				answer = num2 / num1;
				System.out.printf("%d / %d = ", num2, num1);

				System.out.println(getResults(answer));
				count++;
			}
		}
		if (player.getLevel() == 3 && player.getOperation() == 5)
		{
			System.out.println("\t\tWelcome to HELL!!!\n\n");
			while (count != 5)
			{
				int opRandom = random3.nextInt(4) + 1;
				if (opRandom == 1)
				{
					num1 = random1.nextInt(999);
					num2 = random2.nextInt(999);
					answer = num1 + num2;
					System.out.printf("%d + %d = ", num1, num2);

					System.out.println(getResults(answer));
					count++;
				}
				if (opRandom == 2)
				{
					num1 = random1.nextInt(999);
					num2 = random2.nextInt(999);
					answer = num2 - num1;
					while (answer < 0)
			         {
			        	num1 = random1.nextInt(999);
						num2 = random1.nextInt(999);
			            answer = num2 - num1;            
			         }
					System.out.printf("%d - %d = ", num2, num1);

					System.out.println(getResults(answer));
					count++;
				}
				if (opRandom == 3)
				{
					num1 = random1.nextInt(999);
					num2 = random2.nextInt(999);
					answer = num1 * num2;
					System.out.printf("%d * %d = ", num1, num2);

					System.out.println(getResults(answer));
					count++;
				}
				if (opRandom == 4)
				{
					num1 = random1.nextInt(999);
					num2 = random2.nextInt(999);
					if (num2 == 0)
					{
						num2 = random1.nextInt(9);
					}
					while (num2 % num1 != 0)
					{
						num1 = random1.nextInt(999);
						num2 = random1.nextInt(999);
						if (num2 == 0)
						{
							num2 = random1.nextInt(9);
						}
			                
					}
					answer = num2 / num1;
					System.out.printf("%d / %d = ", num2, num1);

					System.out.println(getResults(answer));
					count++;
				}
			}
		}

	   }
	
	public String getResults(int answer)
	   {
	      int guess = getGuess();

	      if (answer != guess)	//Allow a second try.
	      {
		   System.out.println("Sorry, that is incorrect. Please try one more time. ");
	       guess = getGuess();
	      }
	      String result = "";;
	      if (answer == guess)
	      {  
	         result = "Congratulations, " + player.getName() + "! That is correct.";
	         player.incrementScore();
	      }
	      else
	      {  
	         result = "Sorry, " + player.getName()
	               + ". The correct answer is " + answer;
	      }
	      
	      return result;
	   }
	 public int getGuess()
	   {  
	      int guess = 0;
	      boolean done = false;
	     // String input = "";
	      while (!done)
	      {
	         try
	         {
	            if (player.getLevel() == 3)
	            {
	              // System.out.print("Please enter the difference: ");
	               guess = in.nextInt();
	            }
	            else
	            {  
	               //System.out.print("Please enter the sum: ");
	               guess = in.nextInt();
	            }
	         
	            if (guess > 0) { done = true; }
	         }
	         catch(InputMismatchException e)
	         {
	            in.next(); // read the newline character
	            System.out.println("\tThe response must be a number. ");
	         }
	      }

	      return guess;
	   }
}

