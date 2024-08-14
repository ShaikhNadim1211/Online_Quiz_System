import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
import javax.servlet.http.HttpSession;

public class update extends HttpServlet 
{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            HttpSession session=request.getSession();
            response.setContentType("text/html");
            
            String username,title,subject,questionno,question,option1,option2,option3,option4,answer,error;
            
            username=session.getAttribute("username").toString();
            title=request.getParameter("title").trim();
            subject=request.getParameter("subject").trim();
            questionno=request.getParameter("questionno").trim();
            question=request.getParameter("question").trim();
            option1=request.getParameter("option1").trim();
            option2=request.getParameter("option2").trim();
            option3=request.getParameter("option3").trim();
            option4=request.getParameter("option4").trim();
            answer=request.getParameter("answer");
            
            if(title.isEmpty() || subject.isEmpty() || questionno.isEmpty() || question.isEmpty() || option1.isEmpty() || option2.isEmpty() || option3.isEmpty() || option4.isEmpty() || answer.isEmpty() )
            {
                request.setAttribute("errormsg", "Please enter the details");
                request.getRequestDispatcher("updatequestion1.jsp").forward(request, response);
            }
            else
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull","root","197447");
                        
                String update="update quizquestion set question=?, option1=?, option2=?, option3=?, option4=?, answer=? where username=? and title=? and subject=? and questionno=?";
                        
                PreparedStatement ps=conn.prepareStatement(update);
                
                ps.setString(1,question);
                ps.setString(2,option1);
                ps.setString(3,option2);
                ps.setString(4,option3);
                ps.setString(5,option4);
                ps.setString(6,answer);
                ps.setString(7,username);
                ps.setString(8,title);
                ps.setString(9,subject);
                ps.setString(10,questionno);
                
                int r=ps.executeUpdate();
                
                if(r==1)
                {
                    request.setAttribute("errormsg", "Updated Successfully");
                    request.getRequestDispatcher("updatequestion1.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("errormsg","Try Again");
                    request.getRequestDispatcher("updatequestion1.jsp").forward(request, response);
                }
            }
        }
        catch(Exception e)
        {
            request.setAttribute("errormsg", e.getMessage());
            request.getRequestDispatcher("updatequestion1.jsp").forward(request, response);
        }
           
    }
}
