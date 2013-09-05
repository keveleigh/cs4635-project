package tictactoe;

import java.util.Scanner;
import kbai.*;

public class Project1 {

	public static void main(String[] args) {
		System.out.println("Please select a mode:");
		System.out.println("1. Naive vs. Naive");
		System.out.println("2. Naive vs Thoughtful");
		System.out.println("3. Thoughtful vs Thoughtful");
		
		Scanner console = new Scanner(System.in);
		System.out.print("Mode: ");
		String input = console.next();
		
		Agent p1 = null;
		Agent p2 = null;
				
		if(input.equals("1"))
		{
			p1 = new NaiveAgent(1);
			p2 = new NaiveAgent(2);
		}
		else if(input.equals("2"))
		{
			p1 = new NaiveAgent(1);
			p2 = new ThoughtfulAgent(2);
		}
		else if(input.equals("3"))
		{
			p1 = new ThoughtfulAgent(1);
			p2 = new ThoughtfulAgent(2);
		}
		else
		{
			System.out.println("You didn't enter a valid character. Exiting.");
			System.exit(0);
		}
		
		TicTacToe tt = new TicTacToe(p1, p2);

		while(tt.noWinner())
		{
			tt.takeMove(1);
			System.out.println("\nNext Turn:");
			System.out.println(tt.printBoard());
		}
		
		console.close();
		
		System.out.println("SOMETHING HAPPENED");
	}

}
