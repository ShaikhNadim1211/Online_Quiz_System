<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appeared Quiz</title>
        
        <style>
            body
            {
                background-color: #474747;
                overflow-x: hidden;
            }
            *
            {
                padding: 0px;
                margin:0px;
            }
            .nav-container
            {
                width: 100vw;
                height:7vh;
                margin-top: 10px;
                padding-left: 10px;
                padding-bottom: 10px;
                border-bottom: 2px solid white;
            }
            ul
            {
                list-style-type: none;
            }
            li
            {
                float: left;
                padding-left: 30px;
                text-decoration: none;
                font-size: 26px;
                color: white;
            }
            li a
            {
                text-decoration: none;
                font-size: 26px;
                color: white;
            }
            li a:hover
            {
                text-decoration-line: underline;
            }
            .makecontainer
            {
                width:100vw;
                height: auto;
                padding-top: 15vh;
                padding-left: 25vw;
            }
            .makeform
            {
                width:50vw;
                height:auto;
                background-color: white;
                color: black;
                border-radius: 30px;
            }
            .formtitle
            {
                text-align: center;
                padding-top: 10px;
                font-size: 26px;
            }
            .inputs
            {
                padding-top: 6%;
                padding-left: 10%;
            }
            label
            {
                font-size: 18px;
                font-weight: bold;
            }
            input
            {
                width: 15vw;
                height:4vh;
                font-size: 18px;
            }
            .errormsg
            {
                margin-left: 5vw;
                margin-top: 3vh;
                width: 30vw;
                border: none;
                resize: none;
                color: red;
                text-align: center;
                font-size: 18px;
            }
            </style>
            <script type="text/javascript">
            window.history.forward();
            function noBack()
            {
                window.history.forward();
            }
        </script>
    </head>
    <body onload="noBack();" onpageshow="if (event.persisted) noBack();">
        <%
            if(session.getAttribute("name")==null || session.getAttribute("username")==null)
            {
                request.setAttribute("errormsg","Please Login");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
       %>
        <div class="nav-container">
            <ul>
                <li><a href="studentindex.jsp"><img src="icon.png" alt="Home"></a></li>
            </ul>
        </div>
        
        <div class="makecontainer">
            
            <div class="makeform">
                
                <h3 class="formtitle">Appeared</h3>
                
                <form method="post" action="result.jsp">
                    
                    <%
                            int num=0;
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull","root","197447");

                            String select="select * from appeared where username=? and name=?";


                            PreparedStatement ps=conn.prepareStatement(select);
                            ps.setString(1, session.getAttribute("username").toString());
                            ps.setString(2,session.getAttribute("name").toString());

                            ResultSet rs=ps.executeQuery();
                            out.println("<div class='inputs'>");
                            int i=0;
                            while(rs.next())
                            {
                                num=1;
                                i++;
                                out.println("<h2>"+i+". </h2><br/>");
                                out.println("<h3>Title: "+rs.getString("title")+"</h3><br/>");
                                out.println("<h3>Subject: "+rs.getString("subject")+"</h3><br/>");
                                out.println("<h3>Score: "+rs.getString("score")+"</h3><br/>");
                                out.println("<br/><br/>");
                            }
                            out.println("</div>");
                        if(num==1)
                        {
                            
                        }
                        else
                        {
                            request.setAttribute("errormsg1", "Attempt your first quiz");
                            request.getRequestDispatcher("studentindex.jsp").forward(request, response);
                        }
                        %>
                        
                </form>
            </div>
    </body>
</html>
