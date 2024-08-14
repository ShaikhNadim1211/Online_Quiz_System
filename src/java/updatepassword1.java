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

public class updatepassword1 extends HttpServlet 
{
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            String category,username,oldpassword,newpassword,confirmpassword,error;
            
            HttpSession session=request.getSession();
            
            category=session.getAttribute("category").toString();
            username=session.getAttribute("username").toString();
            oldpassword=request.getParameter("oldpass").trim();
            newpassword=request.getParameter("newpass").trim();
            confirmpassword=request.getParameter("confpass").trim();
            
            if(oldpassword.isEmpty() || newpassword.isEmpty() || confirmpassword.isEmpty())
            {
                request.setAttribute("errormsg", "Enter passwords");
                request.getRequestDispatcher("updatepassword1.jsp").forward(request, response);
            }
            else
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull", "root", "197447");
                String select="select * from register where category=? and username=?";
                
                PreparedStatement ps=conn.prepareStatement(select);
                ps.setString(1,category);
                ps.setString(2, username);
                
                ResultSet rs=ps.executeQuery();
                
                while(rs.next())
                {
                    if(rs.getString("password").equals(oldpassword))
                    {
                        if(rs.getString("password").equals(newpassword))
                        {
                            request.setAttribute("errormsg", "New password should not same as the old password");
                            request.getRequestDispatcher("updatepassword1.jsp").forward(request, response);
                        }
                        else
                        {
                            if(newpassword.equals(confirmpassword))
                            {
                                Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull", "root", "197447");
                                String update="update register set password=? where category=? and username=?";

                                PreparedStatement ps1=conn.prepareStatement(update);
                                ps1.setString(1,newpassword);
                                ps1.setString(2,category);
                                ps1.setString(3, username);
                                
                                int r=ps1.executeUpdate();
                                
                                if(r==1)
                                {
                                    request.setAttribute("errormsg", "Password Updated Successfully");
                                    request.getRequestDispatcher("index.jsp").forward(request, response);
                                }
                                else
                                {
                                    request.setAttribute("errormsg", "Try Again");
                                    request.getRequestDispatcher("index.jsp").forward(request, response);
                                }
                            }
                            else
                            {
                                request.setAttribute("errormsg", "New and confirm password does not match");
                                request.getRequestDispatcher("updatepassword1.jsp").forward(request, response);
                            }
                        }
                    }
                    else
                    {
                        request.setAttribute("errormsg", "Old password does not match");
                        request.getRequestDispatcher("updatepassword1.jsp").forward(request, response);
                    }
                }
            }
        }
        catch(Exception e)
        {
            request.setAttribute("errormsg", e.getMessage());
            request.getRequestDispatcher("updatepassword1.jsp").forward(request, response);
        }
    }
}
