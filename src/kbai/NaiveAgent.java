package kbai;

import java.util.ArrayList;
import java.util.Random;

public class NaiveAgent extends Agent{
	private Random rand;
	
	public NaiveAgent()
	{
		rand = new Random();
	}
	
	public int nextMove(int[][] board)
	{
		ArrayList<Integer> open = new ArrayList<Integer>();
		for(int j=0; j<board.length; j++)
		{
			for(int i=0; i<board[0].length; i++)
			{
				if(board[j][i] == 0)
				{
					open.add(j*3 + i);
				}
			}
		}
		int move = rand.nextInt(open.size());
		return open.get(move);
	}
}
