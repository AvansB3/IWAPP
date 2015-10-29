import java.sql.*;
import java.util.*;
/**
 * WeerstationConnector
 * 
 * @author  Groep B3
 * @version TI1.1 2015
 */
public class WeerstationConnector
{

    private Connection myConn = null;

    /**
     * Connect naar de weerstation database
     *
     * @since     1.0
     */
    public WeerstationConnector()
    {
        this("145.48.203.28","5329","aws_data","aws","aws");
    }

    /**
     * Connect naar de weerstation database
     *
     * @param host   IP adres van database of 'localhost'
     * @param port   Port van mysql daemon (default 3306)
     * @param dbName Naam van de database
     * @since     1.0
     */
    public WeerstationConnector(String host, String port, String dbName, String userName, String password)
    {
        try
        {
            String url = "jdbc:mysql://" + host + ":" + port + "/"+ dbName + "?user="
                + userName
                + "&password="
                + password;
            Class.forName("com.mysql.jdbc.Driver").newInstance ();
            myConn = DriverManager.getConnection(url);
            System.out.println("Database connection established");
        }
        catch( SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch(Exception ex)
        {
            System.out.println("Error : " + ex.getMessage());
        }
    }

    /**
     * Lees meest recente (uit db) barometer
     *
     * @return   <code>barometer value [inches]</code>
     * @since     1.0
     */
    public short getMostRecentBarometer()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getBarometer();

    }

    /**
     * Lees meest recente (uit db) binnen temperatuur
     *
     * @return   <code>InsideTemp value [F]</code>
     * @since        1.0
     */
    public short getMostRecentInsideTemp()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getInsideTemp();

    }

    /**
     * Lees meest recente (uit db) binnen relatieve luchtvochtigheid
     *
     * @return   <code>InsideHum value [%]</code>
     * @since        1.0
     */
    public short getMostRecentInsideHum()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getInsideHum();

    }

    /**
     * Lees meest recente (uit db) buiten temperatuur
     *
     * @return   <code>InsideTemp value [F]</code>
     * @since        1.0
     */
    public short getMostRecentOutsideTemp()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getOutsideTemp();

    }

    /**
     * Lees meest recente (uit db) windsnelheid
     *
     * @return   <code>Windspeed value [m/s]</code>
     * @since        1.0
     */
    public short getMostRecentWindSpeed()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getWindSpeed();

    }

    /**
     * Lees meest recente (uit db) gemiddelde windsnelheid
     *
     * @return   <code>Average windspeed [m/s]</code>
     * @since        1.0
     */
    public short getMostRecentAvgWindSpeed()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getAvgWindSpeed();

    }

    /**
     * Lees meest recente (uit db) windrichting
     *
     * @return   <code>winddir [m/s]</code>
     * @since        1.0
     */
    public short getMostRecentWindDir()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getWindDir();

    }

    /**
     * Lees meest recente (uit db) windrichtingGraden
     *
     * @return   <code>winddirDeg [m/s]</code>
     * @since        1.0
     */
    public short getMostRecentWindDirDeg()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getWindDirDeg();

    }

    /**
     * Lees meest recente (uit db) buiten relatieve luchtvochtigheid
     *
     * @return   <code>OutsideHum [%]</code>
     * @since        1.0
     */
    public short getMostRecentOutsideHum()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getOutsideHum();

    }

    /**
     * Lees meest recente (uit db) rainrate
     *
     * @return   <code>rainrate [2mm clicks]</code>
     * @since        1.0
     */
    public short getMostRecentRainRate()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getRainRate();

    }

    /**
     * Lees meest recente (uit db) UV level
     *
     * @return   <code>UV level</code>
     * @since        1.0
     */
    public short getMostRecentUVLevel()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getUVLevel();

    }

    /**
     * Lees meest recente (uit db) Solar Radiation
     *
     * @return   <code>Solar Radiation</code>
     * @since        1.0
     */
    public short getMostRecentSolarRadiation()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getSolarRad();

    }

    /**
     * Lees meest recente (uit db) xmitBatt
     *
     * @return   <code>xmitBatt</code>
     * @since        1.0
     */
    public short getMostRecentXmitBatt()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getXmitBatt();

    }

    /**
     * Lees meest recente (uit db) battLevel
     *
     * @return   <code>battLevel</code>
     * @since        1.0
     */
    public short getMostRecentBattLevel()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getBattLevel();

    }

    /**
     * Lees meest recente (uit db) sunrise
     *
     * @return   <code>sunrise</code>
     * @since        1.0
     */
    public short getMostRecentSunrise()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getSunrise();

    }

    /**
     * Lees meest recente (uit db) sunset
     *
     * @return   <code>sunset</code>
     * @since        1.0
     */
    public short getMostRecentSunset()
    {
        Measurement m = getMostRecentMeasurement();
        return m.getSunset();

    }

    /**
     * Lees uit db alle buitentemperaturen
     *
     * @return   <code>short[]</code>
     * @since        1.0
     */
    public short[] getAllOutsideTemp()
    {
        ArrayList<Measurement> mArr = getAllMeasurements();
        short[] values = new short[mArr.size()];
        int count = 0;
        for(Measurement m: mArr )
        {
            values[count++] = m.getOutsideTemp();
        }
        return values;
    }

    /**
     * Lees uit db alle barometer waarden
     *
     * @return   <code>short[]</code>
     * @since        1.0
     */
    public short[] getAllBarometer()
    {
        ArrayList<Measurement> mArr = getAllMeasurements();
        short[] values = new short[mArr.size()];
        int count = 0;
        for(Measurement m: mArr )
        {
            values[count++] = m.getBarometer();
        }
        return values;
    }


    /**
     * Lees meest recente meeting (uit db)
     *
     * @return   <code>Measurement</code>
     * @since        1.0
     */
    public Measurement getMostRecentMeasurement()
    {

        Measurement m = new Measurement();

        try
        {
            // query:
            Statement s = myConn.createStatement();
            s.executeQuery("SELECT stationId, timestamp, " +
                "barometer, " +
                "insideTemp, " +
                "insideHum, " +
                "outsideTemp, " +
                "windSpeed, " +
                "avgWindSpeed, " +
                "windDir, " +
                "outsideHum, " +
                "rainRate, " +
                "UVLevel, " +
                "solarRad, " +
                "xmitBatt, " +
                "battLevel, " +
                    //  "foreIcon, " +
                "sunrise, " +
                "sunset " +
                "FROM measurement order by measurementId desc limit 1");

            ResultSet rs = s.getResultSet();
            int count = 0;
            while( rs.next() )
            {
                m.setStationId( rs.getString("stationId") );
                m.setDateStamp( rs.getTimestamp(2));
                m.setBarometer( Short.valueOf(rs.getString("barometer")) );
                m.setInsideTemp( Short.valueOf(rs.getString("insideTemp")) );
                m.setInsideHum( Short.valueOf(rs.getString("insideHum")) );
                m.setOutsideTemp( Short.valueOf(rs.getString("outsideTemp")) );
                m.setWindSpeed( Short.valueOf(rs.getString("windSpeed")) );
                m.setAvgWindSpeed( Short.valueOf(rs.getString("avgWindSpeed")) );
                m.setWindDir( Short.valueOf(rs.getString("windDir")) );
                m.setOutsideHum( Short.valueOf(rs.getString("outsideHum")) );
                m.setRainRate( Short.valueOf(rs.getString("rainRate")) );
                m.setUVLevel( Short.valueOf(rs.getString("UVLevel")) );
                m.setSolarRad( Short.valueOf(rs.getString("solarRad")) );
                m.setXmitBatt( Short.valueOf(rs.getString("xmitBatt")) );
                m.setBattLevel( Short.valueOf(rs.getString("battLevel")) );
                //              m.setForeIcon( Short.valueOf(rs.getString("foreIcon")) );
                m.setSunrise( Short.valueOf(rs.getString("sunrise")) );
                m.setSunset( Short.valueOf(rs.getString("sunset")) );

                count++;
            }
            rs.close();
            s.close();
        }
        catch( SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch( Exception ex)
        {
            System.out.println("getMeasurement: " + ex.getMessage());
        }

        return m;
    }

    /**
     * Construct ArrayList van Measurement objecten
     *
     * @return   <code>Measurement</code>
     * @since        1.0
     */
    public ArrayList<Measurement> getAllMeasurements()
    {

        ArrayList<Measurement> mArr = new ArrayList<Measurement>();

        try
        {
            // query:
            Statement s = myConn.createStatement();
            s.executeQuery("SELECT stationId, timestamp, " +
                "barometer, " +
                "insideTemp, " +
                "insideHum, " +
                "outsideTemp, " +
                "windSpeed, " +
                "avgWindSpeed, " +
                "windDir, " +
                "outsideHum, " +
                "rainRate, " +
                "UVLevel, " +
                "solarRad, " +
                "xmitBatt, " +
                "battLevel, " +
                    //  "foreIcon, " +
                "sunrise, " +
                "sunset " +
                "FROM measurement");

            ResultSet rs = s.getResultSet();
            int count = 0;
            while( rs.next() )
            {
                Measurement m = new Measurement();

                m.setStationId( rs.getString("stationId") );
                m.setDateStamp( rs.getTimestamp(2));
                m.setBarometer( Short.valueOf(rs.getString("barometer")) );
                m.setInsideTemp( Short.valueOf(rs.getString("insideTemp")) );
                m.setInsideHum( Short.valueOf(rs.getString("insideHum")) );
                m.setOutsideTemp( Short.valueOf(rs.getString("outsideTemp")) );
                m.setWindSpeed( Short.valueOf(rs.getString("windSpeed")) );
                m.setAvgWindSpeed( Short.valueOf(rs.getString("avgWindSpeed")) );
                m.setWindDir( Short.valueOf(rs.getString("windDir")) );
                m.setOutsideHum( Short.valueOf(rs.getString("outsideHum")) );
                m.setRainRate( Short.valueOf(rs.getString("rainRate")) );
                m.setUVLevel( Short.valueOf(rs.getString("UVLevel")) );
                m.setSolarRad( Short.valueOf(rs.getString("solarRad")) );
                m.setXmitBatt( Short.valueOf(rs.getString("xmitBatt")) );
                m.setBattLevel( Short.valueOf(rs.getString("battLevel")) );
                //              m.setForeIcon( Short.valueOf(rs.getString("foreIcon")) );
                m.setSunrise( Short.valueOf(rs.getString("sunrise")) );
                m.setSunset( Short.valueOf(rs.getString("sunset")) );

                mArr.add(m);

                count++;
            }
            rs.close();
            s.close();
        }
        catch( SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch( Exception ex)
        {
            System.out.println("getMeasurement: " + ex.getMessage());
        }

        return mArr;
    }

    /**
     * Retourneer alle measurement objecten tussen twee datums
     * @params d1    Begin datum
     * @params d2    Eind datum. d2 >= d1
     * @return   <code>Measurement</code>
     * @since        1.0
     */
    public ArrayList<Measurement> getAllMeasurementsBetween(GregorianCalendar d1, GregorianCalendar d2)
    {

        String sd1 = d1.get(Calendar.YEAR) + "-" + (d1.get(Calendar.MONTH)+1) + "-" + d1.get(Calendar.DATE) + " 0:0:0";
        String sd2 = d2.get(Calendar.YEAR) + "-" + (d2.get(Calendar.MONTH)+1) + "-" + d2.get(Calendar.DATE) + " 23:59:59";

        ArrayList<Measurement> mArr = new ArrayList<Measurement>();

        try
        {
            // query:
            Statement s = myConn.createStatement();
            s.executeQuery("SELECT stationId, timestamp, " +
                "barometer, " +
                "insideTemp, " +
                "insideHum, " +
                "outsideTemp, " +
                "windSpeed, " +
                "avgWindSpeed, " +
                "windDir, " +
                "outsideHum, " +
                "rainRate, " +
                "UVLevel, " +
                "solarRad, " +
                "xmitBatt, " +
                "battLevel, " +
                    //  "foreIcon, " +
                "sunrise, " +
                "sunset " +
                "FROM measurement where timestamp between " +
                "'" + sd1 + "' and '" + sd2 + "'");

            ResultSet rs = s.getResultSet();
            int count = 0;
            while( rs.next() )
            {
                Measurement m = new Measurement();

                m.setStationId( rs.getString("stationId") );
                m.setDateStamp( rs.getTimestamp(2));
                m.setBarometer( Short.valueOf(rs.getString("barometer")) );
                m.setInsideTemp( Short.valueOf(rs.getString("insideTemp")) );
                m.setInsideHum( Short.valueOf(rs.getString("insideHum")) );
                m.setOutsideTemp( Short.valueOf(rs.getString("outsideTemp")) );
                m.setWindSpeed( Short.valueOf(rs.getString("windSpeed")) );
                m.setAvgWindSpeed( Short.valueOf(rs.getString("avgWindSpeed")) );
                m.setWindDir( Short.valueOf(rs.getString("windDir")) );
                m.setOutsideHum( Short.valueOf(rs.getString("outsideHum")) );
                m.setRainRate( Short.valueOf(rs.getString("rainRate")) );
                m.setUVLevel( Short.valueOf(rs.getString("UVLevel")) );
                m.setSolarRad( Short.valueOf(rs.getString("solarRad")) );
                m.setXmitBatt( Short.valueOf(rs.getString("xmitBatt")) );
                m.setBattLevel( Short.valueOf(rs.getString("battLevel")) );
                //              m.setForeIcon( Short.valueOf(rs.getString("foreIcon")) );
                m.setSunrise( Short.valueOf(rs.getString("sunrise")) );
                m.setSunset( Short.valueOf(rs.getString("sunset")) );

                mArr.add(m);

                count++;
            }
            rs.close();
            s.close();
        }
        catch( SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch( Exception ex)
        {
            System.out.println("getMeasurement: " + ex.getMessage());
        }

        return mArr;
    }

    /**
     * Retourneer alle measurement objecten van de afgelopen 24 uur
     *
     * @return   <code>Measurement</code>
     * @since        1.0
     */
    public ArrayList<Measurement> getAllMeasurementsLast24h()
    {

        return getAllMeasurementsLastHours(24);
    }

    /**
     * Retourneer alle measurement objecten van de afgelopen 7 dagen
     *
     * @return   <code>Measurement</code>
     * @since        1.0
     */
    public ArrayList<Measurement> getAllMeasurementsLast7Days()
    {

        return getAllMeasurementsLastHours(24*7);
    }

    /**
     * Retourneer alle measurement objecten van de afgelopen x uren
     *
     * @return   <code>Measurement</code>
     * @since        1.0
     */
    public ArrayList<Measurement> getAllMeasurementsLastXHours(int hours)
    {

        return getAllMeasurementsLastHours(hours);
    }

    /**
     * Retourneer alle measurement objecten tussen nu en nu minus hour
     * @params hour  Tijdspanne in uren tussen nu en hour.
     * @return   <code>Measurement</code>
     * @since        1.0
     */
    public ArrayList<Measurement> getAllMeasurementsLastHours(int hour)
    {

        ArrayList<Measurement> mArr = new ArrayList<Measurement>();

        try
        {
            // query:
            Statement s = myConn.createStatement();
            s.executeQuery("SELECT stationId, timestamp, " +
                "barometer, " +
                "insideTemp, " +
                "insideHum, " +
                "outsideTemp, " +
                "windSpeed, " +
                "avgWindSpeed, " +
                "windDir, " +
                "outsideHum, " +
                "rainRate, " +
                "UVLevel, " +
                "solarRad, " +
                "xmitBatt, " +
                "battLevel, " +
                    //  "foreIcon, " +
                "sunrise, " +
                "sunset " +
                "FROM measurement where timestamp between NOW() - INTERVAL " +
                hour + " HOUR and NOW()");

            ResultSet rs = s.getResultSet();
            int count = 0;
            while( rs.next() )
            {
                Measurement m = new Measurement();

                m.setStationId( rs.getString("stationId") );
                m.setDateStamp( rs.getTimestamp(2));
                m.setBarometer( Short.valueOf(rs.getString("barometer")) );
                m.setInsideTemp( Short.valueOf(rs.getString("insideTemp")) );
                m.setInsideHum( Short.valueOf(rs.getString("insideHum")) );
                m.setOutsideTemp( Short.valueOf(rs.getString("outsideTemp")) );
                m.setWindSpeed( Short.valueOf(rs.getString("windSpeed")) );
                m.setAvgWindSpeed( Short.valueOf(rs.getString("avgWindSpeed")) );
                m.setWindDir( Short.valueOf(rs.getString("windDir")) );
                m.setOutsideHum( Short.valueOf(rs.getString("outsideHum")) );
                m.setRainRate( Short.valueOf(rs.getString("rainRate")) );
                m.setUVLevel( Short.valueOf(rs.getString("UVLevel")) );
                m.setSolarRad( Short.valueOf(rs.getString("solarRad")) );
                m.setXmitBatt( Short.valueOf(rs.getString("xmitBatt")) );
                m.setBattLevel( Short.valueOf(rs.getString("battLevel")) );
                //              m.setForeIcon( Short.valueOf(rs.getString("foreIcon")) );
                m.setSunrise( Short.valueOf(rs.getString("sunrise")) );
                m.setSunset( Short.valueOf(rs.getString("sunset")) );

                mArr.add(m);

                count++;
            }
            rs.close();
            s.close();
        }
        catch( SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch( Exception ex)
        {
            System.out.println("getMeasurement: " + ex.getMessage());
        }

        return mArr;
    }

    protected void finalize() throws Throwable
    {
        // Close database connection
        if( myConn != null )
        {
            try
            {
                myConn.close();
                System.out.println("Database connection terminated");
            }
            catch( Exception e ) {}
        }

        super.finalize();
    }

}