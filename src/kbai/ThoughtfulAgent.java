package kbai;

import java.util.ArrayList;
import java.util.Random;

public class ThoughtfulAgent extends Agent{
	
	private Random rand;
	private int playerNum;
	private boolean moveLegality;
	
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
			moveLegality = true;
			printDomainKnowledge(board);
			return 4;
		}
				
		int self = findTwos(playerNum, board);
		if(self != -1)
		{
			moveLegality = true;
			printDomainKnowledge(board);
			return self;
		}
		if(playerNum == 1)
		{
			int opp = findTwos(2, board);
			if(opp != -1)
			{
				moveLegality = true;
				printDomainKnowledge(board);
				return opp;
			}
		}
		else
		{
			int opp = findTwos(1, board);
			if(opp != -1)
			{
				moveLegality = true;
				printDomainKnowledge(board);
				return opp;
			}
		}
		
		int corn = findCorner(playerNum, board);
		if(corn != -1)
		{
			moveLegality = true;
			printDomainKnowledge(board);
			return corn;
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
		if(open.size() > 0){
			moveLegality = true;
		}
		printDomainKnowledge(board);
		return open.get(move);
	}
	
	private int findCorner(int playerNum, int[][] board) {
		ArrayList<Integer> corners = new ArrayList<Integer>();
		// Check the corners
		if(board[0][0] == 0)
		{
			corners.add(0);
		}
		if(board[0][2] == 0)
		{
			corners.add(2);
		}
		if(board[2][0] == 0)
		{
			corners.add(6);
		}
		if(board[2][2] == 0)
		{
			corners.add(8);
		}
		if(corners.size() > 0)
		{
			return corners.get(rand.nextInt(corners.size()));
		}
		else
		{
			return -1;
		}
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

	@Override
	public void printDomainKnowledge(int[][] board) {
		int openSpaces = 0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(board[i][j] == 0){
					openSpaces++;
				}
			}
		}
		
		boolean openMiddle = false;
		if(board[1][1] == 0){
			openMiddle = true;
		}
		
		int openCorners = openCorners(board);
		boolean openTwos = openTwos(playerNum, board);
		System.out.println("Checking domain knowledge...");
		System.out.println("Is the middle open before move? " + openMiddle);
		System.out.println("Number of open spaces before move: " + openSpaces);
		System.out.println("Number of open corners before move: " + openCorners);
		System.out.println("Is there an open spot for the win? " + openTwos);
		System.out.println("Is my move legal? " + moveLegality + "\n");
	}
	
	private int openCorners(int[][] board){
		int openCorners = 0;
		if(board[0][0] == 0)
		{
			openCorners++;
		}
		if(board[0][2] == 0)
		{
			openCorners++;
		}
		if(board[2][0] == 0)
		{
			openCorners++;
		}
		if(board[2][2] == 0)
		{
			openCorners++;
		}
		return openCorners;
	}
	
	private boolean openTwos(int playerNum, int[][] board)
	{
		// Horizontals
		if(board[0][0] == 0 && board[0][1] == playerNum && board[0][2] == playerNum)
		{
			return true;
		}
		if(board[0][0] == playerNum && board[0][1] == 0 && board[0][2] == playerNum)
		{
			return true;
		}
		if(board[0][0] == playerNum && board[0][1] == playerNum && board[0][2] == 0)
		{
			return true;
		}
		if(board[1][0] == 0 && board[1][1] == playerNum && board[1][2] == playerNum)
		{
			return true;
		}
		if(board[1][0] == playerNum && board[1][1] == 0 && board[1][2] == playerNum)
		{
			return true;
		}
		if(board[1][0] == playerNum && board[1][1] == playerNum && board[1][2] == 0)
		{
			return true;
		}
		if(board[2][0] == 0 && board[2][1] == playerNum && board[2][2] == playerNum)
		{
			return true;
		}
		if(board[2][0] == playerNum && board[2][1] == 0 && board[2][2] == playerNum)
		{
			return true;
		}
		if(board[2][0] == playerNum && board[2][1] == playerNum && board[2][2] == 0)
		{
			return true;
		}
		// Verticals
		if(board[0][0] == 0 && board[1][0] == playerNum && board[2][0] == playerNum)
		{
			return true;
		}
		if(board[0][0] == playerNum && board[1][0] == 0 && board[2][0] == playerNum)
		{
			return true;
		}
		if(board[0][0] == playerNum && board[1][0] == playerNum && board[2][0] == 0)
		{
			return true;
		}
		if(board[0][1] == 0 && board[1][1] == playerNum && board[2][1] == playerNum)
		{
			return true;
		}
		if(board[0][1] == playerNum && board[1][1] == 0 && board[2][1] == playerNum)
		{
			return true;
		}
		if(board[0][1] == playerNum && board[1][1] == playerNum && board[2][1] == 0)
		{
			return true;
		}
		if(board[0][2] == 0 && board[1][2] == playerNum && board[2][2] == playerNum)
		{
			return true;
		}
		if(board[0][2] == playerNum && board[1][2] == 0 && board[2][2] == playerNum)
		{
			return true;
		}
		if(board[0][2] == playerNum && board[1][2] == playerNum && board[2][2] == 0)
		{
			return true;
		}
		// Diagonals
		if(board[0][0] == 0 && board[1][1] == playerNum && board[2][2] == playerNum)
		{
			return true;
		}
		if(board[0][0] == playerNum && board[1][1] == 0 && board[2][2] == playerNum)
		{
			return true;
		}
		if(board[0][0] == playerNum && board[1][1] == playerNum && board[2][2] == 0)
		{
			return true;
		}
		if(board[0][2] == 0 && board[1][1] == playerNum && board[2][0] == playerNum)
		{
			return true;
		}
		if(board[0][2] == playerNum && board[1][1] == 0 && board[2][0] == playerNum)
		{
			return true;
		}
		if(board[0][2] == playerNum && board[1][1] == playerNum && board[2][0] == 0)
		{
			return true;
		}	
		return false;
	}
}