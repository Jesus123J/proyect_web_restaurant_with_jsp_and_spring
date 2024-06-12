package com.proyect.racoonbrothers.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

@Component
public class DateUtil {

    @Value("${jms.jwt.timezone}")
    private String TIMEZONE;

    private SimpleDateFormat simpleDateFormat() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        return sdf;
    }

    public static String getDateTimeStamp() {

//        Date now = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
//        return sdf.format(now);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date());
    }

    public long getMilliSeconds() {
//        Date now = new Date();
//        String strDate =  simpleDateFormat().format(now);
//        Date strNow = new Date();
//        try{
//            strNow = simpleDateFormat().parse(strDate);
//        }catch (ParseException e){
//
//        }
//        return strNow.getTime();

        try {
            return simpleDateFormat().parse(simpleDateFormat().format(new Date())).getTime();
        } catch (ParseException e) {
            return new Date().toInstant().toEpochMilli();
        }
    }
}
