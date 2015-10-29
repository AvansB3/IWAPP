
/**
 * Write a description of class GBDotMatrix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GBDotMatrix
{

    /**
     * Constructor for objects of class GBDotMatrix
     */
    public GBDotMatrix()
    {

    }

    public static void drawText(String txt, boolean clear)
    {
        if(clear)
            clrDMDisplay();
        for(char c : txt.toCharArray())
        {
            IO.writeShort(0x40,c);
        }
    }

    public static void clrDMDisplay()
    {
        IO.writeShort(0x40,0xFE);
        IO.writeShort(0x40,0x01);
    } 

}
