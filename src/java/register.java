import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class register extends HttpServlet 
{
    boolean result=true;
    String error="";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        try
        {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            
            String category,name,username,password,phonenumber,email,qualification;
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull", "root", "197447");
            String select="select * from register";
            String insert="insert into register values(?,?,?,?,?,?,?)";
            
            PreparedStatement ps=conn.prepareStatement(select);
            
            category=request.getParameter("category").trim();
            name=request.getParameter("name").trim();
            username=request.getParameter("username").trim();
            password=request.getParameter("password").trim();
            phonenumber=request.getParameter("number").trim();
            email=request.getParameter("email").trim().toLowerCase();
            qualification=request.getParameter("qualification").trim();

            if(category.isEmpty() || name.isEmpty() || username.isEmpty() || password.isEmpty() || phonenumber.isEmpty() || email.isEmpty() || qualification.isEmpty())
            {
                request.setAttribute("errormsg", "Please enter the details");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else
            {
                
                if(!Pattern.matches("^[a-zA-Z ]+$", name))
                {
                    error=error+"Enter only character in name box. ";
                }
                
                if(!Pattern.matches("^[a-zA-Z0-9]+$", username))
                {
                    error=error+"Enter username without whitespace (only character and number). ";
                 }
                else
                {
                    ResultSet data=ps.executeQuery();
                    while(data.next())
                    {
                        if(data.getString("username").equals(username))
                        {
                            error=error+"The username exists already, choose different. ";
                            break;
                        }
                    }
                } 
                if(phonenumber.length()==10)
                {
                    if(!Pattern.matches("^[0-9]+$", phonenumber))
                    {
                        error=error+"Enter only number in phone number box. ";
                    }
                    else
                    {
                        ResultSet data1=ps.executeQuery();
                        while(data1.next())
                        {
                            if(data1.getString("phonenumber").equals(phonenumber))
                            {
                                error=error+"The phonenumber exists already, choose different. ";
                            }
                        }
                    } 
                }
                else
                {
                    error=error+"Enter 10 digits phone number. ";
                }
                

                if(!Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", email))
                {
                    error=error+"Enter correct email. ";
                }
                else
                {
                    ResultSet data2=ps.executeQuery();
                    while(data2.next())
                    {
                        if(data2.getString("email").equals(email))
                        {
                            error=error+"The email exists already, choose different. ";;
                        }
                    }
                } 
            }
            if(error.isEmpty())
            {
                PreparedStatement ps1=conn.prepareStatement(insert);
                ps1.setString(1, category);
                ps1.setString(2, name);
                ps1.setString(3, username);
                ps1.setString(4, password);
                ps1.setString(5, phonenumber);
                ps1.setString(6, email);
                ps1.setString(7, qualification);
                
                int r=ps1.executeUpdate();
                
                if(r==1)
                {
                    request.setAttribute("errormsg", "Register Succesfully\nYour Username is "+username);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    error="";
                }
                else
                {
                    request.setAttribute("errormsg", "Re-Try again");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    error="";
                }
                ps1.close();
            }
            else
            {
                request.setAttribute("errormsg", error);
                request.getRequestDispatcher("register.jsp").forward(request, response);
                error="";
            }
            ps.close();
            conn.close();
        }
        catch(Exception e)
        {
            request.setAttribute("errormsg", e.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
