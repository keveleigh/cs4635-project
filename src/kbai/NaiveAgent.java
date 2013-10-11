package kbai;

import java.util.ArrayList;
import java.util.Random;

public class NaiveAgent extends Agent{
	
	private Random rand;
	private boolean moveLegality;
	private boolean isMyTurn;
	
	public NaiveAgent()
	{
		rand = new Random();
		moveLegality = false;
	}
	
	public int nextMove(int[][] board)
	{
		isMyTurn = true;
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
		isMyTurn = false;
		return open.get(move);
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
		System.out.println("Checking knowledge (naive)...");
		System.out.println("Domain: Number of open spaces: " + openSpaces);
		System.out.println("Domain: Is my move legal? " + moveLegality);
		System.out.println("Domain: Is it my turn? " + isMyTurn);
		System.out.println("Domain: Is the game over? " + false + "\n");
	}
}