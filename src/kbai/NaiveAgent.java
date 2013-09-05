package kbai;

import java.util.Random;

public class NaiveAgent extends Agent{
	private Random rand;
	private int playerNum;
	
	public NaiveAgent(int playerNum)
	{
		rand = new Random();
		this.playerNum = playerNum;
	}
	
	public int nextMove(int[][] board)
	{
		for(int j=0; j<board.length; j++)
		{
			for(int i=0; i<board[0].length; i++)
			{
				
			}
		}
		return rand.nextInt(9);
	}
}
