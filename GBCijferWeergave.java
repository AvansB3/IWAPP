
import java.util.*;
/**
 * Write a description of class Cijferweergave here.
 * 
 * @author Cas Koopmans en Rick van Gils
 * @version TI 1.1 - 2015
 */
public class GBCijferWeergave
{
    // instance variables - replace the example below with your own
    private static int dp = 128;
    private static int los = 256; //100000000
    private static int[] losInts = new int[]{63, 6, 91, 79, 102, 109, 124, 7, 127, 111};
    /**
     * Constructor for objects of class Cijferweergave
     */
    public GBCijferWeergave()
    {
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

    public static void schrijfInt(int cijfer)
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

    public static void schrijfDouble(int index, double cijfer)
    {
        String n = new Double(cijfer).toString();
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c : n.toCharArray()) {
            chars.add(c);
        }
        
        List<Character> _chars;
        
        if(index==0x10)
            _chars = chars.subList(0, 6);
        else
            _chars = chars.subList(0, 4);
            
        Collections.reverse(_chars);
        boolean writeDot = false;
        for(char c : _chars)
        {
            int num = Character.getNumericValue(c);
            if(num==-1)
                writeDot = true;

            else
            {

                if(writeDot)
                {
                    IO.writeShort(index, los|dp|losInts[num]);
                    writeDot = false;
                }
                else
                    IO.writeShort(index, num);
                index+=2;
            }
        }
    }
    
    public static void schrijfString(int index, String s)
    {
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        
        Collections.reverse(chars);
        
        for(char c : chars)
        {
            IO.writeShort(index, c);
            index+=2;
        }
    }
    
    public static void maakAlleLeeg()
    {
        for ( int z = 0x8; z <=0x18; z += 2)
        {
            IO.writeShort(z, 256);
        }
    }
}
