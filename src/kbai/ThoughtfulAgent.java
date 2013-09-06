package kbai;

import java.util.ArrayList;
import java.util.Random;

public class ThoughtfulAgent extends Agent{
	
	private Random rand;
	private int playerNum;
	
	public ThoughtfulAgent(int playerNum)
	{
		rand = new Random();
		this.playerNum = playerNum;
	}
	
	public int nextMove(int[][] board)
	{	
		// Middle
		if(board[1][1] == 0)
		{
			return 4;
		}
		
		int self = findTwos(playerNum, board);
		if(self != -1)
		{
			return self;
		}
		if(playerNum == 1)
		{
			int opp = findTwos(2, board);
			if(opp != -1)
			{
				return opp;
			}
		}
		else
		{
			int opp = findTwos(1, board);
			if(opp != -1)
			{
				return opp;
			}
		}
		
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
	
	private int findTwos(int playerNum, int[][] board)
	{
		// Horizontals
		if(board[0][0] == 0 && board[0][1] == playerNum && board[0][2] == playerNum)
		{
			return 0;
		}
		if(board[0][0] == playerNum && board[0][1] == 0 && board[0][2] == playerNum)
		{
			return 1;
		}
		if(board[0][0] == playerNum && board[0][1] == playerNum && board[0][2] == 0)
		{
			return 2;
		}
		if(board[1][0] == 0 && board[1][1] == playerNum && board[1][2] == playerNum)
		{
			return 3;
		}
		if(board[1][0] == playerNum && board[1][1] == 0 && board[1][2] == playerNum)
		{
			return 4;
		}
		if(board[1][0] == playerNum && board[1][1] == playerNum && board[1][2] == 0)
		{
			return 5;
		}
		if(board[2][0] == 0 && board[2][1] == playerNum && board[2][2] == playerNum)
		{
			return 6;
		}
		if(board[2][0] == playerNum && board[2][1] == 0 && board[2][2] == playerNum)
		{
			return 7;
		}
		if(board[2][0] == playerNum && board[2][1] == playerNum && board[2][2] == 0)
		{
			return 8;
		}
		// Verticals
		if(board[0][0] == 0 && board[1][0] == playerNum && board[2][0] == playerNum)
		{
			return 0;
		}
		if(board[0][0] == playerNum && board[1][0] == 0 && board[2][0] == playerNum)
		{
			return 3;
		}
		if(board[0][0] == playerNum && board[1][0] == playerNum && board[2][0] == 0)
		{
			return 6;
		}
		if(board[0][1] == 0 && board[1][1] == playerNum && board[2][1] == playerNum)
		{
			return 1;
		}
		if(board[0][1] == playerNum && board[1][1] == 0 && board[2][1] == playerNum)
		{
			return 4;
		}
		if(board[0][1] == playerNum && board[1][1] == playerNum && board[2][1] == 0)
		{
			return 7;
		}
		if(board[0][2] == 0 && board[1][2] == playerNum && board[2][2] == playerNum)
		{
			return 2;
		}
		if(board[0][2] == playerNum && board[1][2] == 0 && board[2][2] == playerNum)
		{
			return 5;
		}
		if(board[0][2] == playerNum && board[1][2] == playerNum && board[2][2] == 0)
		{
			return 8;
		}
		// Diagonals
		if(board[0][0] == 0 && board[1][1] == playerNum && board[2][2] == playerNum)
		{
			return 0;
		}
		if(board[0][0] == playerNum && board[1][1] == 0 && board[2][2] == playerNum)
		{
			return 4;
		}
		if(board[0][0] == playerNum && board[1][1] == playerNum && board[2][2] == 0)
		{
			return 8;
		}
		if(board[0][2] == 0 && board[1][1] == playerNum && board[2][0] == playerNum)
		{
			return 2;
		}
		if(board[0][2] == playerNum && board[1][1] == 0 && board[2][0] == playerNum)
		{
			return 4;
		}
		if(board[0][2] == playerNum && board[1][1] == playerNum && board[2][0] == 0)
		{
			return 6;
		}	
		return -1;
	}
}
