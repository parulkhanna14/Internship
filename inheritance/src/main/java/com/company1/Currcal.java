package com.company1;
import java.io.*;
import java.util.Scanner;

public class Currcal {

    public static void main(String[] args) {
        // write your code here
        Rupees rup=new Rupees("Indian","INR");
        Usd us=new Usd("USA","$");
        CanDollars cand=new CanDollars("Canada","$");
        Euros euro=new Euros("Portugal","Euros");
        Yen y=new Yen("Japan","yen");
        Scanner sc=new Scanner(System.in);
        int ch,ch1;
        double amt;
        System.out.println("*******************************************Currency Calculator*******************************************");
        System.out.println("You want to convert from: ");
        System.out.println("\n1. Rupees : ");
        System.out.println("2. US Dollars : ");
        System.out.println("3. Canadian dollars");
        System.out.println("4. Euros");
        System.out.println("5. Yen: ");
        System.out.println("\nEnter your choice: ");
        ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                System.out.println("\nYou want to convert Rupees into: ");
                System.out.println("1. US Dollars : ");
                System.out.println("2. Canadian dollars");
                System.out.println("3. Euros");
                System.out.println("4. Yen: ");
                System.out.println("\nEnter your choice: ");
                ch1=sc.nextInt();

                System.out.println("Enter the amount: ");
                amt=sc.nextDouble();
                if(ch1 == 1)
                {
                    double usa=rup.rupeesconvertor(amt,"usd");
                    System.out.println(rup.symbol+" "+amt+" = "+  us.symbol+" "+usa );
                }
                else if (ch1==2)
                {
                    double can=rup.rupeesconvertor(amt,"cand");
                    System.out.println(rup.symbol+" "+amt+" = "+ cand.symbol+" "+can);
                }
                else if (ch1==3)
                {
                    double euros=rup.rupeesconvertor(amt,"eur");
                    System.out.println(rup.symbol+" "+ amt+ " = "+euro.symbol+ " "+euros);
                }
                else if(ch1==4)
                {
                    double yen=rup.rupeesconvertor(amt,"yen");
                    System.out.println(rup.symbol+" "+amt+" = "+y.symbol+" "+yen);
                }
                break;
            case 2:
                System.out.println("\nYou want to convert US dollars into: ");
                System.out.println("1. Rupees : ");
                System.out.println("2. Canadian dollars");
                System.out.println("3. Euros");
                System.out.println("4. Yen: ");
                System.out.println("\nEnter your choice: ");
                ch1=sc.nextInt();
                System.out.println("Enter the amount: ");
                amt=sc.nextDouble();
                if(ch1 == 1)
                {
                    double u=us.usdconvertor(amt,"inr");
                    System.out.println(amt+ " "+ us.symbol+" =  "+ u + " INR");
                }
                else if (ch1==2)
                {
                    double can=us.usdconvertor(amt,"cand");
                    System.out.println(amt+ " "+ us.symbol+" = "+ can + " cand");
                }
                else if (ch1==3)
                {
                    double euros=us.usdconvertor(amt,"eur");
                    System.out.println(amt+" "+us.symbol+" = "+euros+" euros");
                }
                else if(ch1==4)
                {
                    double yen=us.usdconvertor(amt,"yen");
                    System.out.println(amt+" "+us.symbol+" = "+yen+" yen");
                }
                break;
            case 3:
                System.out.println("\nYou want to convert Canadian dollars into: ");
                System.out.println("1. Rupees : ");
                System.out.println("2. US dollars");
                System.out.println("3. Euros");
                System.out.println("4. Yen: ");
                System.out.println("\nEnter your choice: ");
                ch1=sc.nextInt();
                System.out.println("Enter the amount: ");
                amt=sc.nextDouble();
                if(ch1 == 1)
                {
                    double u=cand.canconvertor(amt,"inr");
                    System.out.println(amt+ " "+ cand.symbol+" =  "+ u + " INR");
                }
                else if (ch1==2)
                {
                    double usd=us.usdconvertor(amt,"usd");
                    System.out.println(amt+ " "+ cand.symbol+" = "+ usd + " $");
                }
                else if (ch1==3)
                {
                    double euros=us.usdconvertor(amt,"eur");
                    System.out.println(amt+" "+us.symbol+" = "+euros+" euros");
                }
                else if(ch1==4)
                {
                    double yen=us.usdconvertor(amt,"yen");
                    System.out.println(amt+" "+us.symbol+" = "+yen+" yen");
                }
                break;
            case 4:
                System.out.println("\nYou want to convert Euros into: ");
                System.out.println("1. Rupees : ");
                System.out.println("2. US dollars");
                System.out.println("3. Canadian Dollars");
                System.out.println("4. Yen: ");
                System.out.println("\nEnter your choice: ");
                ch1=sc.nextInt();
                System.out.println("Enter the amount: ");
                amt=sc.nextDouble();
                if(ch1 == 1)
                {
                    double u=euro.eurosconvertor(amt,"inr");
                    System.out.println(amt+ " "+ euro.symbol+" =  "+ u + " INR");
                }
                else if (ch1==2)
                {
                    double usd=euro.eurosconvertor(amt,"usd");
                    System.out.println(amt+ " "+ euro.symbol+" = "+ usd + " $");
                }
                else if (ch1==3)
                {
                    double can=euro.eurosconvertor(amt,"cand");
                    System.out.println(amt+" "+euro.symbol+" = "+can+" $");
                }
                else if(ch1==4)
                {
                    double yen=euro.eurosconvertor(amt,"yen");
                    System.out.println(amt+" "+euro.symbol+" = "+yen+" yen");
                }
                break;
            case 5:
                System.out.println("\nYou want to convert Yen into: ");
                System.out.println("1. Rupees : ");
                System.out.println("2. US dollars");
                System.out.println("3. Canadian Dollars");
                System.out.println("4. Euros: ");
                System.out.println("\nEnter your choice: ");
                ch1=sc.nextInt();
                System.out.println("Enter the amount: ");
                amt=sc.nextDouble();
                if(ch1 == 1)
                {
                    double u=y.yenconvertor(amt,"inr");
                    System.out.println(amt+ " "+ y.symbol+" =  "+ u + " INR");
                }
                else if (ch1==2)
                {
                    double usd=y.yenconvertor(amt,"usd");
                    System.out.println(amt+ " "+ y.symbol+" = "+ usd + " $");
                }
                else if (ch1==3)
                {
                    double can=y.yenconvertor(amt,"cand");
                    System.out.println(amt+" "+y.symbol+" = "+can+" $");
                }
                else if(ch1==4)
                {
                    double yen=y.yenconvertor(amt,"euros");
                    System.out.println(amt+" "+y.symbol+" = "+yen+" euros");
                }
                break;

        }
    }
}