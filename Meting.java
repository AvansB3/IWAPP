import java.util.*;
/**
 * Meting
 * 
 * @author  Groep B3
 * @version TI1.1 2015
 */
public class Meting
{

    private String stationId;
    private GregorianCalendar dateStamp = new GregorianCalendar();
    private String nameMeter;
    private String geoLoc;
    private double barometer;
    private double insideTemp;
    private double insideHum;
    private double outsideTemp;
    private double windSpeed;
    private double avgWindSpeed;
    private String windDir;
    private int windDirDeg;
    private double outsideHum;
    private double rainRate;
    private double UVLevel;
    private double solarRad;
    private double xmitBatt;
    private double battLevel;
    private double foreIcon;
    private String sunrise;
    private String sunset;
    
    public Meting(Measurement mes)
    {
        this.dateStamp.setTime(mes.getDateStamp());
        Calculator c = new Calculator();
        this.barometer = c.luchtdruk(mes.getBarometer());
        this.insideTemp = c.temperatuur(mes.getInsideTemp());
        this.insideHum = c.luchtVochtigheid(mes.getInsideHum());
        this.outsideTemp = c.temperatuur(mes.getOutsideTemp());
        this.windSpeed = c.windSnelheid(mes.getWindSpeed());
        this.avgWindSpeed = c.windSnelheid(mes.getAvgWindSpeed());
        this.windDir = c.windDirection(mes.getWindDir());
        this.windDirDeg = c.windRichtingGraden(mes.getWindDir());
        this.outsideHum = c.luchtVochtigheid(mes.getOutsideHum());
        this.rainRate = c.regenMeter(mes.getRainRate());
        this.UVLevel = c.uvIndex(mes.getUVLevel());
        this.solarRad = mes.getSolarRad();
        this.xmitBatt = c.batterySpanning(mes.getXmitBatt());
        this.battLevel = c.batterySpanning(mes.getBattLevel());
        this.foreIcon = mes.getForeIcon();
        this.sunrise = c.sunRise(mes.getSunrise());
        this.sunset = c.sunSet(mes.getSunset());
    }
    
    public Meting(Measurement mes, String operator, String geoLoc)
    {
        this(mes);
        this.nameMeter = operator;
        this.geoLoc = geoLoc;
        
    }
    
    // stationId
    public void setStationId (String str) { this.stationId = str;};
    public String getStationId () { return stationId; };

    // dateStamp
    public void setDateStamp (GregorianCalendar ts) { this.dateStamp = ts;};
    public GregorianCalendar getDateStamp () { return dateStamp; };

    // barometer
    public void setBarometer (short val) { this.barometer = val;};
    public double getBarometer () { return barometer; };

    // insideTemp
    public void setInsideTemp (short val) { this.insideTemp = val;};
    public double getInsideTemp () { return insideTemp; };

    // insideHum
    public void setInsideHum (short val) { this.insideHum = val;};
    public double getInsideHum () { return insideHum; };    

    // outsideTemp
    public void setOutsideTemp (short val) { this.outsideTemp = val;};
    public double getOutsideTemp () { return outsideTemp; };

    // windSpeed
    public void setWindSpeed (short val) { this.windSpeed = val;};
    public double getWindSpeed () { return windSpeed; };

    // avgWindSpeed
    public void setAvgWindSpeed (short val) { this.avgWindSpeed = val;};
    public double getAvgWindSpeed () { return avgWindSpeed; };


    // windDir
    public void setWindDir (String val) { this.windDir = val;};
    public String getWindDir () { return windDir; };

    // windDirDeg
    public void setWindDirDeg (short val) { this.windDirDeg = val;};
    public int getWindDirDeg () { return windDirDeg; };

    // outsideHum
    public void setOutsideHum (short val) { this.outsideHum = val;};
    public double getOutsideHum () { return outsideHum; };


    // rainRate
    public void setRainRate (short val) { this.rainRate = val;};
    public double getRainRate () { return rainRate; };


    // UVLevel
    public void setUVLevel (short val) { this.UVLevel = val;};
    public double getUVLevel () { return UVLevel; };


    // solarRad
    public void setSolarRad (short val) { this.solarRad = val;};
    public double getSolarRad () { return solarRad; };

    // xmitBatt
    public void setXmitBatt (short val) { this.xmitBatt = val;};
    public double getXmitBatt () { return xmitBatt; };


    // battLevel
    public void setBattLevel (short val) { this.battLevel = val;};
    public double getBattLevel () { return battLevel; };

    
    // foreIcon
    public void setForeIcon (short val) { this.foreIcon = val;};
    public double getForeIcon () { return foreIcon; };
    //public double getOutsideHumNL() { return new Calculator().luchtVochtigheid(outsideHum);};

    // sunrise
    public void setSunrise (String val) { this.sunrise = val;};
    public String getSunrise () { return sunrise; };


    // sunset
    public void setSunset (String val) { this.sunset = val;};
    public String getSunset () { return sunset; };

    public String toString()
    {
        String s = "stationId = " + stationId
            + ", dateStamp = " + dateStamp
            + ", barometer = " + barometer
            + ", insideTemp = " + insideTemp
            + ", insideHum = " + insideHum
            + ", outsideTemp = " + outsideTemp
            + ", windSpeed = " + windSpeed
            + ", avgWindSpeed = " + avgWindSpeed
            + ", windDir = " + windDir
            + ", outsideHum = " + outsideHum
            + ", rainRate = " + rainRate
            + ", UVLevel = " + UVLevel
            + ", solarRad = " + solarRad
            + ", xmitBatt = " + xmitBatt
            + ", battLevel = " + battLevel
            + ", foreIcon = " + foreIcon
            + ", sunrise = " + sunrise
            + ", sunset = " + sunset;
        return s; 
    } 
    
    public void printInfo()
    {
        System.out.printf("Meting uitgevoerd door: %s\nOp datum: %s\nWeerstation locatie: %s\n%s\n", nameMeter, dateStamp, geoLoc, "======================================");
        String s = this.toString();
        for(String line : s.split(","))
        {
            System.out.println(line);
        }
    }
    
    
}