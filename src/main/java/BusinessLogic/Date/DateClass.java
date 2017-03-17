package BusinessLogic.Date;

import java.util.Calendar;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class DateClass {

    public static String getTimeNow(){
        Calendar cal = Calendar.getInstance();

        return "" + new java.sql.Timestamp(cal.getTimeInMillis());
    }

    public static void main(String[] args) {
        System.out.println(getTimeNow());
    }
}
