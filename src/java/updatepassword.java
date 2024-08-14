import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class updatepassword extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            boolean result=false;
            HttpSession session=request.getSession();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull", "root", "197447");
            String select="select * from register where category=?";
            PreparedStatement ps=conn.prepareStatement(select);
            String category,username,error;
            
            username=request.getParameter("username").trim();
            category=request.getParameter("category").trim();
            
            
            if(username.isEmpty() || category.isEmpty())
            {
                request.setAttribute("errormsg", "Enter the details");
                request.getRequestDispatcher("updatepassword.jsp").forward(request, response);
            }
            else
            {
                if(!Pattern.matches("^[a-zA-Z0-9]+$", username))
                {
                    request.setAttribute("errormsg", "Enter username without whitespace (only character and number).");
                    request.getRequestDispatcher("updatepassword.jsp").forward(request, response);
                 }
                else
                {
                    ps.setString(1,category);
                    ResultSet data=ps.executeQuery();
                    while(data.next())
                    {
                        if(data.getString("username").equals(username))
                        {
                            result=true;
                            session.setAttribute("username",data.getString("username"));
                            session.setAttribute("category",data.getString("category"));
                            response.sendRedirect("updatepassword1.jsp");
                        }
                    }
                } 
            }
            if(result==true)
            {
                
            }
            else
            {
                request.setAttribute("errormsg", "User not found");
                request.getRequestDispatcher("updatepassword.jsp").forward(request, response);
            }
        }
        catch(Exception e)
        {
            request.setAttribute("errormsg", e.getMessage());
            request.getRequestDispatcher("updatepassword.jsp").forward(request, response);
        }
    }
}
