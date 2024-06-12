package com.proyect.racoonbrothers.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtil {

    public static void error(String error){
        log.error(error);
    }
    public static void info(String info){
        log.info(info);
    }
    public static void debug(String debug){
        log.debug(debug);
    }
    public static void warn(String warn){
        log.warn(warn);
    }

}
