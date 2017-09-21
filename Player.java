/**
 *  A player of a math game
 */
public class Player 
{
	private String name; //no change in name
	private int score; //no change in score
	private int level;//no change in level
	private int operation_symbol;
	
	/**
	 * constructs a player object
	 * */
	public Player()
	{
		name = "";
		score = 0;
		level = 1; //the lowest you can go is 1
		operation_symbol = 1;
	}
	/**
	 * Constructs a players object with the player's and initial level
	 * */
	public Player(String playerName, int initialLevel, int operation)
	{
		name = playerName;
		score = 0;
		level = initialLevel;
		operation_symbol = operation; 
	}
	/**
	 * Increments the player's score
	 */
	public void incrementScore()
	{
		score++;
		if (score % 5 == 0 && level < 3) {level++;}
	}
	/**
	 * getting level
	 */
	public int getLevel()
	{
		return level;
	}
	/**
	 * return name of player
	 */
	public String getName()
	{
		return name;
	}
	public int getOperation()
	{
		return operation_symbol;
	}

}
