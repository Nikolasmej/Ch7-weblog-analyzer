/**
 * Read web server data and analyse hourly access patterns.
 * @Nicolas M.
 * @10/20/18.
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     * Exercise 7.12
     * 
     * parameter to accept log file name as input.
     * @String fileName
     *  
     */
    public LogAnalyzer(String fileName)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(fileName);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }

     /**
     * Exrecise 7.14.
     * Method to Check the number of accesses
     * online and book references.
     */ 
     public int numberOfAccesses()
     {
     int total = 0;
     for (int hour = 0; hour < hourCounts.length; hour++){
         total += hourCounts [hour];
        }
     return total;
     }
    
    /**
     * Exrecise 7.15.
     * Method busiestHour returns busiest hour.
     * online and book references.
     * comparing values of hoursCount to hour mx
     */ 
     public int busiestHour()
     {
     //maxHour to hold value of max
     int maxHour = 0;
     for (int hour = 1; hour < hourCounts.length; hour++)
     {
     if(hourCounts [hour] > hourCounts [maxHour])
     {
         maxHour = hour;
        }
    }
    return maxHour;
   }
         
         

     
 }