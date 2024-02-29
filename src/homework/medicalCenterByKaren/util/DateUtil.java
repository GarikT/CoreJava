package homework.medicalCenterByKaren.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
    private static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public static Date stringToDate(String dateStr) throws ParseException {
        Date parse = SDF.parse(dateStr);
        return parse;
    }
    public static Date stringToDateTime(String dateTimeStr) throws ParseException {
        Date parse = SDF_TIME.parse(dateTimeStr);
        return parse;
    }

    public static String dateToString(Date date){
        return SDF.format(date);
    }
    public static String dateTimeToString(Date date){
        return SDF_TIME.format(date);
    }
}
