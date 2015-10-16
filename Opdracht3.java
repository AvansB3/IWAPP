import java.util.*;
/**
 * Write a description of class Opdracht3 here.
 * 
 * @author Michael van der Net
 * @version (a version number or a date)
 */
public class Opdracht3
{

    /**
     * Constructor for objects of class Opdracht3
     */
    public Opdracht3()
    {

    }

    public static Periode langstDurendeDroogte(Periode periode)
    {
        int newIndex = 0;
        int newLen = 0;
        int len = 0;
        int index = 0;
        boolean inDroogte = false;
        for(int i = 0; i < periode.getMetingen().size(); i++)
        {
            Meting m = periode.getMetingen().get(i);
            if(m.getRainRate()==0)
            {
                if(!inDroogte)
                {
                    newIndex = i;
                    inDroogte = true;
                    newLen = 0;
                }
                else
                {
                    newLen++;
                }
                
                if(newLen > len)
                {
                    len = newLen;
                    index = newIndex;
                }
            }
            else
            {
                if(inDroogte)
                    inDroogte = false;
            }
        }
        Periode p = new Periode();
        p.setDagBeginPeriode(periode.getMetingen().get(index).getDateStamp());
        p.setDagEindPeriode(periode.getMetingen().get(index+len).getDateStamp());
        p.setMetingen(new ArrayList<Meting>(periode.getMetingen().subList(index, index+len)));
        return p;
    }
    
    public static Periode langstDurendeNeerslag(Periode periode)
    {
        int newIndex = 0;
        int newLen = 0;
        int len = 0;
        int index = 0;
        boolean inRegen = false;
        for(int i = 0; i < periode.getMetingen().size(); i++)
        {
            Meting m = periode.getMetingen().get(i);
            
            if(m.getRainRate()!=0)
            {
                if(!inRegen)
                {
                    newIndex = i;
                    inRegen = true;
                    newLen = 0;
                }
                else
                {
                    newLen++;
                }
                
                if(newLen > len)
                {
                    len = newLen;
                    index = newIndex;
                }
            }
            else
            {
                if(inRegen)
                    inRegen = false;
            }
        }
        Periode p = new Periode();
        p.setDagBeginPeriode(periode.getMetingen().get(index).getDateStamp());
        p.setDagEindPeriode(periode.getMetingen().get(index+len).getDateStamp());
        p.setMetingen(new ArrayList<Meting>(periode.getMetingen().subList(index, index+len)));
        return p;
    }
    
}
