import java.io.*;
import java.util.*;

/*
   A Word game that prompts the user to provide animal's
   names for the giving first letter as many as te user can.
*/
public class P5DUI {
   
   // pre: File name must be legal (Throws FileNotFoundException if not)
   // post: Handles the game cycle.
   public static void main(String[] args) throws FileNotFoundException {
      intro();
      List<String> dict = new ArrayList<String>();
      Scanner input = new Scanner(new File("animalDict2.txt"));
      while(input.hasNextLine()) {
         dict.add(input.nextLine());
      }
      Scanner console = new Scanner(System.in);
      
      int point = 0;
      boolean newGame = true;
      while(newGame) {
         System.out.println("Start Shuffling? ");
         console.next();
         Random r = new Random();
         char c = (char) (r.nextInt(26) + 'a');
         System.out.println("Animal ... ");
         System.out.println("Starting with Letter ... ");
         System.out.println(c);
         System.out.println();
         P5DManager p = new P5DManager(dict, c);
         boolean giveUp = false;
         int count = p.getCount();
      
         while(!giveUp && count != 0) {
            System.out.println("Number of words left : " + count);
            System.out.print("Words? ");
            String word = console.next();
            boolean right = p.guess(word);
            if(right) {
               point += 100;
               System.out.println("Right!!");
            } else {
               point -= 50;
               System.out.println("WRONG!!!!");
            }
            System.out.println();
            count = p.getCount();
            if(count != 0) {   
               System.out.print("Give up? (Y/N) ");
               String s = console.next();
               if(s.substring(0,1).equalsIgnoreCase("y")) {
                  giveUp = true;
               }
            }
            System.out.println();
         }
         if(count == 0) {
            System.out.println("No words left for this letter!");
            System.out.println("Nice Job!!");
         }
         System.out.println("Current Point : " + point);
         System.out.print("Play another game? (Y/N) ");
         String s = console.next();
         if(s.substring(0,1).equalsIgnoreCase("n")) {
             newGame = false;
         }
      }
      System.out.println("Overall Point : " + point);
      System.out.println("Nice Game!");
   }
   
   // post: Prints the game's intro.
   public static void intro() {
      System.out.println("Pancasila 5 Dasar");
      System.out.println();
      System.out.println("The objective of this game is to guess as many");
      System.out.println("words as you can for the given letter, which will");
      System.out.println("be generated randomly, of the given topic.");
      System.out.println();
      System.out.println("Right words : 100 points");
      System.out.println("Wrong words : -50 points");
      System.out.println();
      System.out.println("Topic : Animal");
   }
}