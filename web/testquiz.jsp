<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
        
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
                padding-top: 10vh;
                padding-left: 25vw;
            }
            .makeform
            {
                width:50vw;
                height:auto;
                background-color: white;
                color: black;
                border-radius: 30px;
                margin-bottom: 20vh;
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
            .submit
            {
                margin-bottom: 10vh;
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
        <%
             String s=request.getParameter("title").trim();
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
        %>
        <div class="makecontainer">
            
            <div class="makeform">
                
                <h3 class="formtitle">Quiz</h3>
                
                <form method="post" action="resultverification" id="form">
                    
                    <%
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull","root","197447");
                    
                        String select="select * from quizquestion where title=? and subject=?";
                        
                        PreparedStatement ps=conn.prepareStatement(select);
                        ps.setString(1, title);
                        ps.setString(2, subject);
                        
                        ResultSet rs=ps.executeQuery();
                        
                        out.println("<div class='inputs'><h1>Title: "+title+"</h1><br/><h1>Subject: "+subject+"</h1></br>");
                        while(rs.next())
                        {
                            String questionno=rs.getString(4);
                            String question=rs.getString(5);
                            String option1=rs.getString(6);
                            String option2=rs.getString(7);
                            String option3=rs.getString(8);
                            String option4=rs.getString(9);
                            
                            out.println("<h3>"+questionno+". "+question+"</h3><br/>");
                            out.println("<input type='radio' name="+questionno+" value='option1'/><label>"+option1+"</label><br/>");
                            out.println("<input type='radio' name="+questionno+" value='option2'/><label>"+option2+"</label><br/>");
                            out.println("<input type='radio' name="+questionno+" value='option3'/><label>"+option3+"</label><br/>");
                            out.println("<input type='radio' name="+questionno+" value='option4'/><label>"+option4+"</label><br/>");
                            out.println("<br/><br/><br/>");
                        }
                        
                    %>
                    
                    <input type="submit" value="Submit" class="submit"/>
                </form>
            </div>     
    </body>
</html>
