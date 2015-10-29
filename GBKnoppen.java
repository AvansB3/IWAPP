
/**
 * Write a description of class GBKnoppen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GBKnoppen
{

    /**
     * Constructor for objects of class GBKnoppen
     */
    public GBKnoppen()
    {

    }
    
    public static boolean blauweKnopLinks()
    {
        if(IO.readShort(0x90) != 0)
        System.out.println("Wauw linker knop");
        return IO.readShort(0x90) != 0;
    }
    
     public static boolean blauweKnopRechts()
    {
        if(IO.readShort(0x100) != 0)
        System.out.println("Wauw rechter knop");
        return IO.readShort(0x100) != 0;
    }
    
    public static void aanUitThread(AvansWeerstation weerstation)
    {
        boolean state=false;
        while(true)
        {
            if (IO.readShort(0x80) != 0 && !state){
                weerstation.start();
                state=true;
            }
            if (IO.readShort(0x80) == 0 && state){
                weerstation.stop();
                state=false;
            }
        }
        
    }
}
