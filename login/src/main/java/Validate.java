import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class Validate {
    public static boolean checkUser(String email,String pass)
    {
        boolean st =false;
        try {
            FileReader fileReader=new FileReader("/home/sciera/gitprojects/Internship/login/src/main/resources/info.properties");
            Properties p=new Properties();
            p.load(fileReader);
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","parul","Kritter12!");
            String url="jdbc:mysql://"+p.getProperty("hostname")+":"+p.getProperty("port")+"/"+p.getProperty("database");
            Connection con= DriverManager.getConnection(url,p.getProperty("uname"),p.getProperty("passwd"));
            PreparedStatement ps = con.prepareStatement("select * from Student where email=? and pass=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}