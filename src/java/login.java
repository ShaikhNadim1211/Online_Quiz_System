import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet 
{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            response.setContentType("text/html");
            String category,username,password,error;
            boolean result=false;
            
            category=request.getParameter("category").trim();
            username=request.getParameter("username").trim();
            password=request.getParameter("password").trim();
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull","root","197447");
            
            String select="select * from register where category=?";
            PreparedStatement ps=conn.prepareStatement(select);
            ps.setString(1, category);
            
            if(username.isEmpty() || password.isEmpty())
            {
                request.setAttribute("errormsg","Please enter the details");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else
            {
                ResultSet data=ps.executeQuery();
                
                while(data.next())
                {
                    if(data.getString("username").equals(username))
                    {
                         result=true;
                         String select1="select * from register where username=?";
                         PreparedStatement ps1=conn.prepareStatement(select1);
                         ps1.setString(1, username);
                         
                         ResultSet data1=ps1.executeQuery();
                         
                         while(data1.next())
                         {
                             if(data1.getString("password").equals(password))
                             {
                                 
                                 HttpSession session=request.getSession();
                                 session.setAttribute("name", data1.getString("name"));
                                 session.setAttribute("username",username);
                                 
                                 if(category.equals("student"))
                                 {
                                     response.sendRedirect("studentindex.jsp");
                                 }
                                 if(category.equals("teacher"))
                                 {
                                     response.sendRedirect("teacherindex.jsp");
                                 }
                             }
                             else
                             {
                                 request.setAttribute("errormsg","Please enter correct password");
                                 request.getRequestDispatcher("index.jsp").forward(request, response);
                             }
                         }
                    }
                }
                if(result==false)
                {
                    request.setAttribute("errormsg","The user not found");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
        }
        catch(Exception e)
        {
            request.setAttribute("errormsg",e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
