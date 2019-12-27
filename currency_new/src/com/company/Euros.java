package com.company;

public class Euros extends Currency {
    Currency cur=new Currency("Portugal","Euros");

    public Euros(String name, String sym) {
        super(name, sym);
    }

    public double eurosconvertor(double amt,String code)
    {
        if (code.equals("inr"))
            return amt*53.88;
        else if (code.equals("usd"))
            return amt*0.75;
        else if (code.equals("cand"))
            return amt*0.68;
        else if(code.equals("yen"))
            return  amt*82.28;
        else return 0.0;
    }
}
