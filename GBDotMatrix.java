
/**
 * Write a description of class GBDotMatrix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GBDotMatrix
{
    private String windRichtingGUI;
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

    public static void windRichting(WindRichting windrichting)
    {   
        clrDMDisplay();
        if (windrichting == WindRichting.Error){
            drawText("De windrichting heeft \ngeen waarde", true);
            IO.delay(2000);
            format();
        }
        if (windrichting == WindRichting.Noord){
            drawText("De windrichting is:\nNoord", true);
            IO.delay(2000);
            format();
            IO.writeShort(0x42, 1 << 12 | 64 << 5 | 9);
            IO.writeShort(0x42, 1 << 12 | 64 << 5 | 10);
            IO.writeShort(0x42, 1 << 12 | 63 << 5 | 10);
            IO.writeShort(0x42, 1 << 12 | 65 << 5 | 10);
            IO.writeShort(0x42, 1 << 12 | 64 << 5 | 11);
            IO.writeShort(0x42, 1 << 12 | 64 << 5 | 12);
            IO.writeShort(0x42, 1 << 12 | 64 << 5 | 13);
            IO.writeShort(0x42, 1 << 12 | 63 << 5 | 13);
            IO.writeShort(0x42, 1 << 12 | 65 << 5 | 13);
        }
        if (windrichting == WindRichting.Zuid){
            drawText("De windrichting is:\nZuid", true);
            IO.delay(2000);
            format();
            IO.writeShort(0x42, 1 << 12 | 64 << 5 | 23);
            IO.writeShort(0x42, 1 << 12 | 64 << 5 | 22);
            IO.writeShort(0x42, 1 << 12 | 63 << 5 | 22);
            IO.writeShort(0x42, 1 << 12 | 65 << 5 | 22);
            IO.writeShort(0x42, 1 << 12 | 64 << 5 | 21);
            IO.writeShort(0x42, 1 << 12 | 64 << 5 | 20);
            IO.writeShort(0x42, 1 << 12 | 64 << 5 | 19);
            IO.writeShort(0x42, 1 << 12 | 63 << 5 | 19);
            IO.writeShort(0x42, 1 << 12 | 65 << 5 | 19);
        }
        if (windrichting == WindRichting.Oost){
            drawText("De windrichting is:\nOost", true);
            IO.delay(2000);
            format();
            IO.writeShort(0x42, 1 << 12 | 67 << 5 | 15);
            IO.writeShort(0x42, 1 << 12 | 70 << 5 | 15);
            IO.writeShort(0x42, 1 << 12 | 67 << 5 | 16);
            IO.writeShort(0x42, 1 << 12 | 68 << 5 | 16);
            IO.writeShort(0x42, 1 << 12 | 69 << 5 | 16);
            IO.writeShort(0x42, 1 << 12 | 70 << 5 | 16);
            IO.writeShort(0x42, 1 << 12 | 71 << 5 | 16);
            IO.writeShort(0x42, 1 << 12 | 67 << 5 | 17);
            IO.writeShort(0x42, 1 << 12 | 70 << 5 | 17);
        }
        if (windrichting == WindRichting.West){
            drawText("De windrichting is:\nWest", true);
            IO.delay(2000);
            format();
            IO.writeShort(0x42, 1 << 12 | 61 << 5 | 15);
            IO.writeShort(0x42, 1 << 12 | 58 << 5 | 15);
            IO.writeShort(0x42, 1 << 12 | 61 << 5 | 16);
            IO.writeShort(0x42, 1 << 12 | 60 << 5 | 16);
            IO.writeShort(0x42, 1 << 12 | 59 << 5 | 16);
            IO.writeShort(0x42, 1 << 12 | 58 << 5 | 16);
            IO.writeShort(0x42, 1 << 12 | 57 << 5 | 16);
            IO.writeShort(0x42, 1 << 12 | 61 << 5 | 17);
            IO.writeShort(0x42, 1 << 12 | 58 << 5 | 17);
        }
        if (windrichting == WindRichting.NoordOost){
            drawText("De windrichting is:\nNoord-Oost", true);
            IO.delay(2000);
            format();
            IO.writeShort(0x42, 1 << 12 | 68 << 5 | 10);
            IO.writeShort(0x42, 1 << 12 | 70 << 5 | 10);
            IO.writeShort(0x42, 1 << 12 | 69 << 5 | 11);
            IO.writeShort(0x42, 1 << 12 | 70 << 5 | 12);
            IO.writeShort(0x42, 1 << 12 | 68 << 5 | 12);
            IO.writeShort(0x42, 1 << 12 | 67 << 5 | 13);
            IO.writeShort(0x42, 1 << 12 | 66 << 5 | 14);
        }
        if (windrichting == WindRichting.NoordWest){
            drawText("De windrichting is:\nNoord-West", true);
            IO.delay(2000);
            format();
            IO.writeShort(0x42, 1 << 12 | 60 << 5 | 10);
            IO.writeShort(0x42, 1 << 12 | 58 << 5 | 10);
            IO.writeShort(0x42, 1 << 12 | 59 << 5 | 11);
            IO.writeShort(0x42, 1 << 12 | 58 << 5 | 12);
            IO.writeShort(0x42, 1 << 12 | 60 << 5 | 12);
            IO.writeShort(0x42, 1 << 12 | 61 << 5 | 13);
            IO.writeShort(0x42, 1 << 12 | 62 << 5 | 14);
        }
        if (windrichting == WindRichting.ZuidWest){
            drawText("De windrichting is:\nZuid-West", true);
            IO.delay(2000);
            format();
            IO.writeShort(0x42, 1 << 12 | 60 << 5 | 22);
            IO.writeShort(0x42, 1 << 12 | 58 << 5 | 22);
            IO.writeShort(0x42, 1 << 12 | 59 << 5 | 21);
            IO.writeShort(0x42, 1 << 12 | 58 << 5 | 20);
            IO.writeShort(0x42, 1 << 12 | 60 << 5 | 20);
            IO.writeShort(0x42, 1 << 12 | 61 << 5 | 19);
            IO.writeShort(0x42, 1 << 12 | 62 << 5 | 18);
        }
        if (windrichting == WindRichting.ZuidOost){
            drawText("De windrichting is:\nZuid-Oost", true);
            IO.delay(2000);
            format();
            IO.writeShort(0x42, 1 << 12 | 68 << 5 | 22);
            IO.writeShort(0x42, 1 << 12 | 70 << 5 | 22);
            IO.writeShort(0x42, 1 << 12 | 69 << 5 | 21);
            IO.writeShort(0x42, 1 << 12 | 70 << 5 | 20);
            IO.writeShort(0x42, 1 << 12 | 68 << 5 | 20);
            IO.writeShort(0x42, 1 << 12 | 67 << 5 | 19);
            IO.writeShort(0x42, 1 << 12 | 66 << 5 | 18);
        }
    }

    public static void format()
    {
        clrDMDisplay();
        GBCijferWeergave.maakAlleLeeg();
        //stip
        IO.writeShort(0x42, 1 << 12 | 63 << 5 | 14);
        IO.writeShort(0x42, 1 << 12 | 64 << 5 | 14);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 14);
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 63 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 64 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 16);
        IO.writeShort(0x42, 1 << 12 | 63 << 5 | 16);        
        IO.writeShort(0x42, 1 << 12 | 64 << 5 | 16);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 16);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 16);
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 17);
        IO.writeShort(0x42, 1 << 12 | 63 << 5 | 17);
        IO.writeShort(0x42, 1 << 12 | 64 << 5 | 17);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 17);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 17);
        IO.writeShort(0x42, 1 << 12 | 63 << 5 | 18);
        IO.writeShort(0x42, 1 << 12 | 64 << 5 | 18);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 18);
        //N
        IO.writeShort(0x42, 1 << 12 | 61 << 5 | 1);
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 1);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 1);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 1);
        IO.writeShort(0x42, 1 << 12 | 67 << 5 | 1);
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 2);
        IO.writeShort(0x42, 1 << 12 | 63 << 5 | 2);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 2);        
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 3);
        IO.writeShort(0x42, 1 << 12 | 64 << 5 | 3);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 3);       
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 4);
        IO.writeShort(0x42, 1 << 12 | 64 << 5 | 4);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 4);        
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 5);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 5);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 5);        
        IO.writeShort(0x42, 1 << 12 | 61 << 5 | 6);
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 6);
        IO.writeShort(0x42, 1 << 12 | 63 << 5 | 6);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 6);        
        //O
        IO.writeShort(0x42, 1 << 12 | 76 << 5 | 13);
        IO.writeShort(0x42, 1 << 12 | 77 << 5 | 13);
        IO.writeShort(0x42, 1 << 12 | 78 << 5 | 13);
        IO.writeShort(0x42, 1 << 12 | 75 << 5 | 14);
        IO.writeShort(0x42, 1 << 12 | 79 << 5 | 14);
        IO.writeShort(0x42, 1 << 12 | 74 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 80 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 74 << 5 | 16);
        IO.writeShort(0x42, 1 << 12 | 80 << 5 | 16);
        IO.writeShort(0x42, 1 << 12 | 74 << 5 | 17);
        IO.writeShort(0x42, 1 << 12 | 80 << 5 | 17);
        IO.writeShort(0x42, 1 << 12 | 75 << 5 | 18);
        IO.writeShort(0x42, 1 << 12 | 79 << 5 | 18);
        IO.writeShort(0x42, 1 << 12 | 76 << 5 | 19);
        IO.writeShort(0x42, 1 << 12 | 77 << 5 | 19);
        IO.writeShort(0x42, 1 << 12 | 78 << 5 | 19);        
        //Z
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 25);
        IO.writeShort(0x42, 1 << 12 | 63 << 5 | 25);
        IO.writeShort(0x42, 1 << 12 | 64 << 5 | 25);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 25);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 25);
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 26);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 26);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 27);
        IO.writeShort(0x42, 1 << 12 | 64 << 5 | 28);
        IO.writeShort(0x42, 1 << 12 | 63 << 5 | 29);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 29);
        IO.writeShort(0x42, 1 << 12 | 62 << 5 | 30);
        IO.writeShort(0x42, 1 << 12 | 63 << 5 | 30);
        IO.writeShort(0x42, 1 << 12 | 64 << 5 | 30);
        IO.writeShort(0x42, 1 << 12 | 65 << 5 | 30);
        IO.writeShort(0x42, 1 << 12 | 66 << 5 | 30);        
        //W
        IO.writeShort(0x42, 1 << 12 | 46 << 5 | 13);
        IO.writeShort(0x42, 1 << 12 | 47 << 5 | 13);
        IO.writeShort(0x42, 1 << 12 | 50 << 5 | 13);
        IO.writeShort(0x42, 1 << 12 | 52 << 5 | 13);
        IO.writeShort(0x42, 1 << 12 | 53 << 5 | 13);
        IO.writeShort(0x42, 1 << 12 | 47 << 5 | 14);
        IO.writeShort(0x42, 1 << 12 | 50 << 5 | 14);
        IO.writeShort(0x42, 1 << 12 | 53 << 5 | 14);
        IO.writeShort(0x42, 1 << 12 | 47 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 49 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 50 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 51 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 53 << 5 | 15);
        IO.writeShort(0x42, 1 << 12 | 47 << 5 | 16);
        IO.writeShort(0x42, 1 << 12 | 49 << 5 | 16);
        IO.writeShort(0x42, 1 << 12 | 50 << 5 | 16);
        IO.writeShort(0x42, 1 << 12 | 51 << 5 | 16);
        IO.writeShort(0x42, 1 << 12 | 53 << 5 | 16);       
        IO.writeShort(0x42, 1 << 12 | 47 << 5 | 17);
        IO.writeShort(0x42, 1 << 12 | 49 << 5 | 17);
        IO.writeShort(0x42, 1 << 12 | 51 << 5 | 17);
        IO.writeShort(0x42, 1 << 12 | 53 << 5 | 17);       
        IO.writeShort(0x42, 1 << 12 | 48 << 5 | 18);
        IO.writeShort(0x42, 1 << 12 | 49 << 5 | 18);
        IO.writeShort(0x42, 1 << 12 | 51 << 5 | 18);
        IO.writeShort(0x42, 1 << 12 | 52 << 5 | 18);
        IO.writeShort(0x42, 1 << 12 | 48 << 5 | 19);
        IO.writeShort(0x42, 1 << 12 | 52 << 5 | 19);
    }
}
