package tictactoe;

import kbai.Agent;

public class TicTacToe {

	private int[][] board;
	private Agent p1;
	private Agent p2;
	private String[] symbol;
	public static String trace;
	
	public TicTacToe(Agent p1, Agent p2)
	{
		board = new int[3][3];
		this.p1 = p1;
		this.p2 = p2;
		symbol = new String[3];
		symbol[0] = " ";
		symbol[1] = "X";
		symbol[2] = "O";
		trace = "";
	}
	
	public void takeMove(int player)
	{
		if(player == 1)
		{
			int move = p1.nextMove(board);
			p1.moves.add(move);
			board[move/3][move%3] = 1;
		}
		else if(player == 2)
		{
			int move = p2.nextMove(board);
			p2.moves.add(move);
			board[move/3][move%3] = 2;
		}
	}
	
	public String printBoard()
	{
		String ret = "";
		for(int j=0; j<board.length; j++)
		{
			for(int i=0; i<board[0].length; i++)
			{
				ret += " ";
				ret += symbol[board[j][i]];
				if(i < 2){
					ret += " |";
				}
			}
			if(j < 2){
				ret += "\n-----------\n";
			}
			else
			{
				ret += "\n";
			}
		}		
		return ret;
	}
	
	public boolean noWinner()
	{
		if(board[0][0] != 0 && board[0][0] == board[0][1] && board[0][1] == board[0][2])
		{
			return false;
		}
		else if(board[1][0] != 0 && board[1][0] == board[1][1] && board[1][1] == board[1][2])
		{
			return false;
		}
		else if(board[2][0] != 0 && board[2][0] == board[2][1] && board[2][1] == board[2][2])
		{
			return false;
		}
		else if(board[0][0] != 0 && board[0][0] == board[1][0] && board[1][0] == board[2][0])
		{
			return false;
		}
		else if(board[0][1] != 0 && board[0][1] == board[1][1] && board[1][1] == board[2][1])
		{
			return false;
		}
		else if(board[0][2] != 0 && board[0][2] == board[1][2] && board[1][2] == board[2][2])
		{
			return false;
		}
		else if(board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2])
		{
			return false;
		}
		else if(board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0])
		{
			return false;
		}
		else
		{
			for(int j=0; j<board.length; j++)
			{
				for(int i=0; i<board[0].length; i++)
				{
					if(board[j][i] == 0)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public String getWinner()
	{		
		if(board[0][0] != 0 && board[0][0] == board[0][1] && board[0][1] == board[0][2])
		{
			return symbol[board[0][0]];
		}
		else if(board[1][0] != 0 && board[1][0] == board[1][1] && board[1][1] == board[1][2])
		{
			return symbol[board[1][0]];
		}
		else if(board[2][0] != 0 && board[2][0] == board[2][1] && board[2][1] == board[2][2])
		{
			return symbol[board[2][0]];
		}
		else if(board[0][0] != 0 && board[0][0] == board[1][0] && board[1][0] == board[2][0])
		{
			return symbol[board[0][0]];
		}
		else if(board[0][1] != 0 && board[0][1] == board[1][1] && board[1][1] == board[2][1])
		{
			return symbol[board[0][1]];
		}
		else if(board[0][2] != 0 && board[0][2] == board[1][2] && board[1][2] == board[2][2])
		{
			return symbol[board[0][2]];
		}
		else if(board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2])
		{
			return symbol[board[0][0]];
		}
		else if(board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0])
		{
			return symbol[board[0][2]];
		}
		return null;		
	}
}