import java.util.*;
/**
 * Write a description of class GuiFaceMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuiFaceMenu
{
    private ArrayList<GuiFace> guifaces = new ArrayList<GuiFace>();
    private GuiFace currentFace;

    Thread _updateThread;
    boolean running;
    private PeriodeLengte lengte;
    /**
     * Constructor for objects of class GuiFaceMenu
     */
    public GuiFaceMenu(WeerstationConnector connector)
    {
        guifaces.add(new TemperatuurInFace(connector));
        currentFace = guifaces.get(0);
        lengte = PeriodeLengte.uur;
    }

    public void start()
    {
        System.out.println("Starten...");
        GBDotMatrix.drawText("Welkom!", true);
        currentFace.init();
        currentFace.update();
        currentFace.draw();
        running = true;
        _updateThread = new Thread(() ->  {updateThread();});

        _updateThread.start();
    }

    public void stop()
    {
        System.out.println("stoppen...");
        running = false;
        try{
            _updateThread.join();
        }
        catch(InterruptedException E)
        {
            System.out.println("Couldn't join threads");
        }
    }

    public void knopLinks()
    {
        System.out.println("Switching face!");
        int currentIndex = guifaces.indexOf(currentFace);
        if(currentIndex+1 >= guifaces.size())
            setCurrentFace(0);
        else
            setCurrentFace(currentIndex+1);
    }

    public void knopRechts()
    {
        System.out.println("Switching period");
        lengte = lengte.next();
        currentFace.setPeriodeLengte(lengte);
        currentFace.update();
        currentFace.draw();
    }

    public void updateThread()
    {
        while(true)
        {
            currentFace.update();
            currentFace.draw();
            IO.delay(1000*60*5);
            if(!running)
            {
                System.out.println("stoppen met updaten!");
                GBCijferWeergave.maakAlleLeeg();
                GBDotMatrix.clrDMDisplay();
                break;
            }
        }
    }

    public void setCurrentFace(int index)
    {
        currentFace = guifaces.get(index);
        currentFace.init();
    }

}

