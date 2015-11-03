import java.util.*;
/**
 * Write a description of class TemperatuurFace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WindRichtingInFace extends GuiFace
{

    /**
     * Constructor for objects of class TemperatuurFace
     */

    public PeriodeLengte len = PeriodeLengte.uur;

    public WeerstationConnector connector;

    public WindRichtingInFace(WeerstationConnector connector)
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
        GBDotMatrix.windRichting("Noord");
    }
    
    @Override
    public void update()
    {
        System.out.println("Update!");
        switch(len)
        {
            
        } 
    }

    @Override
    public void setPeriodeLengte(PeriodeLengte len){
        
    }
}
