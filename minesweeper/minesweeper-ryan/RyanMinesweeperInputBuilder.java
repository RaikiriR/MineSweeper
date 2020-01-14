/**
 * Ryan Bucherl - 1/9/2020 - Minesweeper input builder
 */

import java.io.*;
import java.util.Scanner;

public class RyanMinesweeperInputBuilder
{
   public static void main(String[] args) throws FileNotFoundException
   {
      String fileName;
      File outputFile = null;
      PrintStream fout = null;
      Scanner kb = new Scanner(System.in);
      
      do{
         System.out.println("Enter output file name");
         fileName = kb.nextLine();
         fout = openOutputFile(fileName, outputFile);
      }while(fout == null);
      
      while(!generateMinefield(kb, fout)){}
      
      System.out.println("Success");
   }
   
   //Opens/creates output file and returns a PrintStream object to write
   private static PrintStream openOutputFile(String name, File output)
   {
      PrintStream ps = null;
      
      try{
         output = new File(name);
         ps = new PrintStream(output);
      }catch(Exception e){
         System.out.println(e.getMessage());
      }
      return ps;
   }
   
   //Returns false while "0 0" is not entered
   private static boolean generateMinefield(Scanner kb, PrintStream fout)
   {
      System.out.println("Enter minefield specifications: Rows[enter], columns[enter], percent_mines[enter])");
      int rows = kb.nextInt();
      int cols = kb.nextInt();
      if(rows == 0 || cols == 0)
      {
         fout.print("0 0");
         return true;   
      }
      int mines = kb.nextInt();
      
      fout.println(rows + " " + cols);
      for(int r = 0; r < rows; r++)
      {
         for(int c = 0; c < cols; c++)
         {
            if(mines > (int)(Math.random() * 100))
               fout.print("*");
            else
               fout.print(".");
         }
         fout.println();
      }
      return false;
   }
}