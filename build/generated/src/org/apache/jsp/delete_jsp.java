package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class delete_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Delete Quiz</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
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
      out.write("                height:5vh;\n");
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
      out.write("            .deletecontainer\n");
      out.write("            {\n");
      out.write("                width:100vw;\n");
      out.write("                height: 100vh;\n");
      out.write("                padding-top: 15vh;\n");
      out.write("                padding-left: 30vw;\n");
      out.write("            }\n");
      out.write("            .deleteform\n");
      out.write("            {\n");
      out.write("                width:40vw;\n");
      out.write("                height:70vh;\n");
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
      out.write("                margin-left: 20%;\n");
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
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"nav-container\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"teacherindex.html\">Home</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"deletecontainer\">\n");
      out.write("            \n");
      out.write("            <div class=\"deleteform\">\n");
      out.write("                \n");
      out.write("                <h3 class=\"formtitle\">Delete Quiz</h3>\n");
      out.write("                \n");
      out.write("                <form action=\"deletequiz\" method=\"post\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                        <label>Title:</label>\n");
      out.write("                        <input type=\"text\" name=\"title\"/>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                        <label>Subject:</label>\n");
      out.write("                        <input type=\"text\" name=\"subject\"/>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                        <label>Question:</label>\n");
      out.write("                        <input type=\"text\" name=\"question\"/>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                        <input type=\"submit\" value=\"Delete\"/>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <textarea name=\"errormsg\" readonly class=\"errormsg\" rows=\"3\"></textarea>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
