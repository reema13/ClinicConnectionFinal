package com.clinicconnection.clinicconnection.DataBase;/*package com.clinics.theclinicmaneger.DataBase;
import android.arch.persistence.room.TypeConverter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timeconverter {


    static DateFormat df = new SimpleDateFormat(Constants.TIME_FORMAT);

    @TypeConverter
    public static Date fromTimestamp(String value) {
        if (value != null) {
            try {
                return df.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

    @TypeConverter
    public static String dateToString(Date date){

        return df.format(date);
    }
}
*/