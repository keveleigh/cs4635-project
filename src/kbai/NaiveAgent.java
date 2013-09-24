package kbai;

import java.util.ArrayList;
import java.util.Random;

public class NaiveAgent extends Agent{
	
	private Random rand;
	private boolean moveLegality;
	
	public NaiveAgent()
	{
		rand = new Random();
		moveLegality = false;
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
		if(open.size() > 0){
			moveLegality = true;
		}
		printDomainKnowledge(board);
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
		System.out.println("Checking domain knowledge...");
		System.out.println("Number of open spaces before move: " + openSpaces);
		System.out.println("Is my move legal? " + moveLegality + "\n");
	}
}