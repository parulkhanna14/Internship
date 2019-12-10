package com.company1;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;

enum Seasons implements enuminterface{
    WINTER(1),
    SUMMER(2),
    SPRING(3),
    FALL(4);
    int level;
    private Seasons(int level)
    {
        this.level=level;
    }

    public int getlevel(String a) {
        return Seasons.valueOf(a).level;
    }
}

public class trialenum {

    static Logger log = Logger.getLogger(trialenum.class);
    public static void main(String[] args) {
        String log4jConfPath = "/home/sciera/gitprojects/Internship/enum/src/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        //BasicConfigurator.configure();
        for(Seasons s:Seasons.values())
            System.out.println(s);
        Seasons s1=Seasons.FALL;
        int l=s1.getlevel("WINTER");
        System.out.println("Level of WINTER: "+l);
        System.out.println("ORDER OF FALL:: "+Seasons.valueOf("FALL").ordinal());
        log.info("Enum code running!");
        log.debug("This is debug log!!");
        log.warn("Warning!");
    }
}
