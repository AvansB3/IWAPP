

/**
 * Write a description of class Cijferweergave here.
 * 
 * @author Cas Koopmans en Rick van Gils
 * @version TI 1.1 - 2015
 */
public class GebruikGB_CijferWeergave
{
    // instance variables - replace the example below with your own
    private static int index;
    private static int herhaal;
    /**
     * Constructor for objects of class Cijferweergave
     */
    public GebruikGB_CijferWeergave()
    {
        index = 0;
        herhaal = 0;
    }

    public static void O_3__schrijfCijfersInEenDisplay()
    {
        while (herhaal < 3)
        {
            for (int index = 0; index < 10; index++)
            {
                IO.writeShort(0x10, index);
                try{
                    Thread.sleep(500);
                }catch(Exception E)
                {}
                IO.writeShort(0x10, 256);
            }
            herhaal++;
        }
    }

    public static void O_3__schrijfCijfersInAlleDisplays()
    {
        while (herhaal < 3)
        {
            for (int index = 0; index < 10; index++)
            {
                IO.writeShort(0x10, index);
                IO.writeShort(0x12, index);
                IO.writeShort(0x14, index);
                IO.writeShort(0X16, index);
                IO.writeShort(0x18, index);
                try{
                    Thread.sleep(500);
                }catch(Exception E)
                {}
                IO.writeShort(0x10, 256);
                IO.writeShort(0x12, 256);
                IO.writeShort(0x14, 256);
                IO.writeShort(0x16, 256);
                IO.writeShort(0x18, 256);
            }
            herhaal++;
        }
    }
}
