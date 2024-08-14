import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
import javax.servlet.http.HttpSession;

public class resultverification extends HttpServlet 
{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            HttpSession session=request.getSession();
            String questionno[]=new String[100],answer[]=new String[100];
            int count=0;
            String result[]=session.getAttribute("title_subject").toString().split("##");
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
                    
            String select="select questionno,answer from quizquestion where title=? and subject=?";
                        
            PreparedStatement ps=conn.prepareStatement(select);
            ps.setString(1, title);
            ps.setString(2, subject);
                        
            ResultSet rs=ps.executeQuery();
            int i=0;
            while(rs.next())
            {
                
                String ans=rs.getString("answer");
                String q=rs.getString("questionno");
                questionno[i]=q;
                
                String a=request.getParameter(q);
                answer[i]=a;
                
                if(ans.equals(a))
                {
                    count++;
                }
                i++;
            }
            out.println(count);
            session.setAttribute("score", count+" out of "+i);
            response.sendRedirect("displayresult.jsp");
        }
        catch(Exception e)
        {
            request.setAttribute("errormsg",e.getMessage());
            request.getRequestDispatcher("testquiz.jsp").forward(request, response);
        }
    }
}
