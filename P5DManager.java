import java.util.*;

/*
   Handles the PD5 game mechanics
*/
public class P5DManager {

   private Set<String> dict;
   private int count;
   
   // pro: Takes a list of strings and a char to construct
   //       a Set of strings that start with the char.
   public P5DManager(List<String> list, char letter) {
      dict = new HashSet<String>();
      for(String s : list) {
         if(s.toLowerCase().charAt(0) == letter) {
            dict.add(s.toLowerCase());
            count++;
         }
      }
   }
   
   // pro: Returns count.
   public int getCount() {
      return count;
   }
   
   // pro: Returns true if the string parameter is
   //       in the set.
   public boolean guess(String s) {
      if(dict.contains(s.toLowerCase())) {
         dict.remove(s.toLowerCase());
         count--;
         return true;
      } else {
         return false;
      }
   }
}