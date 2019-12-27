package com.company;

public class Yen extends Currency {
    Currency cur=new Currency("Japan","yen");

    public Yen(String name, String sym) {
        super(name, sym);
    }

    public double yenconvertor(double amt,String code)
    {
        if (code.equals("inr"))
            return amt*0.65;
        else if (code.equals("cand"))
            return amt*0.012;
        else if (code.equals("euros"))
            return amt*0.0083;
        else if(code.equals("usd"))
            return  amt*0.0091;
        else return 0.0;
    }
}