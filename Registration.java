Package login;
import java.io.*;
import java.lang.reflect.Parameter;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
Public class RegServlet extends HttpSevlet
{
    Connection con;
    public void init(ServletConfig Config)
    {
        try{
            Class.forName("Oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnectio("jdbc:oracle:thin:@localhost:1521/XE","system","Dikshu");
        }Catch(Exception e)
        {
            e.printStackTrace();
        }
        }
    }
    Protected void doPost(HttpSevlet Request request,HttpSevlet Response Response)
    {try {
        String s1=request.get Parameter("fname");
        String s2=request.get Parameter("lname");
        String s3=request.get Parameter("uname");
        String s4=request.get Parameter("Pword");
        PreparedStatement Pstmt=con.prepareStatement("insert into uinfo values(?,?,?,?)");
        pstmt.setstring(1,s1);
        pstmt.setstring(2,s2);
        pstmt.setstring(3,s3);
        pstmt.setstring(4,s4);
        PrintWriter pw=response.getWriter();
        pw.Println("<html><body bgcolor=geen text=yellow><Center>");
        pw.Println("<h1> You Have Registered Successfully</h1>");
        pw.Println("<a href=login.html>login<\a>");
        pw.println("</center></body></html>");

         }Catch(Exception e)
         {
            e.printStackTrace();
        }
    }
   Public void destroy()
   {
    try{
        con.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
   }
