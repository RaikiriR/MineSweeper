package minesweeper;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MineCreator {

	private static int x;
	private static int y;
	private static Scanner input = new Scanner(System.in);
	private static PrintWriter out;
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		String[][] minefield;
		boolean end = false;
		PrintWriter out = new PrintWriter("C:\\Users\\Justin Ching\\Desktop\\msc\\minesweeper\\mines.txt");
		while(end != true)
		{
			minefield = minefieldInput();
			minefield = fillMinefield(minefield);
			printMinefield(minefield);
			printToFile(minefield,out);
			end = askReprint(out);
		}
		out.close();
	}
	
	private static String[][] minefieldInput()
	{
		x = 101;
		y = 101;
		while(y > 100 || y < 0)
		{
			System.out.println("Enter y (Must be between 0-100): ");
			y = input.nextInt();
		}
		while(x > 100 || x < 0)
		{
			System.out.println("Enter x (Must be between 0-100): ");
			x = input.nextInt();
		}
		
		String[][] minefield = new String[y][x];
		return minefield;
		
	}
	
	private static String[][] fillMinefield(String[][] minefield)
	{
		System.out.println("How much percent chance for a bomb? (0-100) :");
		int chanceForBomb = input.nextInt();
		int rollForBomb;
		
		for(int i=0; i < y; i++)
		{
			for(int o=0; o < x; o++)
			{
				rollForBomb = (int)(Math.random() * ((100 - 0) + 1) + 0);
				if(rollForBomb <= chanceForBomb && rollForBomb != 0)
				{
					System.out.println(rollForBomb + "-" + chanceForBomb);
					minefield[i][o] = "*";
				}
				else
				{
					minefield[i][o] = ".";
				}
			}
		}
		
		return minefield;
	}
	
	private static void printMinefield(String[][] minefield)
	{
		for(int i=0; i < y; i++)
		{
			for(int o=0; o < x; o++)
			{
				System.out.print(minefield[i][o]);
			}
			System.out.println();
		}
	}
	
	private static void printToFile(String[][] minefield,PrintWriter out)
	{
		out.print(y);
		out.print(" ");
		out.println(x);
			
		for(int i = 0; i<y; i++)
		{
			for (int j = 0; j<x; j++)
			{          
				out.print(minefield[i][j]);
			}
			out.println();
		}

	}
	
	private static boolean askReprint(PrintWriter out)
	{
		System.out.println("Do you want to add another? y for yes otherwise quitting");
		String x = input.next();
		if(x.equalsIgnoreCase("y"))
		{
			out.println();
			return false;
		}
		return true;
	}

}
