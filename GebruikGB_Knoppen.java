import java.util.*;
/**
 * Write a description of class Knopcontrol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GebruikGB_Knoppen
{

    public static boolean blauweKnopLinks()
    {
        return IO.readShort(0x90) != 0;
    }
    
     public static boolean blauweKnopRechts()
    {
        if( IO.readShort(0x100) != 0 )
        {
            return true;
        } 
        else
        {
            return false;
        }
    }


    public static void knopThread()
    {
        int i =1000;
        while (true)
        {
            if( IO.readShort(0x80) != 0 )
            {
                plaatsenCijfer(i);
            } 

            if( IO.readShort(0x80) == 0 )
            {
                maakschoonbeter();
            } 
            
            if(blauweKnopLinks() == true)
            {
            i--;
        }

      
        if(blauweKnopRechts() == true)
        {
            i++;
        }
        
        if(blauweKnopLinks()== false && blauweKnopRechts() == false)
        {
            i++;
        }
            IO.delay(200);
        }
    }

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

    public static void plaatsenCijfer(int cijfer)
    {
        int index = 0x10;
        ArrayList<Integer> numbers = getNumbers(cijfer);
        Collections.reverse(numbers);

        for(int i : numbers)
        {
            IO.writeShort(index, i);
            index+=2;
        }

    }

    public static void maakschoonbeter()
    {
        for(int i = 0x10; i < 0x20; i += 2)
        {
            IO.writeShort(i, 1 << 8);
        }
    }
}
