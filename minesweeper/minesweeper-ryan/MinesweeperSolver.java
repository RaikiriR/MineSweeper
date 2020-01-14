import java.util.Scanner;

public class MinesweeperSolver{
   private static int numCols, numRows, curBoard;
   
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      boolean hasData = true;
      curBoard = 0;
      
      do{
         hasData = nextBoard(kb);
      }while(hasData && kb.hasNextLine());
   }

   private static boolean nextBoard(Scanner kb){
      numRows = kb.nextInt();
      numCols = kb.nextInt();
      curBoard++;
      if(numRows == 0 || numCols == 0)
         return false;
      
      char[][] board = new char[numRows + 2][numCols + 2];
      System.out.println(board.length + " " + board[0].length);
      populateBoard(kb, board);
      solveBoard(board);
      printBoard(board);
      
      return true;
   }
   
   private static void populateBoard(Scanner kb, char[][] board){
      populateBoardEdge(board);
      String str;
      
      for(int curRow = 1; curRow <= numRows; curRow++){
         str = kb.next();
         for( int curCol = 1; curCol <= numCols; curCol++){
            board[curCol][curRow] = str.charAt(curCol - 1);
         }
      }
   }
   
   private static void populateBoardEdge(char[][] board){
      for(int curCol = 0; curCol < numCols; curCol++){
         System.out.println(curCol + " " + numCols);
         board[curCol][0] = '.';
         board[curCol][numCols + 1] = '.';
      }
      for(int curRow = 0; curRow < numRows; curRow++){
         board[0][curRow] = '.';
         board[numRows + 1][curRow] = '.';
      }
   }
   
   private static void solveBoard(char[][] board){
      for(int y = 1; y <= numRows; y++){
         for(int x = 1; x <= numCols; x++){
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
      
      
      return mines;
   }
   
   private static void printBoard(char[][] board){
      System.out.println("Field #" + curBoard + ":");
      for(int y = 1; y <= numRows; y++)
      {
         for(int x = 1; x <= numCols; x++)
         {
            System.out.print(board[x][y]);
         }
         System.out.println();
      }
      System.out.println();
   }
}