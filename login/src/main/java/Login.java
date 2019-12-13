import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Login extends HttpServlet {

    static Logger log=Logger.getLogger(Login.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String log4jConfigFile = "/home/sciera/gitprojects/Internship/login/src/Log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        /*out.println(email);
        out.println(pass);*/
        if(Validate.checkUser(email, pass))
        {
            RequestDispatcher rs = request.getRequestDispatcher("Welcome");
            rs.forward(request, response);
        }
        else
        {
            log.error("Username or Password incorrect with email as: "+email+" and password as:  "+pass);
            out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.include(request, response);
        }
    }
}