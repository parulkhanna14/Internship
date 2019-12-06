package com.company1;

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

    public static void main(String[] args) {
        for(Seasons s:Seasons.values())
            System.out.println(s);
        Seasons s1=Seasons.FALL;
        int l=s1.getlevel("WINTER");
        System.out.println("Level of WINTER: "+l);
        System.out.println("ORDER OF FALL:: "+Seasons.valueOf("FALL").ordinal());
    }
}
