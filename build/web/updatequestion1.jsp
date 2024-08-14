<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Question</title>
        
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
                height: 140vh;
                padding-top: 15vh;
                padding-left: 15vw;
            }
            .makeform
            {
                width:70vw;
                height:130vh;
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
            }
            .spaninputs
            {
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
                width: 60vw;
                border: none;
                resize: none;
                color: red;
                text-align: center;
                font-size: 18px;
            }
            select
            {
                width:15vw;
                height: 4vh;
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
             request.setAttribute("title", title);
             request.setAttribute("subject",subject);
        %>
       
        
        <div class="nav-container">
            <ul>
                <li><a href="updatequestion.jsp"><img src="icon.png" alt="Home"></a></li>
            </ul>
        </div>
        
        <div class="makecontainer">
            
            <div class="makeform">
                
                <h3 class="formtitle">Update Question</h3>
                
                <form action="update" method="post" >
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Title:</label>
                            <input type="text" name="title" value="${title}" readonly/>
                        </span>
                        <span class="spaninputs">
                            <label>Subject:</label>
                            <input type="text" name="subject" value="${subject}" readonly/>
                        </span>
                    </div>
                    <%
                       
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizsystem?zeroDateTimeBehavior=convertToNull","root","197447");
                        
                        String select="select * from quizquestion where username=? and title=? and subject=?";
                        
                        PreparedStatement ps=conn.prepareStatement(select);
                        ps.setString(1, session.getAttribute("username").toString());
                        ps.setString(2, title);
                        ps.setString(3,subject);
                        
                        ResultSet rs=ps.executeQuery();
                        out.println("<div class='inputs'><span class='spaninputs'><label>Question:</label><select name='questionno'>");
                        while(rs.next())
                        {
                            out.println("<option value="+rs.getString("questionno")+">"+rs.getString("questionno")+". "+rs.getString("question")+"</option>");
                        }
                        out.println("</select></span></div>");
                        rs.close();
                        %>
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Update Question:</label>
                            <input type="text" name="question"/>
                        </span>
                    </div>
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Option 1:</label>
                            <input type="text" name="option1"/>
                        </span>
                        <span class="spaninputs">
                            <label>Option 2:</label>
                            <input type="text" name="option2"/>
                        </span>
                    </div>
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Option 3:</label>
                            <input type="text" name="option3"/>
                        </span>
                        <span class="spaninputs">
                            <label>Option 4:</label>
                            <input type="text" name="option4"/>
                        </span>
                    </div>
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Answer:</label>
                        </span>
                            <input type="radio" name="answer" value="option1"/><label>Option 1:</label>
                            <input type="radio" name="answer" value="option2"/><label>Option 2:</label><br/><br/>
                            <input type="radio" name="answer" value="option3"/><label>Option 3:</label>
                            <input type="radio" name="answer" value="option4"/><label>Option 4:</label>
                    </div>
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <input type="submit" value="Update" />
                        </span>
                    </div>
                    
                    <textarea name="errormsg" readonly class="errormsg" rows="3">${errormsg}</textarea>
                </form>
            </div>
        </div>
    </body>
</html>
