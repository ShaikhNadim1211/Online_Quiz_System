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

public class addquestion extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            
            String name,username,title,subject,questionno,question,option1,option2,option3,option4,answer,error;
            
            HttpSession session=request.getSession();
           
            name=session.getAttribute("name").toString();
            username=session.getAttribute("username").toString();
            title=request.getParameter("title");
            subject=request.getParameter("subject");
            questionno=request.getParameter("questionno");
            question=request.getParameter("question");
            option1=request.getParameter("option1");
            option2=request.getParameter("option2");
            option3=request.getParameter("option3");
            option4=request.getParameter("option4");
            answer=request.getParameter("answer");
            
            if(title.isEmpty() || subject.isEmpty() || questionno.isEmpty() || question.isEmpty() || option1.isEmpty() || option2.isEmpty() || option3.isEmpty() || option4.isEmpty() || answer.isEmpty())
            {
                request.setAttribute("errormsg", "Please enter the details");
                request.getRequestDispatcher("teacherindex.jsp").forward(request, response);
            }
            else
            {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull","root","197447");

                    String insert="insert into quizquestion values(?,?,?,?,?,?,?,?,?,?,?)";

                    PreparedStatement ps=conn.prepareStatement(insert);

                    ps.setString(1,username);
                    ps.setString(2,title);
                    ps.setString(3,subject);
                    ps.setString(4,questionno);
                    ps.setString(5,question);
                    ps.setString(6,option1);
                    ps.setString(7,option2);
                    ps.setString(8,option3);
                    ps.setString(9,option4);
                    ps.setString(10,answer);
                    ps.setString(11,name);

                    int r=ps.executeUpdate();
                    if(session.getAttribute("title")==null && session.getAttribute("subject")==null)
                    {
                        session.setAttribute("title", title);
                        session.setAttribute("subject", subject);
                    }

                    if(r==1)
                    {
                        request.setAttribute("errormsg", "Added Successfully");
                        request.setAttribute("title", title);
                        request.setAttribute("subject",subject);
                        request.getRequestDispatcher("teacherindex.jsp").forward(request, response);
                    }
                    else
                    {
                        request.setAttribute("errormsg", "Try Again");
                        request.setAttribute("title", title);
                        request.setAttribute("subject",subject);
                        request.getRequestDispatcher("teacherindex.jsp").forward(request, response);
                    }
            } 
        }
        catch(Exception e)
        {
            request.setAttribute("errormsg", e.getMessage());
            request.getRequestDispatcher("teacherindex.jsp").forward(request, response);
        }
    }
}
