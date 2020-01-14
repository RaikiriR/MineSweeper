import java.util.Scanner;

public class MinesweeperSolver{
   private static int rows, cols, curBoard;
   
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      boolean hasData = true;
      curBoard = 0;
      
      do
      {
         hasData = nextBoard(kb);
      }while(hasData && kb.hasNextLine());
   }

   private static boolean nextBoard(Scanner kb)
   {
      rows = kb.nextInt();
      cols = kb.nextInt();
      curBoard++;
      if(cols == 0 || rows == 0)
         return false;
      
      char[][] board = new char[rows + 2][cols + 2];
      populateBoard(kb, board);
      solveBoard(board);
      printBoard(board);
      
      return true;
   }
   
   private static void populateBoard(Scanner kb, char[][] board)
   {
      populateBoardEdge(board);
      String str;
      
      for(int curRow = 1; curRow <= rows; curRow++)
      {
    	  str = kb.next();
    	  for(int curCol = 1; curCol <= cols; curCol++)
    	  {
    		  board[curRow][curCol] = str.charAt(curCol -1);
    	  }
      }
   }
   
   private static void populateBoardEdge(char[][] board){
	   for(int curRow = 0; curRow < rows+2; curRow++)
	   {
	         board[curRow][0] = '.';
	         board[curRow][cols + 1] = '.';
	   }
	   for(int curCol = 0; curCol < cols+2; curCol++)
	   {
	         board[0][curCol] = '.';
	         board[rows + 1][curCol] = '.';
	   }
   }
   
   private static void solveBoard(char[][] board){
      for(int y = 1; y <= cols; y++)
      {
         for(int x = 1; x <= rows; x++)
         {
            if(board[x][y] == '.')
            {
               int mines = checkForMines(x, y, board);
               board[x][y] = Character.forDigit(mines, 10);
            }
         }
      }
   }
   
   private static int checkForMines(int x, int y, char[][]board){
      int mines = 0;
      if(board[x-1][y-1] == '*') mines++;
      if(board[x-1][y] == '*') mines++;
      if(board[x-1][y+1] == '*') mines++;
      if(board[x][y-1] == '*') mines++;
      if(board[x][y+1] == '*') mines++;
      if(board[x+1][y-1] == '*') mines++;
      if(board[x+1][y] == '*') mines++;
      if(board[x+1][y+1] == '*') mines++;
      
      return mines;
   }
   
   private static void printBoard(char[][] board){
      System.out.println("Field #" + curBoard + ":");
      for(int curRow = 1; curRow <= rows; curRow++)
      {
    	  for(int curCol = 1 ; curCol <= cols; curCol++)
    	  {
    		  System.out.print(board[curRow][curCol]);
    	  }
    	  System.out.println();
      }
      System.out.println();
	  
   }
}