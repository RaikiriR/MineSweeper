package minesweeper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class MineSolver {
	private static boolean hasNext = false;
	private static int y;
	private static int x;
	private static int field = 1;
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner fileScanner= new Scanner(new FileReader("C:\\Users\\Justin Ching\\Desktop\\msc\\minesweeper\\mines.txt"));
		String[][] minefield; 
		
		while(fileScanner.hasNextInt())
		{
			System.out.println("Field #" + field + ":");
			minefield = readArray(fileScanner);
			minefield = initializeMinefield(minefield);
			minefield = solveMinefield(minefield);
			field += 1;
			System.out.println();
		}
		
		
		
	}

	private static String[][] solveMinefield(String[][] minefield)
	{
		y = y -2;
		x = x - 2;
		for(int i=0; i < y; i++)
		{
			for(int o=0; o < x; o++)
			{
				System.out.print(mineProximity(minefield,i+1,o+1));
			}
			System.out.println();
		}
		
		return minefield;
	}
	
	private static String mineProximity(String[][] minefield, int y, int x)
	{
		int mines = 0;
		if(minefield[y][x].contentEquals("*"))
		{
			return "*";
		}
		//Top
		if(minefield[y-1][x-1].contentEquals("*"))
		{
			mines += 1;
		}
		if(minefield[y-1][x].contentEquals("*"))
		{
			mines += 1;
		}
		if(minefield[y-1][x+1].contentEquals("*"))
		{
			mines += 1;
		}
		
		//Middle
		if(minefield[y][x-1].contentEquals("*"))
		{
			mines += 1;
		}
		if(minefield[y][x+1].contentEquals("*"))
		{
			mines += 1;
		}
		
		//Bottom
		if(minefield[y+1][x-1].contentEquals("*"))
		{
			mines += 1;
		}
		if(minefield[y+1][x].contentEquals("*"))
		{
			mines += 1;
		}
		if(minefield[y+1][x+1].contentEquals("*"))
		{
			mines += 1;
		}
		
		return Integer.toString(mines);
		
	}
	
	private static String[][] initializeMinefield(String[][] minefield) 
	{
		String[][] newminefield = new String[y+2][x+2];
		for(int i = 0; i < y; i++)
		{
			for(int o = 0; o < x; o++)
			{
				newminefield[i+1][o+1] = minefield[i][o];
			}
		}
		for(int i = 0; i < y+2; i++)
		{
			for(int o = 0; o < x+2; o++)
			{
				if(i==0 || i == y+1 || o == 0 || o == x+1)
				{
					newminefield[i][o] = ".";
				}
			}
		}
		y = y+2;
		x = x+2;
		return newminefield;
	}

	private static String[][] readArray(Scanner file)
	{
		y = file.nextInt();
		x = file.nextInt();
		
		String[][] minefield = new String[y][x];
		String[] before = new String[y];
		String read;
		//System.out.println(file.next().charAt(1));
	    for(int i=0; i<y; i++)
	    {
            before[i] = file.next();
            for(int o = 0; o < x; o++)
            {
            	read = before[i];
            	minefield[i][o] = Character.toString(read.charAt(o));
            }
            file.nextLine();
          
	    }
		
		return minefield;
	}
	
	
}
