import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeStamps {

    public static Timestamp raffleAndConvertToDate() {

        /** Here we want to get the timestamps in unix mode for the two bound dates */
        String s = "2017-01-01 00:00:00";
        String e = "2021-12-31 23:59:59";
        final Timestamp LOWERBOUND = Timestamp.valueOf(s);
        final Timestamp UPPERBOUND = Timestamp.valueOf(e);

        /** Using the rnd (in main) we ruffle a random long num */
        long rand1 = Math.abs(((Main.rnd.nextLong())));

        /** taking the two human dates and make them into epoch mode as long numbers */
        long lowBoundEpoch = Math.abs((LOWERBOUND.getTime()));
        long upBoundEpoch = Math.abs((UPPERBOUND.getTime()));

        /** gap will be a long type number who is the differance between the bounds */
        long gap = upBoundEpoch - lowBoundEpoch;

        /** Because you asked for it tht way*/
        long ts = (rand1 % gap) + lowBoundEpoch;

        /** return the date in human format using Timestamp constructor*/
        Timestamp date = new Timestamp(ts);
        return date;

    }
}




