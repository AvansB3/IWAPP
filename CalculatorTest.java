
/**
 * Test Class voor Calculatorr
 * 
 * @author (Groep B3) 
 * @version (18/9/2015)
 */
public class CalculatorTest
{
    // instance variables - replace the example below with your own
    private Calculator calc;

    /**
     * Constructor for objects of class Test
     */
    public CalculatorTest()
    {
        //De waarde achter short moeten de waarden van het weerstation worden
        calc = new Calculator();
        double luchtdrukOmgerekend = calc.luchtdruk((short)29552);
        luchtdrukOmgerekend = Math.round(luchtdrukOmgerekend * 100.0) / 100.0;
        System.out.println("De luchtdruk is:\t\t\t" + luchtdrukOmgerekend + " mbar");
        
        
        double temperatuurOmgerekend = calc.temperatuur((short)757);
        temperatuurOmgerekend = Math.round(temperatuurOmgerekend * 100.0) / 100.0;
        System.out.println("De temperatuur is:\t\t\t" + temperatuurOmgerekend + "°C");
        
        
        double luchtvochtOmgerekend = calc.luchtVochtigheid((short)37);
        luchtvochtOmgerekend = Math.round(luchtvochtOmgerekend * 100.0) / 100.0;
        System.out.println("De luchtvochtigheid is:\t\t\t" + luchtvochtOmgerekend + "%");
        
        
        double WindsnelheidOmgerekend = calc.windSnelheid((short)8);
        WindsnelheidOmgerekend = Math.round(WindsnelheidOmgerekend * 100.0) / 100.0;
        System.out.println("De windsnelheid is:\t\t\t" + WindsnelheidOmgerekend + "km/h");
        
        
        double RegenmeterOmgerekend = calc.regenMeter((short)0);
        RegenmeterOmgerekend = Math.round(RegenmeterOmgerekend * 100.0) / 100.0;
        System.out.println("De regenmeter is:\t\t\t" + RegenmeterOmgerekend + "%");
        
        
        double uvIndexOmgerekend = calc.uvIndex((short)5);
        uvIndexOmgerekend = Math.round(uvIndexOmgerekend * 100.0) / 100.0;
        System.out.println("De uvindex is:\t\t\t\t" + uvIndexOmgerekend + "°C");
        
        
        double batterySpanningOmgerekend = calc.batterySpanning((short)814);
        batterySpanningOmgerekend = Math.round(batterySpanningOmgerekend * 100.0) / 100.0;
        System.out.println("De batteryspanning is:\t\t\t" + batterySpanningOmgerekend + "Volt");
        
        
        String sunSetOmgerekend = calc.sunSet((short)1957);
        System.out.println("De zonsondergang is:\t\t\t" + sunSetOmgerekend);
        
        
        String sunRiseOmgerekend = calc.sunRise((short)716);
        System.out.println("De sunrise is:\t\t\t\t" + sunRiseOmgerekend);
        
        
        String windDirectionOmgerekend = calc.windDirection((short)150);
        System.out.println("De windrichting is:\t\t\t" + windDirectionOmgerekend);
        
        
        
        
    }
}
