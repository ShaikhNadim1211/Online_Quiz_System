package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class teacherindex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Teacher Page</title>\n");
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
      out.write("                height: 130vh;\n");
      out.write("                padding-top: 15vh;\n");
      out.write("                padding-left: 15vw;\n");
      out.write("            }\n");
      out.write("            .makeform\n");
      out.write("            {\n");
      out.write("                width:70vw;\n");
      out.write("                height:120vh;\n");
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
      out.write("            }\n");
      out.write("            .spaninputs\n");
      out.write("            {\n");
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
      out.write("                width: 60vw;\n");
      out.write("                border: none;\n");
      out.write("                resize: none;\n");
      out.write("                color: red;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 18px;\n");
      out.write("            }\n");
      out.write("            p\n");
      out.write("            {\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 18px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                color: red;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script type=\"text/javascript\">\n");
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
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("welcome", "Welcome, "+session.getAttribute("name"));
            }
            if(session.getAttribute("title")!=null && session.getAttribute("subject")!=null)
            {
                request.setAttribute("title",session.getAttribute("title"));
                request.setAttribute("subject",session.getAttribute("subject"));
            }
            
      out.write("\n");
      out.write("        <div class=\"nav-container\">\n");
      out.write("            <ul>\n");
      out.write("                <li>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${welcome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("                <li><a href=\"teacherindex.jsp\">Make Quiz</a></li>\n");
      out.write("                <li><a href=\"updatequestion.jsp\">Update Question</a></li>\n");
      out.write("                <li><a href=\"delete.jsp\">Delete Quiz</a></li>\n");
      out.write("                <li><a href=\"createdquiz.jsp\">Created Quiz</a></li>\n");
      out.write("                <li><a href=\"selectappeared.jsp\">Appeared Quiz</a></li>\n");
      out.write("                <li><a href=\"logout.jsp\">Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errormsg1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("        <div class=\"makecontainer\">\n");
      out.write("            \n");
      out.write("            <div class=\"makeform\">\n");
      out.write("                \n");
      out.write("                <h3 class=\"formtitle\">Make Quiz</h3>\n");
      out.write("                \n");
      out.write("                <form method=\"post\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <label>Title:</label>\n");
      out.write("                            <input type=\"text\" name=\"title\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"199\"/>\n");
      out.write("                        </span>\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <label>Subject:</label>\n");
      out.write("                            <input type=\"text\" name=\"subject\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${subject}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"199\"/>\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <label>Question No:</label>\n");
      out.write("                            <input type=\"text\" name=\"questionno\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${questionno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"199\"/>\n");
      out.write("                        </span>\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <label>Question:</label>\n");
      out.write("                            <input type=\"text\" name=\"question\" maxlength=\"199\"/>\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <label>Option 1:</label>\n");
      out.write("                            <input type=\"text\" name=\"option1\" maxlength=\"199\"/>\n");
      out.write("                        </span>\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <label>Option 2:</label>\n");
      out.write("                            <input type=\"text\" name=\"option2\" maxlength=\"199\"/>\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <label>Option 3:</label>\n");
      out.write("                            <input type=\"text\" name=\"option3\" maxlength=\"199\"/>\n");
      out.write("                        </span>\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <label>Option 4:</label>\n");
      out.write("                            <input type=\"text\" name=\"option4\" maxlength=\"199\"/>\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <label>Answer:</label>\n");
      out.write("                        </span>\n");
      out.write("                            <input type=\"radio\" name=\"answer\" value=\"option1\"/><label>Option 1:</label>\n");
      out.write("                            <input type=\"radio\" name=\"answer\" value=\"option2\"/><label>Option 2:</label><br/><br/>\n");
      out.write("                            <input type=\"radio\" name=\"answer\" value=\"option3\"/><label>Option 3:</label>\n");
      out.write("                            <input type=\"radio\" name=\"answer\" value=\"option4\"/><label>Option 4:</label>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <input type=\"submit\" value=\"Add\" formaction=\"addquestion\" formmethod=\"post\"/>\n");
      out.write("                        </span>\n");
      out.write("                        <span class=\"spaninputs\">\n");
      out.write("                            <input type=\"submit\" value=\"Submit\" formaction=\"savequiz\"/>\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <textarea name=\"errormsg\" readonly class=\"errormsg\" rows=\"3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errormsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
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
