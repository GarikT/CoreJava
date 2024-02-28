package homework.medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat sdfTime = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    public static String dateToString(Date d){
        return sdf.format(d);
    }
    public static String dateTimeToString(Date d){
        return sdfTime.format(d);
    }
    public static Date stringToDate(String d) throws ParseException {

        Date date;
        try {
            date = sdf.parse(d);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
    public static Date stringToDateTime(String d){
        Date date;
        try{
            date = sdfTime.parse(d);
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
        return date;
    }
}
