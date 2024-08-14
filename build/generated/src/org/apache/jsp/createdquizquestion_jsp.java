package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class createdquizquestion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Question Page</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            body\n");
      out.write("            {\n");
      out.write("                background-color: #474747;\n");
      out.write("                overflow-x: hidden;\n");
      out.write("            }\n");
      out.write("            *\n");
      out.write("            {\n");
      out.write("                padding: 0px;\n");
      out.write("                margin:0px;\n");
      out.write("            }\n");
      out.write("            .nav-container\n");
      out.write("            {\n");
      out.write("                width: 100vw;\n");
      out.write("                height:7vh;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                padding-left: 10px;\n");
      out.write("                padding-bottom: 10px;\n");
      out.write("                border-bottom: 2px solid white;\n");
      out.write("            }\n");
      out.write("            ul\n");
      out.write("            {\n");
      out.write("                list-style-type: none;\n");
      out.write("            }\n");
      out.write("            li\n");
      out.write("            {\n");
      out.write("                float: left;\n");
      out.write("                padding-left: 30px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 26px;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            li a\n");
      out.write("            {\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 26px;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            li a:hover\n");
      out.write("            {\n");
      out.write("                text-decoration-line: underline;\n");
      out.write("            }\n");
      out.write("            .makecontainer\n");
      out.write("            {\n");
      out.write("                width:100vw;\n");
      out.write("                height: auto;\n");
      out.write("                padding-top: 15vh;\n");
      out.write("                padding-left: 25vw;\n");
      out.write("                margin-bottom: 15vh;\n");
      out.write("            }\n");
      out.write("            .makeform\n");
      out.write("            {\n");
      out.write("                width:50vw;\n");
      out.write("                height:auto;\n");
      out.write("                background-color: white;\n");
      out.write("                color: black;\n");
      out.write("                border-radius: 30px;\n");
      out.write("            }\n");
      out.write("            .formtitle\n");
      out.write("            {\n");
      out.write("                text-align: center;\n");
      out.write("                padding-top: 10px;\n");
      out.write("                font-size: 26px;\n");
      out.write("            }\n");
      out.write("            .inputs\n");
      out.write("            {\n");
      out.write("                padding-top: 6%;\n");
      out.write("                padding-left: 10%;\n");
      out.write("            }\n");
      out.write("            label\n");
      out.write("            {\n");
      out.write("                font-size: 18px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            input\n");
      out.write("            {\n");
      out.write("                width: 15vw;\n");
      out.write("                height:4vh;\n");
      out.write("                font-size: 18px;\n");
      out.write("            }\n");
      out.write("            .errormsg\n");
      out.write("            {\n");
      out.write("                margin-left: 5vw;\n");
      out.write("                margin-top: 3vh;\n");
      out.write("                width: 30vw;\n");
      out.write("                border: none;\n");
      out.write("                resize: none;\n");
      out.write("                color: red;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 18px;\n");
      out.write("            }\n");
      out.write("            </style>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            window.history.forward();\n");
      out.write("            function noBack()\n");
      out.write("            {\n");
      out.write("                window.history.forward();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"noBack();\" onpageshow=\"if (event.persisted) noBack();\">\n");
      out.write("        ");

            if(session.getAttribute("name")==null || session.getAttribute("username")==null)
            {
                request.setAttribute("errormsg","Please Login");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
       
      out.write("\n");
      out.write("        <div class=\"nav-container\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"createdquiz.jsp\"><img src=\"icon.png\" alt=\"Home\"></a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"makecontainer\">\n");
      out.write("            \n");
      out.write("            <div class=\"makeform\">\n");
      out.write("                \n");
      out.write("                <h3 class=\"formtitle\">Quiz</h3>\n");
      out.write("                \n");
      out.write("                <form method=\"post\" action=\"createdquizquestion.jsp\">\n");
      out.write("                    \n");
      out.write("                    ");

                        
                            String s=request.getParameter("title");
                            if(session.getAttribute("title_subject")==null)
                            {
                                session.setAttribute("title_subject", s);
                            }
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

                            String select="select * from quizquestion where username=? and title=? and subject=?";


                            PreparedStatement ps=conn.prepareStatement(select);
                            ps.setString(1, session.getAttribute("username").toString());
                            ps.setString(2,title);
                            ps.setString(3,subject);

                            ResultSet rs=ps.executeQuery();
                            out.println("<div class='inputs'><h1>Title: "+title+"</h1><br/><h1>Subject: "+subject+"</h1></br>");
                            while(rs.next())
                            {
                                out.println("<h3>"+rs.getString("questionno")+". "+rs.getString("question")+"</h3><br/>");
                                out.println("<p>Option 1: "+rs.getString("option1")+"</p><br/>");
                                out.println("<p>Option 2: "+rs.getString("option2")+"</p><br/>");
                                out.println("<p>Option 3: "+rs.getString("option3")+"</p><br/>");
                                out.println("<p>Option 4: "+rs.getString("option4")+"</p><br/>");
                                out.println("<h3>Answer: "+rs.getString("answer")+"</h3><br/>");
                            }
                            out.println("</div>");
                        
                        
      out.write("\n");
      out.write("                        \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
