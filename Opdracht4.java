import java.util.*;
/**
 * Write a description of class Opdracht4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opdracht4
{
    /**
     * Constructor for objects of class Opdracht3
     */
    public Opdracht4()
    {

    }
    
    public Periode langstDurendeZomerPeriode(Periode periode)
    {
        //haal alle data op uit metingen
        
        //[if] check of in een meting de temperatuur 25 of hoger is
        // zoja newperiode++
        // index++
        
        //[else]zo niet, 
        //index++
        //newperiode = 0
        
        //[if] newperiode > periode
        //periode = newperiode
        
        //loop
        //return periode
        int newPeriode = 0;
        int eindP = 0;
        int index = 0;
        int newIndex = 0;
        boolean perZomer = false;
        for(int i = 0; i < periode.getMetingen().size(); i++)
        {
            Meting m = periode.getMetingen().get(i);
            
            if(m.getOutsideTemp() >= 25) {
                if (perZomer = false){
                    newIndex = i;
                    perZomer = true;
                    newPeriode = 0;
                }
                else{
                    newPeriode++;
                }
                
                if (newPeriode > eindP){
                    eindP = newPeriode;
                    index = newIndex;
                }
            }
            else{
                perZomer = false;
            }
            
        }
        Periode p = new Periode();
        p.setDagBeginPeriode(periode.getMetingen().get(index).getDateStamp());
        p.setDagEindPeriode(periode.getMetingen().get(index+eindP).getDateStamp());
        p.setMetingen(new ArrayList<Meting>(periode.getMetingen().subList(index, index+eindP)));
        return p;
    }
    
    public Periode temperatuurStijgingPeriode(Periode periode){
        double templast = 0;
        int newPeriode = 0;
        int eindP = 0;
        int index = 0;
        int newIndex = 0;
        boolean perRegen = false;
        for(int i = 0; i < periode.getMetingen().size(); i++)
        {
            Meting m = periode.getMetingen().get(i);
            if(m.getOutsideTemp() > templast) {
                if (perRegen = false){
                    newIndex = i;
                    perRegen = true;
                    newPeriode = 0;
                    templast = m.getOutsideTemp();
                }
                else{
                    newPeriode++;
                    templast = m.getOutsideTemp();
                }
                
                if (newPeriode > eindP){
                    eindP = newPeriode;
                    index = newIndex;
                    templast = m.getOutsideTemp();
                }
            }
            else{
                perRegen = false;
                templast = m.getOutsideTemp();
            }
        }
        Periode p = new Periode();
        p.setDagBeginPeriode(periode.getMetingen().get(index).getDateStamp());
        p.setDagEindPeriode(periode.getMetingen().get(index+eindP).getDateStamp());
        p.setMetingen(new ArrayList<Meting>(periode.getMetingen().subList(index, index+eindP)));
        return p;
    }
}
