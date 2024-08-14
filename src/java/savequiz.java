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

public class savequiz extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            HttpSession session=request.getSession();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull","root","197447");
                      
            String insert="insert into quizheading values(?,?,?)";
                        
            PreparedStatement ps=conn.prepareStatement(insert);
            ps.setString(1, session.getAttribute("title").toString());
            ps.setString(2, session.getAttribute("subject").toString());
            ps.setString(3, session.getAttribute("username").toString());
           
            
            if(session.getAttribute("title")!=null && session.getAttribute("subject")!=null)
            {
                ps.executeUpdate();
                session.removeAttribute("title");
                session.removeAttribute("subject");
                request.setAttribute("errormsg", "Quiz Submitted Successfully");
                request.getRequestDispatcher("teacherindex.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("errormsg", "Try Again");
                request.getRequestDispatcher("teacherindex.jsp").forward(request, response);
            }
        }
        catch(Exception e)
        {
            request.setAttribute("errormsg", e.getMessage());
            request.getRequestDispatcher("teacherindex.jsp").forward(request, response);
        }
    }
}
