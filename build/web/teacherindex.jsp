<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Teacher Page</title>
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
                height:5vh;
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
                height: 130vh;
                padding-top: 15vh;
                padding-left: 15vw;
            }
            .makeform
            {
                width:70vw;
                height:120vh;
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
            p
            {
                text-align: center;
                font-size: 18px;
                margin-top: 10px;
                color: red;
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
            %>
        <div class="nav-container">
            <ul>
                <li>${welcome}</li>
                <li><a href="teacherindex.jsp">Make Quiz</a></li>
                <li><a href="updatequestion.jsp">Update Question</a></li>
                <li><a href="delete.jsp">Delete Quiz</a></li>
                <li><a href="createdquiz.jsp">Created Quiz</a></li>
                <li><a href="selectappeared.jsp">Appeared Quiz</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </div>
                <p>${errormsg1}</p>
        <div class="makecontainer">
            
            <div class="makeform">
                
                <h3 class="formtitle">Make Quiz</h3>
                
                <form method="post">
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Title:</label>
                            <input type="text" name="title" value="${title}" maxlength="199"/>
                        </span>
                        <span class="spaninputs">
                            <label>Subject:</label>
                            <input type="text" name="subject" value="${subject}" maxlength="199"/>
                        </span>
                    </div>
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Question No:</label>
                            <input type="text" name="questionno" value="${questionno}" maxlength="199"/>
                        </span>
                        <span class="spaninputs">
                            <label>Question:</label>
                            <input type="text" name="question" maxlength="199"/>
                        </span>
                    </div>
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Option 1:</label>
                            <input type="text" name="option1" maxlength="199"/>
                        </span>
                        <span class="spaninputs">
                            <label>Option 2:</label>
                            <input type="text" name="option2" maxlength="199"/>
                        </span>
                    </div>
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Option 3:</label>
                            <input type="text" name="option3" maxlength="199"/>
                        </span>
                        <span class="spaninputs">
                            <label>Option 4:</label>
                            <input type="text" name="option4" maxlength="199"/>
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
                            <input type="submit" value="Add" formaction="addquestion" formmethod="post"/>
                        </span>
                        <span class="spaninputs">
                            <input type="submit" value="Submit" formaction="savequiz"/>
                        </span>
                    </div>
                    
                    <textarea name="errormsg" readonly class="errormsg" rows="3">${errormsg}</textarea>
                </form>
            </div>
        </div>
    </body>
</html>

