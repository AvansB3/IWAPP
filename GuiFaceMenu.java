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

    Thread _menuThread;
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
        GBDotMatrix.drawText("Welkom!", true);
        currentFace.init();
        currentFace.update(lengte);
        currentFace.draw();
        running = true;
        _menuThread = new Thread(() ->  {menuThread();});
        _updateThread = new Thread(() ->  {updateThread();});

        _menuThread.start();
        _updateThread.start();
    }

    public void stop()
    {
        running = false;
        try{
            _menuThread.join();
            _updateThread.join();
        }
        catch(InterruptedException E)
        {
            System.out.println("Couldn't join threads");
        }
    }

    public void menuThread()
    {
        while(true)
        {
            if(GBKnoppen.blauweKnopLinks())
            {
                int currentIndex = guifaces.indexOf(currentFace);
                if(currentIndex+1 >= guifaces.size())
                    setCurrentFace(0);
                else
                    setCurrentFace(currentIndex+1);
            }

            if(GBKnoppen.blauweKnopRechts())
            {
                lengte = lengte.next();
            }

            IO.delay(500);
            if(!running)
                break;
        }
    }

    public void updateThread()
    {
        while(true)
        {
            currentFace.update(lengte);
            currentFace.draw();
            IO.delay(500);
            if(!running)
            {
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

