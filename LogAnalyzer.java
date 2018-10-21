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
    private int[] dayCounts;
    private int[] monthCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     * Exercise 7.12
     * 
     * parameter to accept log file name as input.
     * @String fileName
     *  Exercise 7.19
     *  objects to analyze daily and monthly web access.
     */
    public LogAnalyzer(String fileName)
    { 
        // Create the array object to hold the hourly, monthly, and daily.
        // access counts.
        hourCounts = new int[24];
        dayCounts = new int[365];
        monthCounts = new int[12];
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
     * Analyze the daily access data from the log file. EX :7.19
     */
    public void analyzeDailyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int day = entry.getDay();
            dayCounts[day]++;
        }
    }
    
    /**
     * Analyze the daily access data from the log file. EX :7.19
     */
    public void analyzeMonthlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int month = entry.getMonth();
            monthCounts[month]++;
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
     * Print the daily  counts. Ex 7.19
     * These should have been set with a prior
     * call to analyzeDailyData.
     */
    public void printDailyCounts()
    {
        System.out.println("Day: Count");
        for(int day = 0; day < dayCounts.length; day++) {
            System.out.println(day + ": " + dayCounts[day]);
        }
    }
    
    /**
     * Print the daily  counts. Ex 7.19
     * These should have been set with a prior
     * call to analyzeMonthlyData.
     */
    public void printMonthlyCounts()
    {
        System.out.println("Month: Count");
        for(int month = 0; month < monthCounts.length; month++) {
            System.out.println(month + ": " + monthCounts[month]);
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
     * Method to Check the number of hourly accesses
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
     * Exrecise 7.19.
     * Method to Check the number ofdaily accesses
     * online and book references.
     */ 
     public int numberOfAccessesPerMonth()
     {
     int total = 0;
     for (int month = 0; month < monthCounts.length; month++){
         total += monthCounts [month];
        }
     return total;
     }
     
    /**
     * Exercise 7.15.
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
    
    /**
     * Exercise 7.19.
     * Method busiestDay returns busiest day.
     * online and book references.
     * comparing values of hoursCount to hour mx
     */ 
     public int busiestDay()
     {
     //maxHour to hold value of max
     int maxDay = 0;
     for (int day = 1; day < dayCounts.length; day++)
     {
     if(dayCounts [day] > dayCounts [maxDay])
     {
         maxDay = day;
        }
    }
    return maxDay;
    }
    
    /**
     * Exercise 7.19.
     * Method busiestMonth returns busiest month.
     * online and book references.
     * comparing values of hoursCount to hour mx
     */ 
     public int busiestMonth()
     {
     //maxHour to hold value of max
     int maxMonth = 0;
     for (int month = 1; month < monthCounts.length; month++)
     {
     if(monthCounts [month] > monthCounts [maxMonth])
     {
         maxMonth = month;
        }
    }
    return maxMonth;
    }
    
    /**
     *Exercise 7.16.
     * method quietestHour returns least busy hour. 
     * arry hourCounts, for loop.
     * online and book references.
     */ 
     public int quietestHour(int [] hourCounts)
     {
     int quietest = hourCounts[0];
     for ( int i=0; i< hourCounts.length; i++)
     {
         if (hourCounts [i] > 0 &&
         hourCounts[i] > quietest)
         quietest = hourCounts[i];
        }
        return quietest;
    }

    /**
     * Exercise 7.18.
     * Method busiestTwoHour. 
     * retuns the value of the first hour of this period.
     * online and book references.
     */ 
      int busiestTwoHour (int [] hourCounts)
     {
     int busiestOne = 0;
     int busiestTwo = 0;
     for ( int n :hourCounts) {
         if(busiestOne < n){
             busiestTwo =  busiestOne;
             busiestOne = n;
            }
            else if (busiestTwo < n){
                busiestTwo = n;
            }
        }
        return busiestOne;
     }
    
    /**
     *Exercise 7.19.
     * method quietesDay returns least busy day. 
     * arry hourCounts, for loop.
     * online and book references.
     */ 
     public int quietestDay(int [] dayCounts)
     {
     int quietest = dayCounts[0];
     for ( int i=0; i< dayCounts.length; i++)
     {
         if (dayCounts [i] > 0 &&
         dayCounts[i] > quietest)
         quietest = dayCounts[i];
        }
        return quietest;
    }
    
    /**
     *Exercise 7.19.
     * method quietesMonth returns least busy month. 
     * arry hourCounts, for loop.
     * online and book references.
     */ 
     public int quietestMonth(int [] monthCounts)
     {
     int quietest = monthCounts[0];
     for ( int i=0; i< monthCounts.length; i++)
     {
         if (monthCounts [i] > 0 &&
         monthCounts[i] > quietest)
         quietest = monthCounts[i];
        }
        return quietest;
    }
}     

     
 