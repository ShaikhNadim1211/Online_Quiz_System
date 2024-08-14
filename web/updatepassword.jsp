<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Password</title>
        
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
                height: 80vh;
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
            select
            {
                width:15vw;
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
        <div class="nav-container">
            <ul>
                <li><a href="index.jsp"><img src="icon.png" alt="Home"></a></li>
            </ul>
        </div>
        
        <div class="makecontainer">
            
            <div class="makeform">
                
                <h3 class="formtitle">Update Password</h3>
                
                <form method="post" action="updatepassword">
                    
                    <div class="inputs">
                        <label>Category:</label>
                            <select name="category">
                                <option value="student">Student</option>
                                <option value="teacher">Teacher</option>
                            </select>
                    </div>
                    <div class="inputs">
                        <label>Username:</label>
                        <input type="text" name="username" placeholder="Enter your username"/>
                    </div>
                        
                    <div class="inputs">
                        <input type="submit" value="Submit"/>
                    </div>
                    <textarea name="errormsg" readonly class="errormsg" rows="3">${errormsg}</textarea>
                </form>
            </div>
        </div>
    </body>
</html>
