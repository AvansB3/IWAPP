import java.util.*;
/**
 * Write a description of class Opdracht4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opdracht4
{

    public Opdracht4()
    {

    }

    public double graadDagen(Periode periode)
    {
        double graadDagen = 0;
        int aantaldagen = periode.geefAantalVolledigeDagenInPeriode();
        System.out.println(aantaldagen);
        int lengte = periode.getMetingen().size()/aantaldagen;
        int lengte2 = periode.getMetingen().size()/aantaldagen;
        double totaal = 0;
        int teller = 0;
        int herhaal = 0;
        while (herhaal < 3)
        {
            for(int i=0; i < lengte; i++)
            {
                totaal = totaal + periode.getMetingen().get(i).getOutsideTemp(); 
            }
            double gem = totaal / lengte;
            if (18-gem < 0 )
            {
            graadDagen = graadDagen + (18 - gem);
        }
            herhaal++;
            lengte2 = lengte2 + lengte;
 
        }
        return graadDagen;
    }
}
