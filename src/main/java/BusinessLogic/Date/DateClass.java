package BusinessLogic.Date;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class DateClass {

    public static String getTimeNow(){
        Calendar cal = Calendar.getInstance();

        return "" + new Timestamp(cal.getTimeInMillis());
    }

    public static Timestamp getTimeNowTimeStamp(){
        Calendar cal = Calendar.getInstance();

        return new Timestamp(cal.getTimeInMillis());
    }

    public static void main(String[] args) {
        System.out.println(getTimeNow());
    }
}
