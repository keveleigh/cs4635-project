package kbai;

import java.util.ArrayList;

public abstract class Agent {
	public ArrayList<Integer> moves;
	public ArrayList<String> reasons;
	
	abstract public int nextMove(int[][] board);
	abstract public void printDomainKnowledge(int[][] board);
}
