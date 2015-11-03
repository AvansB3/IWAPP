import java.util.*;
/**
 * Write a description of class TemperatuurFace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WindRichtingFace extends GuiFace
{

    /**
     * Constructor for objects of class TemperatuurFace
     */

    public PeriodeLengte len = PeriodeLengte.uur;
    public WindRichting windRichting;
    public WeerstationConnector connector;

    public WindRichtingFace(WeerstationConnector connector)
    {
        this.connector = connector;

    }

    @Override
    public void init()
    {
        
    }
    
    @Override
    public void draw()
    {
        System.out.println("Draw!");
        GBDotMatrix.windRichting(windRichting);
    }
    
    @Override
    public void update()
    {
        System.out.println("Update!");
        switch(len)
        {
            case uur:
                Periode p = new Periode();
                p.vullen(connector.getAllMeasurementsLastHours(1));
                windRichting = p.getGemiddeldeWindDirDeg();
        }
    }

    @Override
    public void setPeriodeLengte(PeriodeLengte len){
        
    }
}
