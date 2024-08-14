<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration Page</title>
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
            .registercontainer
            {
                width:100vw;
                height: 100vh;
                padding-top: 15vh;
                padding-left: 15vw;
            }
            .registerform
            {
                width:70vw;
                height:85vh;
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
                padding-top: 7%;
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
            input,select
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
            .lowercase
            {
                text-transform: lowercase;
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
                <li><a href=index.jsp><img src="icon.png" alt="Home"></a></li>
            </ul>
        </div>
        
        <div class="registercontainer">
            
            <div class="registerform">
                
                <h3 class="formtitle">Registration Form</h3>
                
                <form action="register" method="post">
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Category:</label>
                            <select name="category">
                                <option value="student">Student</option>
                                <option value="teacher">Teacher</option>
                            </select>
                        </span>
                        <span class="spaninputs">
                            <label>Name:</label>
                            <input type="text" name="name" placeholder="Enter your name" maxlength="50"/>
                        </span>
                    </div>
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Username:</label>
                            <input type="text" name="username" placeholder="Create your username" maxlength="50"/>
                        </span>
                        <span class="spaninputs">
                            <label>Password:</label>
                            <input type="text" name="password" placeholder="Create your password" maxlength="50"/>
                        </span>
                    </div>
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Phone Number:</label>
                            <input type="text" name="number" placeholder="Enter your number" maxlength="10"/>
                        </span>
                        <span class="spaninputs">
                            <label>Email:</label>
                            <input type="text" name="email" placeholder="Enter your email" maxlength="50" class="lowercase"/>
                        </span>
                    </div>
                    
                    <div class="inputs">
                        <span class="spaninputs">
                            <label>Qualification:</label>
                            <input type="text" name="qualification" placeholder="10th/12th/Graduation..." maxlength="50"/>
                        </span>
                        <span class="spaninputs">
                            <input type="submit" value="Register"/>
                        </span>
                    </div>
                    
                    <textarea name="errormsg" readonly class="errormsg" rows="3">${errormsg}</textarea>
                </form>
            </div>
        </div>
    </body>
</html>

