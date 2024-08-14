<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <li><a href="selectappeared.jsp"><img src="icon.png" alt="Home"></a></li>
            </ul>
        </div>
        
        <div class="makecontainer">
            
            <div class="makeform">
                
                <h3 class="formtitle">Appeared</h3>
                
                <form method="post">
                    
                    <%
                            int num=0;
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

                            String select="select * from appeared where title=? and subject=?";


                            PreparedStatement ps=conn.prepareStatement(select);
                            ps.setString(1, title);
                            ps.setString(2,subject);

                            ResultSet rs=ps.executeQuery();
                            out.println("<div class='inputs'>");
                            out.println("<h2>Title: "+title+"</h2><br/>");
                            out.println("<h2>Subject: "+subject+"</h2><br/>");
                            int i=0;
                            boolean r=rs.next();
                            while(r)
                            {
                                num=1;
                                i++;
                                out.println("<h2>"+i+". </h2><br/>");
                                out.println("<h3>Name: "+rs.getString("name")+"</h3><br/>");
                                out.println("<h3>Score: "+rs.getString("score")+"</h3><br/>");
                                out.println("<br/><br/>");
                                r=rs.next();
                            }
                            out.println("</div>");
                        if(num==1)
                        {
                            
                        }
                        else
                        {
                            request.setAttribute("errormsg1", "No one appeared for quiz");
                            request.getRequestDispatcher("teacherindex.jsp").forward(request, response);
                        }
                        %>
                        
                </form>
            </div>
    </body>
</html>
