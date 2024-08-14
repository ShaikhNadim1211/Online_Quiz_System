<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        
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
                height: 70vh;
                padding-top: 15vh;
                padding-left: 30vw;
            }
            .makeform
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
                padding-left: 5vw;
            }
            input
            {
                width: 15vw;
                height:4vh;
                font-size: 18px;
            }
            h1
            {
                text-align: center;
                margin-top: 10vh;
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
                
                <h3 class="formtitle">Result</h3>
                
                <%
                    String username=session.getAttribute("username").toString();
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
                    String name=session.getAttribute("name").toString();
                    String score=session.getAttribute("score").toString();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull","root","197447");
                    
                    String insert="insert into appeared values(?,?,?,?,?)";
                        
                    PreparedStatement ps=conn.prepareStatement(insert);
                    ps.setString(1, username);
                    ps.setString(2,title);
                    ps.setString(3, subject);
                    ps.setString(4,name);
                    ps.setString(5, score);
                    
                    int r=ps.executeUpdate();
                    if(r==1)
                    {
                        request.setAttribute("scoree", "Your score is "+score);
                        session.removeAttribute("score");
                    }
                    else
                    {
                        request.setAttribute("scoree", "Give Test Again");
                        session.removeAttribute("score");
                        request.getRequestDispatcher("testquiz.jsp").forward(request, response);
                    }
                    %>
                    
                    <h1>${scoree}</h1>
            </div>
        </div>
    </body>
</html>
