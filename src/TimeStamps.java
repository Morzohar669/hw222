import java.text.SimpleDateFormat;

public class TimeStamps {
    /**
     * TimeStamps we took for Epoch converter website
     * UPPERBOUND - epoch timestamp for 31/12/2021 23:59:59
     * LOWERBOUND - epoch timestamp for 1/1/2017 00:00:00
     */
    public static String raffleAndConvertToDate() {

        long UPPERBOUND = 1640995199;
        long LOWERBOUND = 1483228800;
        long gap = UPPERBOUND % LOWERBOUND;        // check later!!!!!
        long rand1 = Math.abs(((Main.rnd.nextLong() % (gap)))) + LOWERBOUND;  // check later!!!!!

//        System.out.println(UPPERBOUND); //test
//        System.out.println(LOWERBOUND); //test
//        System.out.println(gap); //test
//        System.out.println(rand1); //test

        String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss.ms").format(new java.util.Date(rand1 * 1000));
        return date;
    }
}




