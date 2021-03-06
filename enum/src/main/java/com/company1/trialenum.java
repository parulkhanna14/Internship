package com.company1;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
//import java.util.Base64;

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

public class trialenum extends TimerTask {
    public static trialenum obj;
    static Logger log = Logger.getLogger(trialenum.class);
    public static void main(String[] args) throws IOException, InterruptedException {
        obj=new trialenum();
        Timer timer=new Timer();
        TimerTask timerTask=new trialenum();
        timer.schedule(timerTask,1000,3000);
        //BasicConfigurator.configure();
        synchronized (obj)
        {
            obj.wait();
        }
        timerTask.cancel();
        String log4jConfPath = "/home/sciera/gitprojects/Internship/enum/src/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        log.info("Enum code running!");
        log.debug("This is debug log!!");
        log.warn("Warning!");
        String s=encodeFileToBase64Binary("/home/sciera/gitprojects/Internship/enum/src/logging.log");
        System.out.println(s);
        timer.cancel();
    }


    private static String encodeFileToBase64Binary(String fileName)
            throws IOException {

        File file = new File(fileName);
        byte[] bytes = loadFile(file);
        byte[] encoded = Base64.encodeBase64(bytes);
        String encodedString = new String(encoded);

        return encodedString;
    }

    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        is.close();
        return bytes;
    }

    public void run() {
        for(Seasons s:Seasons.values())
            System.out.println(s);
        Seasons s1=Seasons.FALL;
        int l=s1.getlevel("WINTER");
        System.out.println("Level of WINTER: "+l);
        System.out.println("ORDER OF FALL:: "+Seasons.valueOf("FALL").ordinal());
        synchronized (trialenum.obj){
            trialenum.obj.notify();
        }
    }
}
