/**
 * Ryan Bucherl - 1/11/2020 - Minesweeper solving algorithm
 */

import java.util.Scanner;

public class RyanMinesweeperSolver{
   private static int numRows, numCols, curBoard;
   
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      boolean hasNextBoard = true;
      curBoard = 0;
      
      do
      {
         hasNextBoard = nextBoard(kb);
      }while(hasNextBoard);
   }

   private static boolean nextBoard(Scanner kb)
   {
      numRows = kb.nextInt();
      numCols = kb.nextInt();
      curBoard++;
      if(numCols == 0 || numRows == 0)
         return false;
      
      char[][] board = new char[numRows + 2][numCols + 2];
      populateBoard(kb, board);
      solveBoard(board);
      printBoard(board);
      
      return true;
   }
   
   private static void populateBoard(Scanner kb, char[][] board)
   {
      populateBoardEdge(board);
      String str;
      
      for(int curRow = 1; curRow <= numRows; curRow++)
      {
    	  str = kb.next();
    	  for(int curCol = 1; curCol <= numCols; curCol++)
    	  {
    		  board[curRow][curCol] = str.charAt(curCol -1);
    	  }
      }
   }
   
   private static void populateBoardEdge(char[][] board){
	   for(int curRow = 0; curRow < numRows+2; curRow++)
	   {
	         board[curRow][0] = '.';
	         board[curRow][numCols + 1] = '.';
	   }
	   for(int curCol = 0; curCol < numCols+2; curCol++)
	   {
	         board[0][curCol] = '.';
	         board[numRows + 1][curCol] = '.';
	   }
   }
   
   private static void solveBoard(char[][] board){
      for(int y = 1; y <= numCols; y++)
      {
         for(int x = 1; x <= numRows; x++)
         {
            if(board[x][y] == '.')
            {
               int mines = checkForSurroundingMines(x, y, board);
               board[x][y] = Character.forDigit(mines, 10);
            }
         }
      }
   }
   
   private static int checkForSurroundingMines(int x, int y, char[][]board){
      int mines = 0;
      if(board[x-1][y-1] == '*')
      {
    	  mines++;
      }
      if(board[x-1][y] == '*')
      {
    	  mines++;
      }
      if(board[x-1][y+1] == '*')
      {
    	  mines++;
      }
      if(board[x][y-1] == '*')
      {
    	  mines++;
      }
      if(board[x][y+1] == '*')
      {
    	  mines++;
      }
      if(board[x+1][y-1] == '*')
      {
    	  mines++;
      }
      if(board[x+1][y] == '*')
      {
    	  mines++;
      }
      if(board[x+1][y+1] == '*')
      {
    	  mines++;
      }
      
      return mines;
   }
   
   private static void printBoard(char[][] board){
      System.out.println("Field #" + curBoard + ":");
      for(int curRow = 1; curRow <= numRows; curRow++)
      {
    	  for(int curCol = 1 ; curCol <= numCols; curCol++)
    	  {
    		  System.out.print(board[curRow][curCol]);
    	  }
    	  System.out.println();
      }
      System.out.println();
	  
   }
}