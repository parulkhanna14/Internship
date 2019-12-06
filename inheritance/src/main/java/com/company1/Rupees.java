package com.company1;

public class Rupees extends Currency {

    Currency cur=new Currency("India","INR");

    public Rupees(String name, String sym) {
        super(name, sym);
    }

    //   public void rupeesconvertor();
    public double rupeesconvertor(double amt,String code)
    {
        if (code.equals("usd"))
            return amt/71.47;
        else if (code.equals("cand"))
            return amt/53.86;
        else if (code.equals("euros"))
            return amt/78.92;
        else if(code.equals("yen"))
            return  amt*1.53;
        else return 0.0;
    }

}