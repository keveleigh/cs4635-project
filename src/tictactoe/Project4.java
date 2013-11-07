package tictactoe;

import java.util.Scanner;

import kbai.Agent;
import kbai.NaiveAgent;
import kbai.ThoughtfulAgent;

public class Project4 {
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
		
		int turnNum = 1;

		while(tt.noWinner())
		{
			System.out.println("Turn " + turnNum);
			if(tt.noWinner()){
				tt.takeMove(1);
				System.out.println("X move:");
				System.out.println(tt.printBoard());
				System.out.println("Press enter to continue.");
				console.nextLine();
			}
			if(tt.noWinner()){
				tt.takeMove(2);
				System.out.println("O move:");
				System.out.println(tt.printBoard());
				System.out.println("Press enter to continue.");
				console.nextLine();
			}
			turnNum++;
		}
		
		String winner = tt.getWinner();
		
		if(winner == null)
		{
			System.out.println("Nobody won.");
		}
		else{
			System.out.println("Player " + winner + " won.");
		}
		
		String[] spotNames = {"top left corner", "top middle spot", "top right corner", "middle left spot", "center", "middle right spot", "bottom left corner", "bottom middle spot", "bottom right corner"};
		
		while(true)
		{
			System.out.println("Please select a question:");
			System.out.println("1. Which action did you take on turn X?");
			System.out.println("2. Why did you take the action you did on turn X?");
			System.out.println("3. Print the trace from Project 3.");
			System.out.println("4. Exit.");
			System.out.print("Selection: ");
			String input1 = console.next();
			if(input1.equals("1"))
			{
				System.out.print("Agent (X or O): ");
				String input2 = console.next();
				if(input2.equals("X"))
				{
					System.out.print("Turn number: ");
					String input3 = console.next();
					if(Integer.parseInt(input3) <= p1.moves.size())
					{
						System.out.println("During turn " + input3 + ", Agent X took the " + spotNames[p1.moves.get(Integer.parseInt(input3)-1)] + ".\n");
					}
					else
					{
						System.out.println("Please choose a valid turn number.\n");
						continue;
					}
				}
				else if(input2.equals("O"))
				{
					System.out.print("Turn number: ");
					String input3 = console.next();
					if(Integer.parseInt(input3) <= p2.moves.size())
					{
						System.out.println("During turn " + input3 + ", Agent O took the " + spotNames[p2.moves.get(Integer.parseInt(input3)-1)] + ".\n");
					}
					else
					{
						System.out.println("Please choose a valid turn number.\n");
						continue;
					}
				}
				else
				{
					System.out.println("Please choose a valid agent.\n");
					continue;
				}
			}
			else if(input1.equals("2"))
			{
				System.out.print("Agent (X or O): ");
				String input2 = console.next();
				if(input2.equals("X"))
				{
					System.out.print("Turn number: ");
					String input3 = console.next();
					if(Integer.parseInt(input3) <= p1.reasons.size())
					{
						System.out.println("During turn " + input3 + ", Agent X made the move because " + p1.reasons.get(Integer.parseInt(input3)-1) + "\n");
					}
					else
					{
						System.out.println("Please choose a valid turn number.\n");
						continue;
					}
				}
				else if(input2.equals("O"))
				{
					System.out.print("Turn number: ");
					String input3 = console.next();
					if(Integer.parseInt(input3) <= p2.reasons.size())
					{
						System.out.println("During turn " + input3 + ", Agent O made the move because " + p2.reasons.get(Integer.parseInt(input3)-1) + "\n");
					}
					else
					{
						System.out.println("Please choose a valid turn number.\n");
						continue;
					}
				}
				else
				{
					System.out.println("Please choose a valid agent.\n");
					continue;
				}
			}
			else if(input1.equals("3"))
			{
				System.out.println(TicTacToe.trace);
			}
			else if(input1.equals("4"))
			{
				System.out.println("Exiting...");
				break;
			}
			else
			{
				System.out.println("Please make a valid selection.\n");
			}
		}
		console.close();
	}
}
