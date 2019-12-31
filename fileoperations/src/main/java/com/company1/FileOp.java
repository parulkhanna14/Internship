package com.company1;

import java.io.*;
import java.util.Scanner;
public class FileOp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("1. Reading a file");
        System.out.println("2. Writing in a file");
        int ch1=sc.nextInt();
        if (ch1==1) {
            try {

                System.out.println("1. Using BufferedReader! ");
                System.out.println("2. Using FileReader! ");
                System.out.println("3. Scanner! ");
                int ch = sc.nextInt();
                if (ch == 1) {
                    //using BufferedReader
                    File file = new File("/home/sciera/gitprojects/Internship/file1");
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String st;
                    while ((st = br.readLine()) != null) {
                        System.out.println(st);
                    }
                } else if (ch == 2) {       //using FileReader --> it reads characters
                    FileReader f = new FileReader("/home/sciera/gitprojects/Internship/file1");
                    int i;
                    while ((i = f.read()) != -1) {
                        System.out.print((char) i);              //if println(then all characters in new line!)
                    }
                } else if (ch == 3) {
                    //Using scanner class --> it makes tokens using delimiters and then we can convert those tokens into some other values!!
                    File file = new File("/home/sciera/gitprojects/Internship/file1");
                    Scanner sc1 = new Scanner(file);
                    while (sc1.hasNextLine()) {
                        System.out.println(sc1.nextLine());
                    }
                } else {
                    System.out.println("Wrong Choice!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ch1==2)
        {
            System.out.println("Enter content to be written: ");
            String str=sc.next();
            try{
                System.out.println("1. BufferedWriter");
                System.out.println("2. FileWriter");
                int ch2=sc.nextInt();
                if(ch2==1)
                {
                    BufferedWriter br=new BufferedWriter(new FileWriter("/home/sciera/gitprojects/Internship/file2"));
                    br.write(str);
                    System.out.println("Written!");
                    br.close();
                }
                else if(ch2==2)
                {
                    FileWriter fw=new FileWriter("/home/sciera/gitprojects/Internship/file2");
                    fw.write(str);
                    System.out.println("Written!");
                    fw.close();
                }
                else
                {
                    System.out.println("Wrong choice!");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
