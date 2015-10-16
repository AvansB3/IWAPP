import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class GebruikGB_Animatie here.
 * 
 * @author Michael
 * @version 13.3.7
 */
public class GebruikGB_Animatie
{
    private static int a = 1; //000000001
    private static int b = 2; //000000010
    private static int c = 4;
    private static int d = 8;
    private static int e = 16;
    private static int f = 32;
    private static int g  = 64;
    private static int dp = 128;
    private static int los = 256; //100000000
    
    public static int[] sequence = new int[]  {d, d|c|e, c|d|e|g, c|d|e|g|f|b, a|b|c|d|e|f|g, a|b|c|e|f|g, a|b|f|g, a|b|f, a};
    
    //public static int[] slangNoTrail = new int[] { b, c, d, e, f, a };


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
    
    public static void O_1__plaatsenVanEenCijfer(int cijfer)
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
    public static void O_2a_maakSchoon()
    {
        IO.writeShort(0x10, los);
        IO.writeShort(0x12, los);
        IO.writeShort(0x14, los);
        IO.writeShort(0x16, los);
        IO.writeShort(0x18, los);
    }
    public static void O_2b_maakSchoonBeter()
    {
        for(int i = 0x10; i < 0x20; i += 2)
        {
            IO.writeShort(i, los);
        }
    }
    
    public static void O_3a_rondLopenInEenDisplayEenKeer()
    {
        O_4a_rondlopenOpMeerdereDisplaysTichKeer(0x10, 0x20, 1);
    }
    
    public static void O_3b_rondLopenInEenDisplayEenKeer(int locatie)
    {
        O_4a_rondlopenOpMeerdereDisplaysTichKeer(locatie, locatie+2, 1);
    }
    
    public static void O_3c_rondLopenInEenDisplayDriekeer()
    {
        O_4a_rondlopenOpMeerdereDisplaysTichKeer(0x10, 0x20, 3);
    }
    
    public static void O_3d_rondLopenInEenDisplayTichKeer(int locatie, int tich)
    {
        O_4a_rondlopenOpMeerdereDisplaysTichKeer(locatie, locatie+2, tich);
    }
    
    public static void O_4a_rondlopenOpMeerdereDisplaysTichKeer( int beginlocatie , int eindlocatie , int tich )
    {
        O_4b_rondlopenTichKeerOpMeerdereDisplays(beginlocatie, eindlocatie, tich);
    }
    
    public static void O_4b_rondlopenTichKeerOpMeerdereDisplays ( int beginlocatie , int eindlocatie , int tich )
    {
        for(int a = 0; a < tich; a++)
        {
            for(int step : sequence)
            {
                for(int i = beginlocatie; i < eindlocatie; i += 2)
                {
                    IO.writeShort(i, los);
                    IO.writeShort(i, los|step);
            }
                try{
                    Thread.sleep(500);
                }catch(Exception E)
                {}
                O_2b_maakSchoonBeter();
            }
        }
    }
}
