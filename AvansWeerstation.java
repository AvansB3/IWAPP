import java.util.*;
/**
 * AvansWeerstation
 * 
 * @author  Groep B3
 * @version TI1.1 2015
 */
public class AvansWeerstation
{
    private ArrayList<Meting> metingen = new ArrayList<Meting>();
    private WeerstationConnector connector = new WeerstationConnector();
    
    GuiFaceMenu guiFaceMenu;
    
    public AvansWeerstation()
    {
        guiFaceMenu = new GuiFaceMenu(connector);
        IO.init();
    }
    
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
    
    public void start()
    {
        guiFaceMenu.start();
    }
    
    
}
