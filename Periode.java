import java.util.*;
import java.util.Map.Entry;
/**
 * Write a description of class Periode here.
 * 
 * @author  Groep B3
 * @version 13 oktober 2015
 */
public class Periode
{
    static final long aantalMilliSecondenPerDag = 24 * 60 * 60 * 1000;
    private ArrayList<Meting> metingen = new ArrayList<Meting>();
    private GregorianCalendar dagBeginPeriode, dagEindePeriode;
    private ArrayList<Double> mediaanList = new ArrayList<Double>();
    double mediaan;

    public Periode()
    {
        dagBeginPeriode = new GregorianCalendar();
        dagEindePeriode = new GregorianCalendar(); // wordt gevuld met de actuele datum en tijd
    }

    public Periode(GregorianCalendar begin, GregorianCalendar eind)
    {
        dagBeginPeriode = begin;
        dagEindePeriode = eind;
    }

    public void setDagBeginPeriode(GregorianCalendar begin)
    {
        dagBeginPeriode = begin;
    }

    public void setDagEindPeriode(GregorianCalendar eind)
    {
        dagEindePeriode = eind;
    }

    // Zonder tijd, wordt de start aan het begin van de dag gezet:
    public void setDagBeginPeriode(int jaar, int maand, int dag)
    {
        dagBeginPeriode.set(jaar, maand-1, dag,0,0,0);
    }

    public void setDagBeginPeriode(int jaar, int maand, int dag, int uur, int minuten)
    {
        dagBeginPeriode.set(jaar, maand-1, dag, uur, minuten,0);
    }

    // Zonder tijd, wordt het einde aan het einde van de dag gezet:
    public void setDagEindePeriode(int jaar, int maand, int dag)
    {
        dagEindePeriode.set(jaar, maand-1, dag,23,59,59);
    }

    public void setDagEindePeriode(int jaar, int maand, int dag, int uur, int minuten)
    {
        dagEindePeriode.set(jaar, maand-1, dag, uur, minuten,59);
    }

    public GregorianCalendar getDagBeginPeriode ()
    {
        return dagBeginPeriode;
    }

    public GregorianCalendar getDagEindePeriode ()
    {
        return dagEindePeriode;
    }

    public long geefAantalVolledigeDagenInPeriode()
    {
        long antwoord = 0;
        antwoord = (int)(dagEindePeriode.getTime().getTime() - dagBeginPeriode.getTime().getTime()) / aantalMilliSecondenPerDag;
        return antwoord;
    }

    public boolean ditMomentValtInDezePeriode (GregorianCalendar ditMoment)
    { 
        boolean antwoord = false ;
        antwoord = (dagBeginPeriode.compareTo(ditMoment) >= 0 && dagEindePeriode.compareTo(ditMoment) <= 0);
        return antwoord;    
    }

    public void vullen(WeerstationConnector conn)
    {
        ArrayList<Measurement> measurements = conn.getAllMeasurementsBetween(dagBeginPeriode, dagEindePeriode);

        for(Measurement m : measurements)
        {
            metingen.add(new Meting(m));
        }
    }

    public void vullen(ArrayList<Measurement> meas)
    {
        for(Measurement m : meas)
        {
            metingen.add(new Meting(m));
        }
    }

    /**
     * Laagste-------------------------------------------------------------------------------------------------------------
     * --------------------------------------------------------------------------------------------------------------------
     * --------------------------------------------------------------------------------------------------------------------
     */

    public double getLaagsteWaardeBarometer()
    {
        double laagste = metingen.get(0).getBarometer();
        for (Meting waarde : metingen)
        {
            double baro = waarde.getBarometer();
            if (baro<laagste){
                laagste = baro;
            }
        }
        return laagste;
    }

    public double getLaagsteWaardeInsideTemp()
    {
        double laagste = metingen.get(0).getInsideTemp();
        for (Meting waarde : metingen)
        {
            double inside = waarde.getInsideTemp();
            if (inside<laagste){
                laagste = inside;
            }
        }
        return laagste;
    }

    public double getLaagsteWaardeOutsideTemp()
    {
        double grootste = metingen.get(0).getOutsideTemp();
        for (Meting waarde : metingen)
        {
            double outside = waarde.getOutsideTemp();
            if (outside<grootste){
                grootste = outside;
            }
        }
        return grootste;
    }

    public double getLaagsteWaardeInsideHum()
    {
        double laagste = metingen.get(0).getInsideHum();
        for (Meting waarde : metingen)
        {
            double inside = waarde.getInsideHum();
            if (inside<laagste){
                laagste = inside;
            }
        }
        return laagste;
    }

    public double getLaagsteWaardeOutsideHum()
    {
        double laagste = metingen.get(0).getOutsideHum();
        for (Meting waarde : metingen)
        {
            double inside = waarde.getOutsideHum();
            if (inside<laagste){
                laagste = inside;
            }
        }
        return laagste;
    }

    public double getLaagsteWaardeWindSpeed()
    {
        double laagste = metingen.get(0).getWindSpeed();
        for (Meting waarde : metingen)
        {
            double wind = waarde.getWindSpeed();
            if (wind<laagste){
                laagste = wind;
            }    
        }
        return laagste;
    }

    public double getLaagsteWaardeAvgWindSpeed()
    {
        double laagste = metingen.get(0).getAvgWindSpeed();
        for (Meting waarde : metingen)
        {
            double wind = waarde.getAvgWindSpeed();
            if (wind<laagste){
                laagste = wind;
            }    
        }
        return laagste;
    }

    public double getLaagsteWaardeRainRate()
    {
        double laagste = metingen.get(0).getRainRate();
        for (Meting waarde : metingen)
        {
            double rain = waarde.getRainRate();
            if (rain<laagste){
                laagste = rain;
            }
        }
        return laagste;
    }

    public double getLaagsteWaardeUVLevel()
    {
        double laagste = metingen.get(0).getUVLevel();
        for (Meting waarde : metingen)
        {
            double UVL = waarde.getUVLevel();
            if (UVL<laagste){
                laagste = UVL;
            }
        }
        return laagste;
    }

    public double getLaagsteWaardSolarRad()
    {
        double laagste = metingen.get(0).getSolarRad();
        for (Meting waarde : metingen)
        {
            double solar = waarde.getSolarRad();
            if (solar<laagste){
                laagste = solar;
            }
        }
        return laagste;
    }

    public double getLaagstWaardeXmitBatt()
    {
        double laagste = metingen.get(0).getXmitBatt();
        for (Meting waarde : metingen)
        {
            double batt = waarde.getXmitBatt();
            if (batt<laagste){
                laagste = batt;
            }
        }
        return laagste;
    }

    public double getLaagsteWaardeBattLevel()
    {
        double laagste = metingen.get(0).getBattLevel();
        for (Meting waarde : metingen)
        {
            double lvl = waarde.getBattLevel();
            if (lvl<laagste){
                laagste = lvl;
            }
        }
        return laagste;
    }

    /**
     * Hoogste-------------------------------------------------------------------------------------------------------------
     * --------------------------------------------------------------------------------------------------------------------
     * --------------------------------------------------------------------------------------------------------------------
     */

    public double getHoogsteWaardeBarometer()
    {
        double hoogste = metingen.get(0).getBarometer();
        for (Meting waarde : metingen)
        {
            double baro = waarde.getBarometer();
            if (baro>hoogste){
                hoogste = baro;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeInsideTemp()
    {
        double hoogste = metingen.get(0).getInsideTemp();
        for (Meting waarde : metingen)
        {
            double inside = waarde.getInsideTemp();
            if (inside>hoogste){
                hoogste = inside;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeOutsideTemp()
    {
        double hoogste = metingen.get(0).getOutsideTemp();
        for (Meting waarde : metingen)
        {
            double outside = waarde.getOutsideTemp();
            if (outside>hoogste){
                hoogste = outside;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeInsideHum()
    {
        double hoogste = metingen.get(0).getInsideHum();
        for (Meting waarde : metingen)
        {
            double inside = waarde.getInsideHum();
            if (inside>hoogste){
                hoogste = inside;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeOutsideHum()
    {
        double hoogste = metingen.get(0).getOutsideHum();
        for (Meting waarde : metingen)
        {
            double inside = waarde.getOutsideHum();
            if (inside>hoogste){
                hoogste = inside;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeWindSpeed()
    {
        double hoogste = metingen.get(0).getWindSpeed();
        for (Meting waarde : metingen)
        {
            double inside = waarde.getWindSpeed();
            if (inside>hoogste){
                hoogste = inside;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeAvgWindSpeed()
    {
        double hoogste = metingen.get(0).getAvgWindSpeed();
        for (Meting waarde : metingen)
        {
            double wind = waarde.getAvgWindSpeed();
            if (wind>hoogste){
                hoogste = wind;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeRainRate()
    {
        double hoogste = metingen.get(0).getRainRate();
        for (Meting waarde : metingen)
        {
            double rain = waarde.getRainRate();
            if (rain>hoogste){
                hoogste = rain;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeUVLevel()
    {
        double hoogste = metingen.get(0).getUVLevel();
        for (Meting waarde : metingen)
        {
            double UVL = waarde.getUVLevel();
            if(UVL>hoogste){
                hoogste = UVL;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeSolarRad()
    {
        double hoogste = metingen.get(0).getSolarRad();
        for (Meting waarde : metingen)
        {
            double solar = waarde.getSolarRad();
            if (solar>hoogste){
                hoogste = solar;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeXmitBatt()
    {
        double hoogste = metingen.get(0).getXmitBatt();
        for (Meting waarde : metingen)
        {
            double batt = waarde.getXmitBatt();
            if (batt>hoogste){
                hoogste = batt;
            }
        }
        return hoogste;
    }

    public double getHoogsteWaardeBattLevel()
    {
        double hoogste = metingen.get(0).getBattLevel();
        for (Meting waarde : metingen)
        {
            double lvl = waarde.getBattLevel();
            if (lvl>hoogste){
                hoogste = lvl;
            }
        }
        return hoogste;
    }

    /**
     * Gemiddelde----------------------------------------------------------------------------------------------------------
     * --------------------------------------------------------------------------------------------------------------------
     * --------------------------------------------------------------------------------------------------------------------
     */
    public double getGemiddeldeOutsideTemp()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getOutsideTemp();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeInsideTemp()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getInsideTemp();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeBarometer()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getBarometer();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeInsideHum()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getInsideHum();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeOutsideHum()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getOutsideHum();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeWindSpeed()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getWindSpeed();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeAvgWindSpeed()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getAvgWindSpeed();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeRainRate()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getRainRate();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeUVLevel()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getUVLevel();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeSolarRad()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getSolarRad();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeXmitBatt()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getXmitBatt();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public double getGemiddeldeBattLevel()
    {
        double totaal = 0;
        int teller = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getBattLevel();
            teller++;
        }
        double gem = totaal / metingen.size();
        return gem;
    }

    public String getGemiddeldeWindDirDeg()
    {
        int totaal = 0;
        for(Meting waarde : metingen)
        {
            totaal = totaal + waarde.getWindDirDeg();
        }
        int gemiddelde = totaal / metingen.size();
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
        if(gemiddelde <= 0)
            return windRichting;
        if (gemiddelde <= 23)
            windRichting = "Noord";
        else if (gemiddelde <= 68)
            windRichting = "Noord-Oost";
        else if (gemiddelde <= 113)
            windRichting = "Oost"; 
        else if(gemiddelde <= 158)
            windRichting = "Zuid-Oost";
        else if(gemiddelde <= 203)
            windRichting = "Zuid";
        else if(gemiddelde <= 248)
            windRichting = "Zuid-West";
        else if(gemiddelde <= 293)
            windRichting = "West";
        else if(gemiddelde <= 337)
            windRichting = "Noord-West";
        else if(gemiddelde <= 360)
            windRichting = "Noord";
        return windRichting;
    }

    /**
     * Modus------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------
     * -----------------------------------------------------------------------------------------------
     */

    public double getModusBarometer()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getBarometer();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusInsideTemp()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getInsideTemp();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusOutsideTemp()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getOutsideTemp();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusInsideHum()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getInsideHum();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusOutsideHum()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getOutsideHum();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusWindSpeed()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getWindSpeed();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusAvgWindSpeed()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getAvgWindSpeed();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusRainRate()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getRainRate();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusUVLevel()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getUVLevel();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusSolarRad()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getSolarRad();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusXmitBatt()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getXmitBatt();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    public double getModusBattLevel()
    {
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for(Meting meting : metingen)
        {
            double b = meting.getBattLevel();
            map.putIfAbsent(b, 0);
            map.replace(b, map.get(b)+1);
        }
        int max = 0;
        double key = 0;

        for (Entry<Double, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    /**
     * Mediaan-------------------------------------------------------------------------------------------------------------
     * --------------------------------------------------------------------------------------------------------------------
     * --------------------------------------------------------------------------------------------------------------------
     */
    public double getMediaanBarometer()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getBarometer();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    }

    public double getMediaanInsideTemp()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getInsideTemp();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    }

    public double getMediaanInsideHum()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getInsideHum();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    }

    public double getMediaanWindSpeed()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getWindSpeed();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    }

    public double getMediaanOutsideTemp()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getOutsideTemp();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    }    

    public double getMediaanAvgWindSpeed()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getAvgWindSpeed();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    }   

    public double getMediaanOutsideHum()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getOutsideHum();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    }  

    public double getMediaanRainRate()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getRainRate();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    }  

    public double getMediaanUVLevel()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getUVLevel();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    } 

    public double getMediaanSolarRad()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getSolarRad();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    } 

    public double getMediaanXmitBatt()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getXmitBatt();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    } 

    public double getMediaanBattLevel()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getBattLevel();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    } 

    public double getMediaanForeIcon()
    {
        mediaanList.clear();
        for (int i = 0; i < metingen.size(); i++){
            double waarde = metingen.get(i).getForeIcon();
            mediaanList.add(waarde);
        }
        Collections.sort(mediaanList);
        int modulo = mediaanList.size() % 2;
        if((metingen.size() % 2) == 1){
            mediaan = mediaanList.get(((metingen.size()) / 2));
        }
        if((metingen.size() % 2) == 0){
            mediaan = mediaanList.get((((metingen.size()) / 2) + ((metingen.size()/2) + 1)) / 2);
        }
        return mediaan;
    } 

    /**
     * standaardafwijking -------------------------------------------------------------------------------------------------
     * --------------------------------------------------------------------------------------------------------------------
     * --------------------------------------------------------------------------------------------------------------------
     */
    public double getStandaardafwijkingBarometer()
    {
        double gemiddelde = getGemiddeldeBarometer();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getBarometer() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingInsideTemp()
    {
        double gemiddelde = getGemiddeldeInsideTemp();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getInsideTemp() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingOutsideTemp()
    {
        double gemiddelde = getGemiddeldeOutsideTemp();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getOutsideTemp() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingInsideHum()
    {
        double gemiddelde = getGemiddeldeInsideHum();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getInsideHum() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingOutsideHum()
    {
        double gemiddelde = getGemiddeldeOutsideHum();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getOutsideHum() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingWindSpeed()
    {
        double gemiddelde = getGemiddeldeWindSpeed();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getWindSpeed() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingAvgWindSpeed()
    {
        double gemiddelde = getGemiddeldeAvgWindSpeed();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getAvgWindSpeed() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingRainRate()
    {
        double gemiddelde = getGemiddeldeRainRate();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getRainRate() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingUVLevel()
    {
        double gemiddelde = getGemiddeldeUVLevel();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getUVLevel() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingSolarRad()
    {
        double gemiddelde = getGemiddeldeSolarRad();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getSolarRad() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingXmitBatt()
    {
        double gemiddelde = getGemiddeldeXmitBatt();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getXmitBatt() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public double getStandaardafwijkingBattLevel()
    {
        double gemiddelde = getGemiddeldeBattLevel();
        double somKwadraten = 0;
        for(Meting meting : metingen)
        {
            double kwadraat = Math.pow(meting.getBattLevel() - gemiddelde, 2);
            somKwadraten += kwadraat;
        }
        double deelBerekening = somKwadraten / (metingen.size() - 1);
        double standaardafwijking = Math.sqrt(deelBerekening);
        return standaardafwijking;

    }

    public ArrayList<Meting> getMetingen(){return this.metingen;}

    public void setMetingen(ArrayList<Meting> metingen){this.metingen = metingen;}
}
