
/**
 * Write a description of class a here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum PeriodeLengte
{
    uur,
    dag,
    week,
    maand;
    
    private static PeriodeLengte[] vals = values();
    public PeriodeLengte next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
