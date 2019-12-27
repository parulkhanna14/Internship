package com.company;

public class Usd extends Currency{
    Currency cur=new Currency("USA","$");

    public Usd(String name, String sym) {
        super(name, sym);
    }

    public double usdconvertor(double amt,String code)
    {
        if (code.equals("inr"))
            return amt*71.47;
        else if (code.equals("cand"))
            return amt*1.13;
        else if (code.equals("euros"))
            return amt*1.10;
        else if(code.equals("yen"))
            return  amt*109.46;
        else return 0.0;
    }
}