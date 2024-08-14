import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class deletequiz extends HttpServlet 
{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            HttpSession session=request.getSession();
            String s=request.getParameter("title").trim();
            String[] result=s.split("##");
            String title="",subject="";
             for(int i=0;i<result.length;i++)
             {
                if(i==0)
                {
                    title=result[i].replaceAll("\\$\\$\\$"," ");
                }
                if(i==1)
                {
                    subject=result[i].replaceAll("\\$\\$\\$"," ");
                }
             }
                        
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull","root","197447");
                        
            String delete="delete from quizquestion where username=? and title=? and subject=?";
            String delete1="delete from quizheading where username=? and title=? and subject=?";
            PreparedStatement ps=conn.prepareStatement(delete);
            PreparedStatement ps1=conn.prepareStatement(delete1);
            ps.setString(1,session.getAttribute("username").toString() );
            ps.setString(2, title);
            ps.setString(3,subject);
            
            ps1.setString(1,session.getAttribute("username").toString() );
            ps1.setString(2, title);
            ps1.setString(3,subject);
            
            int r=ps.executeUpdate();
            int r1=ps1.executeUpdate();
            if(r>=1 && r1==1)
            {
                request.setAttribute("errormsg", "Quiz Deleted");
                request.getRequestDispatcher("delete.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("errormsg", "Try Again");
                request.getRequestDispatcher("delete.jsp").forward(request, response);
            }
        }
        catch(Exception e)
        {
            request.setAttribute("errormsg", e.getMessage());
            request.getRequestDispatcher("delete.jsp").forward(request, response);
        }
    }
}
