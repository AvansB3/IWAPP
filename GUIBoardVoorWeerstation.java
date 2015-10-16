import java.util.*;
/**
 * Write a description of class GUIBoardVoorWeerstation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUIBoardVoorWeerstation
{
        private static ArrayList<Integer> getNumbers(int integer)
    {
        String strNum = "" + integer;
        int strLength = strNum.length();
        ArrayList<Integer> stuffs = new ArrayList<Integer>();
        
        for (int i = 0; i < strLength; ++i) {
          
          char c = strNum.charAt(i);
          int digit = Character.getNumericValue(c);
          stuffs.add(digit);
          
        }
        return stuffs;
    }
    
    private static int berekenPuntPositie(double seh)
    {
        return 0;
    }
    
    public void inDisplayGroepPlaatsInteger (int DisplayGroep, int waarde)
    {
        int index = DisplayGroep;
        ArrayList<Integer> numbers = getNumbers(waarde);
        Collections.reverse(numbers);
        
        for(int i : numbers)
        {
            IO.writeShort(index, i);
            index+=2;
        }
    }
    
    public void inDisplayGroepPlaatsDouble (int DisplayGroep, double waarde)
    {
//         int index = DisplayGroep;
//         ArrayList<Integer> numbers = getNumbers(waarde);
//         Collections.reverse(numbers);
//         
//         for(int i : numbers)
//         {
//             IO.writeShort(index, i);
//             index+=2;
//         }


    }
    
    public void inDotDisplayPlaatsTekst (String tekst)
    {
        GebruikGB_DotDisplay.drawText(tekst);
    }
}
