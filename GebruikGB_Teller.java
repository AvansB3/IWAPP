

// import java.awt.*;
// import java.awt.event.*;
// import java.util.*;

/**
 * Write a description of class Teller here.
 * 
 * 
 */
public class GebruikGB_Teller
{
    private static int a = 1; // zet a aan
    private static int b = 2; // zet b aan
    private static int c = 4; // zet c aan
    private static int d = 8; // zet d aan
    private static int e = 16; // zet e aan
    private static int f = 32; // zet f aan
    private static int g = 64; // zet g aan
    private static int Dot = 128; // zet het punt aan
    private static int Los = 256; // maakt het de display leeg
    
    private static int i=0; // Getal 0x10
    private static int j=0; // Getal 0x12
    private static int k=0; // Getal 0x14
    private static int l=0; // Getal 0x16
    private static int m=0; // Getal 0x18
    
    private static int SleepTime = 250; // tijd tussen het optteln van cijferdisplay 0x10
    private static int Value = 0; // begin getal
    

    /**
     * Constructor for objects of class Teller
     */
    public GebruikGB_Teller()
    {
        IO.init(); // conect met display
    }
    
    public static void Reconect()
    {
        IO.init(); // conect met display
    }
    
    public static void O_2a_maakSchoon() // maakt het bovenste display leeg
    {
        IO.writeShort(0x10, Los);
        IO.writeShort(0x12, Los);
        IO.writeShort(0x14, Los);
        IO.writeShort(0x16, Los);
        IO.writeShort(0x18, Los); 
    }
    
    public static void O_2b_maakSchoonBeter()
    {
        for ( int z = 0x8; z <=0x18; z += 2)
        {
            IO.writeShort(z, Los);
        }
    }
    
    public static void afdrukken()
    {
        IO.init();
        IO.writeShort(0x10, 7);
        IO.writeShort(0x12, 8);
        IO.writeShort(0x14, 8);
        IO.writeShort(0x16, 8);
        IO.writeShort(0x18, 8);
    }
    
    public static void O_3a_tellerMetNullen_Fout()
    {   
        IO.init(); // conect met display
        IO.writeShort(0x10, 0); // er komen standaard 0 te staan op het scherm
        IO.writeShort(0x12, 0);
        IO.writeShort(0x14, 0);
        IO.writeShort(0x16, 0);
        IO.writeShort(0x18, 0); 
        
        for(i=0; i<= 9; i++)
        {
            IO.writeShort(0x10, Los);
            IO.writeShort(0x10, i);
            try {Thread.sleep(SleepTime);}
            catch(Exception E){}
           
            if(m == 9&& l == 9 && k == 9 && j == 9 && i == 9) // als 99999 is dan reset board
            { m = -1; IO.writeShort(0x18, Los); IO.writeShort(0x18, m);}
            if (l == 9 && k == 9 && j == 9 && i == 9)  // als 9999 is dan m++ 
            { l = -1; m++; IO.writeShort(0x18, Los); IO.writeShort(0x18, m);}
            if (k == 9 && j == 9 && i == 9) // als 999 is dan k++
            { k = -1; l++; IO.writeShort(0x16, Los); IO.writeShort(0x16, l);}
            if (j == 9 && i == 9)  // als 99 is dan l++
            { j = -1; k++; IO.writeShort(0x14, Los); IO.writeShort(0x14, k);}
            if (i == 9) // als 9 is dan j++
            { i = -1; j++; IO.writeShort(0x12, Los); IO.writeShort(0x12, j);}
        }
       
    }
    
    public static void O_3a_tellerZonderNullen_Fout()
    {
        IO.init(); // conect met display
        for(i=0; i<= 9; i++) // oneindige loop, want onderste regel zorgt ervoor dat i != 9
        {
            IO.writeShort(0x10, Los);
            IO.writeShort(0x10, i);
            try {Thread.sleep(SleepTime);}
            catch(Exception E){}
           
            if(m == 9&& l == 9 && k == 9 && j == 9 && i == 9) // als 99999 is dan reset board
            { m = 0; l = 0; k = 0; j = 0; i = 0; // zet alle waarden terug op 0
              IO.writeShort(0x10, Los); // zet alle displays uit
              IO.writeShort(0x12, Los); 
              IO.writeShort(0x14, Los);
              IO.writeShort(0x16, Los);
              IO.writeShort(0x18, Los);
            }
            if (l == 9 && k == 9 && j == 9 && i == 9)  // als 9999 is dan m++
            { l = -1; m++; IO.writeShort(0x18, Los); IO.writeShort(0x18, m);}
            if (k == 9 && j == 9 && i == 9)  // als 999 is dan k++
            { k = -1; l++; IO.writeShort(0x16, Los); IO.writeShort(0x16, l);}
            if (j == 9 && i == 9)  // als 99 is dan l++
            { j = -1; k++; IO.writeShort(0x14, Los); IO.writeShort(0x14, k);}
            if (i == 9)  // als 9 is dan j++
            { i = -1; j++; IO.writeShort(0x12, Los); IO.writeShort(0x12, j);} 
        }
    }
    
    public static void O_3a_tellerMetNullen()
    {
        IO.init(); // conect met display
        for(i = Value;i<=99999;i++)
        {
            int Getal =0;
            Getal = i;
            int Digit = 0x10;
            
            while ( Digit <= 0x18)
            {
                IO.writeShort(Digit, Los);
                IO.writeShort(Digit, Getal % 10);
                Getal = Getal / 10;
                Digit += 0x2;
            }
            IO.delay(SleepTime);
            if( i==99999)
            {
                i = 0;
                Digit = 0x10;
                while ( Digit <= 0x18)
                {
                    IO.writeShort(Digit, Los);
                    Digit += 0x2;
                }
            }
        }
    }
    
    public static void O_3b_tellerZonderNullen()
    {
        IO.init(); // conect met display
        for(i = Value;i<=99999;i++)
        {
            int Getal =0;
            Getal = i;
            int Digit = 0x10;
            while ( Getal != 0 && Digit <= 0x18)
            {
                IO.writeShort(Digit, Los);
                IO.writeShort(Digit, Getal % 10);
                Getal = Getal / 10;
                Digit += 0x2;
            }
            IO.delay(SleepTime);
            if( i==99999)
            {
                i = 0;
                Digit = 0x10;
                while ( Digit <= 0x18)
                {
                    IO.writeShort(Digit, Los);
                    Digit += 0x2;
                }
            }
        }
        
    }
    
    /**
     * Het ingevoegde cijfer moet kleiner dan 100000 en groter dan 0
     */
    public static void O_1_plaatsenVanEenCijfer(int Cijfer)
    {
        IO.init(); // conect met display
        Value = Cijfer;
        int Digit = 0x10;
        int Getal = Value;   
        while ( Digit <= 0x18)
        {
            IO.writeShort(Digit, Los);
            IO.writeShort(Digit, Getal % 10);
            Getal = Getal / 10;
            Digit += 0x2;
        }
       
    }
}
