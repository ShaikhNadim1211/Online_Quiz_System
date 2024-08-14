<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete Quiz</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        
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
            .deletecontainer
            {
                width:100vw;
                height: 70vh;
                padding-top: 15vh;
                padding-left: 30vw;
            }
            .deleteform
            {
                width:40vw;
                height:50vh;
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
                margin-left: 20%;
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
            select
            {
                width: 15vw;
                height:4vh;
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
                <li><a href="teacherindex.jsp"><img src="icon.png" alt="Home"></a></li>
            </ul>
        </div>
        
        <div class="deletecontainer">
            
            <div class="deleteform">
                
                <h3 class="formtitle">Delete Quiz</h3>
                
                <form action="deletequiz" method="post">
                    
                    <%
                        int i=0;
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull","root","197447");
                        
                        String select="select * from quizheading where username=?";
                        
                        PreparedStatement ps=conn.prepareStatement(select);
                        ps.setString(1, session.getAttribute("username").toString());
                        
                        ResultSet rs=ps.executeQuery();
                        out.println("<div class='inputs'><label>Title & Subject:</label><select name='title'>");
                        while(rs.next())
                        {
                            i=1;
                            String title=rs.getString(1).trim().replaceAll("\\s+", "\\$\\$\\$");
                            String subject = rs.getString(2).trim().replaceAll("\\s+", "\\$\\$\\$");

                            String value=title+"##"+subject;
                            out.println("<option value="+value+">Title: "+rs.getString(1)+", Subject: "+rs.getString(2)+"</option>");
                        }
                        out.println("</select></div>");
                       if(i==1)
                       {
                           
                       }
                       else
                       {
                           request.setAttribute("errormsg1", "Create your first quiz");
                           request.getRequestDispatcher("teacherindex.jsp").forward(request, response);
                       }
                        %>
                    
                    <div class="inputs">
                        <input type="submit" value="Delete"/>
                    </div>
                    
                    <textarea name="errormsg" readonly class="errormsg" rows="3">${errormsg}</textarea>
                </form>
            </div>
        </div>
    </body>
</html>

