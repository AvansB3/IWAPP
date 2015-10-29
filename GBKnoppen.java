
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
        return IO.readShort(0x0090) == 1;
    }

    public static boolean blauweKnopRechts()
    {
        return IO.readShort(0x0100) == 1;
    }

    public static void knopThread(GuiFaceMenu menu)
    {
        boolean left = false;
        boolean right = false;
        boolean red = false;
        while(true)
        {
            if(IO.readShort(0x0090)==1 && !left)
            {
                System.out.println("linker knop in");
                menu.knopLinks();
                left = true;
            }
            if(IO.readShort(0x0090)==0 && left)
                left = false;

            if(IO.readShort(0x0100)==1 && !right)
            {
                System.out.println("rechter knop in");
                menu.knopRechts();
                right = true;
            }
            if(IO.readShort(0x0100)==0 && right)
                right = false;

            if(IO.readShort(0x0080)==1 && !red)
            {
                System.out.println("rode knop in");
                menu.start();
                red = true;
            }
            if(IO.readShort(0x0080)==0 && red)
            {
                System.out.println("rode knop uit");
                menu.stop();
                red = false;
            }
            IO.delay(1000);
        }
    }
}

