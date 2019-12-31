package com.company.db;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
public class Data {
    public static void main(String[] args) {
        try{
            FileReader fileReader=new FileReader("./src/main/resources/info.properties");
            Properties p=new Properties();
            p.load(fileReader);
            Scanner sc=new Scanner(System.in);
            int newid;
            String newname;
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://"+p.getProperty("hostname")+":"+p.getProperty("port")+"/"+p.getProperty("database");
            Connection conn= DriverManager.getConnection(url,p.getProperty("uname"),p.getProperty("passwd"));
            conn.setAutoCommit(false);
            System.out.println("Do you want to : ");
            System.out.println("1. Insert into cust: ");
            System.out.println("2. Update rows in cust: ");
            int choice=sc.nextInt();
            String sql="update cust set name=? where id=?";
            String sql1="insert into cust values (? ,?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            PreparedStatement pst=conn.prepareStatement(sql1);

            if (choice==1)
            {
                pst.setInt(1,7);            //assigns values to variables
                pst.setString(2,"puru");
                pst.setInt(3,22);
                pst.setString(4,"India");
                pst.setInt(5,40000);
                pst.addBatch();             //adds to batch

                pst.setInt(1,8);            //assigns values to variables
                pst.setString(2,"nupur");
                pst.setInt(3,22);
                pst.setString(4,"India");
                pst.setInt(5,60000);
                pst.addBatch();             //adds to batch

                int[] a=pst.executeBatch();
                /*for(int i : a)
                    System.out.print(a[i]);
*/

            }
            else if(choice==2) {
                while (true) {
                    System.out.println("Enter id: ");
                    newid = sc.nextInt();
                    System.out.println("Enter new name: ");
                    newname = sc.next();
                    st.setString(1, newname);
                    st.setInt(2, newid);
                    int n = st.executeUpdate();

                    System.out.println("Do you want to update more rows? (y/n)");
                    char ch = sc.next().charAt(0);
                    if (ch == 'n')
                        break;
                }
            }
            else
            {
                System.out.println("Wrong choice!");
            }
            System.out.println("Do you want to : ");
            System.out.println("1. Commit");
            System.out.println("2. Rollback");
            int ch1 = sc.nextInt();
            if (ch1 == 1) {
                System.out.println("Committing changes!");
                conn.commit();
            } else if (ch1 == 2) {
                System.out.println("Revoking changes!");
                conn.rollback();
            } else {
                System.out.println("Wrong choice! Committing changes!");
                conn.commit();
            }
            //Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=st.executeQuery("select * from cust");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"     "+rs.getInt(3)+"    "+rs.getString(4)+"     "+rs.getInt(5));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
