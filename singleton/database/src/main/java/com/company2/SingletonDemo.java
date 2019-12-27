package com.company2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class SingletonDemo {
    //static member holds only one instance of the JDBCSingleton class.

    private static SingletonDemo jdbc;                      //single instance

    //SingletonDemo prevents the instantiation from any other class.
    private SingletonDemo() {  }

    //Now we are providing global point of access.
    public static SingletonDemo getInstance() {
        if (jdbc==null)
        {
            jdbc=new  SingletonDemo();
        }
        return jdbc;                            //returns the object!
    }

    // to get the connection from methods like insert, view etc.
    private static Connection getConnection()throws ClassNotFoundException, SQLException
    {
        Connection con=null;
        Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "parul", "Kritter12!");
        /*DatabaseMetaData dm=con.getMetaData();
        System.out.println(dm.supportsBatchUpdates());*/
        return con;

    }

    //to insert the record into the database
    public int insert(String name, String pass) throws SQLException
    {
        Connection c=null;
        PreparedStatement ps=null;
        int recordCounter=0;

        try {

            c=getConnection();
            ps=c.prepareStatement("insert into userdata(uname,upassword)values(?,?)");
            ps.setString(1, name);
            ps.setString(2, pass);
            recordCounter=ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); } finally{
            if (ps!=null){
                ps.close();
            }if(c!=null){
                c.close();
            }
        }
        return recordCounter;
    }

    //to view the data from the database
    public  void view(String name) throws SQLException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con=getConnection();
            ps=con.prepareStatement("select * from userdata where uname=?");
            ps.setString(1, name);
            rs=ps.executeQuery();
            while (rs.next()) {
                System.out.println("Name= "+rs.getString(1)+"\t"+"Paasword= "+rs.getString(2));

            }

        } catch (Exception e) { System.out.println(e);}
        finally{
            if(rs!=null){
                rs.close();
            }if (ps!=null){
                ps.close();
            }if(con!=null){
                con.close();
            }
        }
    }

    // to update the password for the given username
    public int update(String name, String password) throws SQLException  {
        Connection c=null;
        PreparedStatement ps=null;

        int recordCounter=0;
        try {
            c=this.getConnection();
            ps=c.prepareStatement(" update userdata set upassword=? where uname='"+name+"' ");
            ps.setString(1, password);
            recordCounter=ps.executeUpdate();
        } catch (Exception e) {  e.printStackTrace(); } finally{

            if (ps!=null){
                ps.close();
            }if(c!=null){
                c.close();
            }
        }
        return recordCounter;
    }

    // to delete the data from the database
    public int delete(String name) throws SQLException{
        Connection c=null;
        PreparedStatement ps=null;
        int recordCounter=0;
        try {
            c=this.getConnection();
            ps=c.prepareStatement(" delete from userdata where uname='"+name+"' ");
            recordCounter=ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        finally{
            if (ps!=null){
                ps.close();
            }if(c!=null){
                c.close();
            }
        }
        return recordCounter;
    }
}// End of JDBCSingleton class