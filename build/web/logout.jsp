<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head><script type="text/javascript">
            window.history.forward();
            function noBack()
            {
                window.history.forward();
            }
        </script>
    
    <body onload="noBack();" onpageshow="if (event.persisted) noBack();">
        <%
            if(session.getAttribute("name")!=null && session.getAttribute("username")!=null)
            {
                session.removeAttribute("name");
                session.removeAttribute("username");
                session.invalidate();
                response.sendRedirect("index.jsp");
            }
            
            %>
    </body>
</html>
