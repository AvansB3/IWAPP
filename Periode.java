import java.util.*;

/**
 * Write a description of class Periode here.
 * 
 * @author  Paul Lindelauf 
 * @version 18 oktober 2014 / 6 oktober 2015
 */
public class Periode
{
    static final long aantalMilliSecondenPerDag = 24 * 60 * 60 * 1000;
    
    public ArrayList<Meting> metingen = new ArrayList<Meting>();
    
    private GregorianCalendar dagBeginPeriode, dagEindePeriode;

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
        antwoord = (long)(dagEindePeriode.getTime().getTime() - dagBeginPeriode.getTime().getTime()) / aantalMilliSecondenPerDag;
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
}
