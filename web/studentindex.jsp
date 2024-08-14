<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Page</title>
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
            %>
        <div class="nav-container">
            <ul>
                <li>${welcome}</li>
                <li><a href="studentindex.jsp">Quiz's</a></li>
                <li><a href="result.jsp">Result</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </div>
        <p>${errormsg1}</p>
        <div class="makecontainer">
            
            <div class="makeform">
                
                <h3 class="formtitle">Search Quiz</h3>
                
                <form action="searchquiz.jsp" method="post">
                    
                    <div class="inputs">
                            <input type="text" name="search"/>
                            <input type="submit" value="Search"/>
                    </div>
                    <textarea name="errormsg" readonly class="errormsg" rows="3">${errormsg}</textarea>
                </form>
            </div>
        </div>
        
    </body>
</html>

