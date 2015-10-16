/**
 * Calculator
 * 
 * @author Groep B3 
 * @version 15/09/2015
 */
public class Calculator
{
    private double luchtdruk;
    
    /**
    * Luchtdruk
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return De luchtdruk in mbar
    */
    public double luchtdruk(short mval) 
    {
        // Luchtdruk
        double luchtdruk = (mval/1000)*33.863753;
        return luchtdruk;
    }
    
    /**
    * Temperatuur
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return De temperatuur in graden Celcius
    */
    public double temperatuur(short mval) 
    {
        // Temperatuur
        double temperatuur = ((mval/10)-32)/1.8;
        return temperatuur;
    }
    
    /**
    * Relatieve Luchtvochtigheid
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return De relatieve luchtvochtigheid in procenten
    */
    public double luchtVochtigheid(short mval) 
    {
        // LuchtVochtigheid
        double luchtVochtigheid = mval;
        return luchtVochtigheid;
    }

    /**
    * Windsnelheid
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return De windsnelheid in km/h
    */
    public double windSnelheid(short mval)
    {
        // WindSnelheid
        double windSnelheid = mval*1.609344;
        return windSnelheid;
    }
    
    /**
    * Regenmeter
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return De hoeveelheid regen in mm
    */
    public double regenMeter(short mval) 
    {
        // Regen meter
        double regenMeter = mval*0.2;
        return regenMeter;
    }
    
    /**
    * uvIndex
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return De windrichting in graden
    */
    public double uvIndex(short mval) 
    {
        // UV Index
        double UVlevel = mval/10;
        return UVlevel;
    }
    
    /**
    * batterySpanning
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return De battery spanning in Volt
    */
    public double batterySpanning(short mval) 
    {
        // Battery Spanning
        double batterySpanning = ((mval*300)/512)/100.0;
        return batterySpanning;
    }

    /**
    * sunSet
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return Zonsopkomst in hh:mm notatie
    */
    public String sunSet(short mval) 
    {
        // SunSet
        String a = Short.toString(mval);
        return a.substring(0,2) + ":" + a.substring(2);
    }
    
    /**
    * sunRise
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return Zonsondergang in hh:mm notatie
    */
    public String sunRise(short mval) 
    {
        // SunRise
        double var = (double)(mval)/100;
        int a = (int)var;
        double b = var-a;
        long c = Math.round(b*100);

        return a+":"+((c==0) ? "00" : c);
    }
    
    /**
    * windDirection
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return Windrichting in woorden
    */
    public String windDirection (int mval)
    {
        // Wind direction
        // Between 338 + 360 and 0 + 23 "Noord"
        // Between 24 + 68 "NoordOost"
        // Between 69 + 113 "Oost"
        // Between 114 + 158 "ZuidOost"
        // Between 159 + 203 "Zuid"
        // Between 204 + 248 "ZuidWest"
        // Between 249 + 293 "West"
        // Between 294 + 337 "NoordWest"
        String windRichting = "Geen waarde";
        if(mval <= 0)
            return windRichting;
        if (mval <= 23)
            windRichting = "Noord";
        else if (mval <= 68)
            windRichting = "Noord-Oost";
        else if (mval <= 113)
            windRichting = "Oost"; 
        else if(mval <= 158)
            windRichting = "Zuid-Oost";
        else if(mval <= 203)
            windRichting = "Zuid";
        else if(mval <= 248)
            windRichting = "Zuid-West";
        else if(mval <= 293)
            windRichting = "West";
        else if(mval <= 337)
            windRichting = "Noord-West";
        else if(mval <= 360)
            windRichting = "Noord";
            
        return windRichting;
    }
    
    /**
    * windDirectionInDegrees
    *
    * @param mval Meetwaarde van het vp2pro weerstation
    * @return Windrichting in woorden
    */
    public int windRichtingGraden(short mval)
    {
        int windRichtingGraden = mval;
        return windRichtingGraden;
    }
}
