package tictactoe;

import java.util.Scanner;
import kbai.*;

public class Project1 {

	public static void main(String[] args) {
		System.out.println("Please select a mode:");
		System.out.println("1. Naive vs. Naive");
		System.out.println("2. Naive vs Thoughtful");
		System.out.println("3. Thoughtful vs Naive");
		System.out.println("4. Thoughtful vs Thoughtful");
		
		Scanner console = new Scanner(System.in);
		System.out.print("Mode: ");
		String input = console.next();
		
		Agent p1 = null;
		Agent p2 = null;
		
		if(input.equals("1"))
		{
			p1 = new NaiveAgent();
			p2 = new NaiveAgent();
		}
		else if(input.equals("2"))
		{
			p1 = new NaiveAgent();
			p2 = new ThoughtfulAgent(2);
		}
		else if(input.equals("3"))
		{
			p1 = new ThoughtfulAgent(1);
			p2 = new NaiveAgent();
		}
		else if(input.equals("4"))
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

		console.nextLine();
		System.out.println("");

		while(tt.noWinner())
		{
			if(tt.noWinner()){
				tt.takeMove(1);
				System.out.println("Next Turn:");
				System.out.println(tt.printBoard());
				System.out.println("Press enter to continue.");
				console.nextLine();
			}
			if(tt.noWinner()){
				tt.takeMove(2);
				System.out.println("Next Turn:");
				System.out.println(tt.printBoard());
				System.out.println("Press enter to continue.");
				console.nextLine();
			}
		}
		
		console.close();
		
		String winner = tt.getWinner();
		
		if(winner == null)
		{
			System.out.println("Nobody won.");
		}
		else{
			System.out.println("Player " + winner + " won.");
		}
	}
}