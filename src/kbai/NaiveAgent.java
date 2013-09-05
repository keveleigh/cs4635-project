package kbai;

import java.util.ArrayList;
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
		ArrayList<Integer> open = new ArrayList<Integer>();
		for(int j=0; j<board[0].length; j++)
		{
			for(int i=0; i<board.length; i++)
			{
				if(board[j][i] != 0)
				{
					open.add(0);
				}
			}
		}
		return rand.nextInt(9);
	}
}
