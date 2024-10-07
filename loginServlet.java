Package login;
import java.io.*;
import java.lang.reflect.Parameter;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
Public class loginServlet extends HttpSevlet
{
    Connection con;
    public void init(ServletConfig Config)
    {
        try{
            Class.forName("Oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","Dikshu");
        }Catch(Exception e)
        {
            e.printStackTrace();
        }
        }
    }
    Protected void doPost(HttpSevlet Request request,HttpSevlet Response Response)
    {try {
        String s1=request.get Parameter("uname");
        String s2=request.get Parameter("Pword");
        PreparedStatement Pstmt=con.prepareStatement("Select * From uinfo where uname=? and pword=?");

        pstmt.setstring(1,s1);
        pstmt.setstring(2,s2);
        ResultSet rs=pstmt.executeQuery();
        PrintWriter pw=response.getWriter();
        pw.Println("<html><body bgcolor=cyan text=blue><h1>");
        if(rs.next())
        {
            pw.println("Welcome"+s1);
        }
        else{
            pw.Println("Invalid Username/Password");
        }
        pw.println("</h1> </body> </html");
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
    catch(SQLException e)
    {
        e.printStackTrace();
    }
   }

