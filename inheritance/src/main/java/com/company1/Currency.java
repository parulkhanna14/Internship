package com.company1;

public class Currency {
    public String country;
    public double rate;
    public String symbol;
    public Currency(String name,String sym)
    {
        country=name;
        symbol=sym;
        rate=0.0;
    }
}