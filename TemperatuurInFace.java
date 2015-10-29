import java.util.*;
/**
 * Write a description of class TemperatuurFace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TemperatuurInFace extends GuiFace
{

    /**
     * Constructor for objects of class TemperatuurFace
     */
    
    public double hoofd = 0;
    public double links = 0;
    public double rechts = 0;
    
    public WeerstationConnector connector;
    
    public TemperatuurInFace(WeerstationConnector connector)
    {
        this.connector = connector;

    }
    @Override
    public void init()
    {
        GBDotMatrix.drawText("Temperatuur Binnen\n1 uur", true);
        IO.delay(2000);
        GBDotMatrix.drawText("      Gemiddeld\nMax              Min", true);
    }
    @Override
    public void draw()
    {
        System.out.println("Draw!");
        GBCijferWeergave.schrijfDouble(0x10, hoofd);
        GBCijferWeergave.schrijfDouble(0x20, links);
        GBCijferWeergave.schrijfDouble(0x30, rechts);
    }
    
    @Override
    public void update(PeriodeLengte len)
    {
        System.out.println("Update!");
        switch(len)
        {
            case uur:
                hoofd = new Meting(connector.getMostRecentMeasurement()).getInsideTemp();
                ArrayList<Measurement> mes = connector.getAllMeasurementsLastHours(1);
                Periode p = new Periode();
                p.vullen(mes);
                links = p.getHoogsteWaardeInsideTemp();
                rechts = p.getLaagsteWaardeInsideTemp();
                break;
        }
    }
}
