import java.util.*;
/**
 * Write a description of class GebruikGB_DotDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GebruikGB_DotDisplay
{
    private static int xpadding = 1;
    private static int ypadding = 1;
    
    private static ArrayList<Integer> temperaturen = new ArrayList<Integer>();
    
    public static void drawText(String txt)
    {
        for(char c : txt.toCharArray())
        {
            IO.writeShort(0x40,c);
        }
    }
    
    public static void O_0__maakSchoon()
    {
        for(int i = 0x10; i < 0x20; i += 2)
        {
            IO.writeShort(i, 256);
        }
        IO.writeShort(0x40,0xFE);
            
        IO.writeShort(0x40,0x01);
    }
    
    public static void O_1__voorbeeld_1()
    {
        IO.writeShort(0x40,'T');
        IO.writeShort(0x40,'I');
        IO.writeShort(0x40,'\n');
        IO.writeShort(0x40,'2');
        IO.writeShort(0x40,'\n');
        IO.writeShort(0x40,'3');
    }
    
    public static void O_2__doeDitMaarEensNa()
    {
        drawText("Doe dit maar eens na");
    }
    
    public static void O_3__pixelTest()
    {
         int opcode = 3;
         IO.writeShort(0x42, opcode << 12); // Clear display
        
         int x,y;
         opcode = 1;
         for( int idx = 0; idx < 1000; idx++ )
         {
             x = (int) (Math.random()*128);
             y = (int) (Math.random()*32);
             IO.writeShort(0x42, opcode << 12 | x << 5 | y);
             IO.delay(100);
         }
     }
    
    public static void O_4c_tekenAsXzonderSchoonmaken()
    {
        int y = 31;
        int OPwrite = 1;
        for(int x = 0; x < 128; x++)
        {
            IO.writeShort(0x42, OPwrite << 12 | x << 5 | y);
        }
    }
     
    public static void O_4a_tekenAsXmetSchoonmaken()
    {
        O_0__maakSchoon();
        O_4c_tekenAsXzonderSchoonmaken();
    }
    
    public static void O_4b_tekenAsYmetSchoonmaken()
    {
        O_0__maakSchoon();
        O_4d_tekenAsYzonderSchoonmaken();
    }
    
    public static void O_4d_tekenAsYzonderSchoonmaken()
    {
        int x = 0;
        int OPwrite = 1;
        for(int y = xpadding; y < 32; y++)
        {
            IO.writeShort(0x42, OPwrite << 12 | x << 5 | y);
        }
    }
    
    public static void O_5a_tekenAsXenAsY()
    {
        O_0__maakSchoon();
        O_4c_tekenAsXzonderSchoonmaken();
        O_4d_tekenAsYzonderSchoonmaken();
    }
    
    public static void O_5b_tekenXYwaardenMetAssen(int x, int y)	
    {
        O_5a_tekenAsXenAsY();
        IO.writeShort(0x42, 1 << 12 | x << 5 | 31-y);
    }
    
    public static void O_5c_tekenXYwaardenZonderAssen(int x, int y)
    {
        if(y < 0 || y >= 32)
            return;
        IO.writeShort(0x42, 1 << 12 | x << 5 | 31-y);
    }
    
    public static void O_5d_tekenParabool()
    {
        O_5a_tekenAsXenAsY();
        for(int x = xpadding; x < 128; x++)
        {
            int y = (int)Math.round(0.1 * Math.pow(x,2) - 10);
            O_5c_tekenXYwaardenZonderAssen(x,y);
        }
        
    }
    
    private static void vulWaarden()
    {
        //handige methode om alle temperaturen in een ArrayList te plaatsen
        //Uuuh waar vandaan?
    }
    
    public static void O_5e_tekenTemperatuurGrafiek()
    {
         O_5a_tekenAsXenAsY();
       List<Integer> lastTemps = temperaturen.subList(temperaturen.size()-5, temperaturen.size());
       int i = 1;
       for(int t : lastTemps)
       {
           O_5c_tekenXYwaardenZonderAssen(i, t);
        }
    }
    
    public static void O_6a_tekenXas (int positieXas)
    {
        int y = 32-positieXas;
        int OPwrite = 1;
        for(int x = 0; x < 128; x++)
        {
            IO.writeShort(0x42, OPwrite << 12 | x << 5 | y);
        }
    }
    
    public static void O_6b_tekenYas (int positieYas)
    {
        int x = positieYas;
        int OPwrite = 1;
        for(int y = xpadding; y < 32; y++)
        {
            IO.writeShort(0x42, OPwrite << 12 | x << 5 | y);
        }
    }
    
    public static void O_6c_tekenXasEnYas (int positieXas, int positieYas)
    {
        O_6a_tekenXas(positieXas);
        O_6b_tekenYas(positieYas);
    }
    
    public static int O_6d_berekenPositieX (int waardeX, int positieXas)
    {
        return waardeX + positieXas;
    }
    
    public static int O_6e_berekenPositieY (int waardeY, int positieYas)
    {
        return 32-positieYas+waardeY;
    }
    
    public static void O_6f_tekenTemparetuur(int positieXas, int positieYas)
    {
        O_5a_tekenAsXenAsY();
       List<Integer> lastTemps = temperaturen.subList(temperaturen.size()-5, temperaturen.size());
       int i = positieXas;
       for(int t : lastTemps)
       {
           O_5c_tekenXYwaardenZonderAssen(i, O_6e_berekenPositieY(positieYas, t));
        }
    }
}
