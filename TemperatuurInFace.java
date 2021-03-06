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

    public PeriodeLengte len = PeriodeLengte.uur;

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
    public void update()
    {
        System.out.println("Update!");
        switch(len)
        {
            case uur:
            hoofd = new Meting(connector.getMostRecentMeasurement()).getInsideTemp();
            //ArrayList<Measurement> mes = connector.getAllMeasurementsLastHours(1);
            ArrayList<Measurement> mes = connector.getLastXMeasurements(100);
            Periode p = new Periode();
            p.vullen(mes);
            links = p.getHoogsteWaardeInsideTemp();
            rechts = p.getLaagsteWaardeInsideTemp();
            break;

            case dag:
            Periode pDag = new Periode();
            pDag.vullen(connector.getAllMeasurementsLast24h());

            hoofd = pDag.getGemiddeldeInsideTemp();
            links = pDag.getHoogsteWaardeInsideTemp();
            rechts = pDag.getLaagsteWaardeInsideTemp();

            case week:
            Periode pWeek = new Periode();
            pWeek.vullen(connector.getAllMeasurementsLast7Days());

            hoofd = pWeek.getGemiddeldeInsideTemp();
            links = pWeek.getHoogsteWaardeInsideTemp();
            rechts = pWeek.getLaagsteWaardeInsideTemp();
            case maand:
            Periode pMaand = new Periode();
            pMaand.vullen(connector.getAllMeasurementsLastHours(24*7*30));

            hoofd = pMaand.getGemiddeldeInsideTemp();
            links = pMaand.getHoogsteWaardeInsideTemp();
            rechts = pMaand.getLaagsteWaardeInsideTemp();
        }
    }

    @Override
    public void setPeriodeLengte(PeriodeLengte len){
        this.len = len;
        GBDotMatrix.drawText("Temperatuur Binnen\n1 "+len.toString(), true);
        IO.delay(2000);
        GBDotMatrix.drawText("Bezig met gegevens\nophalen", true);
    }
}
