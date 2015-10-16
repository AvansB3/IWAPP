import java.util.*;
/**
 * Write a description of class Metingen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AvansWeerstation
{
    private ArrayList<Meting> metingen = new ArrayList<Meting>();
    private WeerstationConnector connector = new WeerstationConnector();
    
    public Periode getPeriodeDag()
    {
        Periode p = new Periode();
        p.vullen(connector.getAllMeasurementsLast24h());
        return p;
    }
    
    public Periode getPeriodeWeek()
    {
        Periode p = new Periode();
        p.vullen(connector.getAllMeasurementsLast7Days());
        return p;
    }
    
     public Periode getPeriodeXUren(int hours)
    {
        Periode p = new Periode();
        p.vullen(connector.getAllMeasurementsLastXHours(hours));
        return p;
    }
    
}
