<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
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
            .logincontainer
            {
                width:100vw;
                height: 100vh;
                padding-top: 15vh;
                padding-left: 30vw;
            }
            .loginform
            {
                width:40vw;
                height:90vh;
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
                padding-left: 20%;
                padding-top: 10%;
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
            .loginbutton
            {
                margin-left: 5vw;
            }
            .about
            {
                width: 100vw;
                height: 20vh;
                border-top: 2px solid white;
                padding: 20px;
                color: white;
            }
            h4
            {
                padding-left: 10px;
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
            #forgotpassword
            {
                font-size: 18px;
                color: black;
                text-decoration: none;
            }
            #forgotpassword:hover
            {
                text-decoration-line: underline;
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
                <li><a href=index.jsp>Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>
        </div>
        
        <div class="logincontainer">
            
            <div class="loginform">
                
                <h3 class="formtitle">Login Form</h3>
                
                <form action="login" method="post">
                    
                    <div class="inputs">
                        <label>Category:</label>
                        <select name="category">
                            <option value="student">Student</option>
                            <option value="teacher">Teacher</option>
                        </select>
                    </div>
                    
                    <div class="inputs">
                        <label>Username:</label>
                        <input type="text" name="username" placeholder="Enter your username" maxlength="50"/>
                    </div>
                    
                    <div class="inputs">
                        <label>Password:</label>
                        <input type="text" name="password" placeholder="Enter your password" maxlength="50"/>
                    </div>
                    
                    <div class="inputs">
                       <input type="submit" value="Login" class="loginbutton"/>
                    </div>
                    <div class="inputs">
                        <a href="updatepassword.jsp" id="forgotpassword">Forgot Password?</a>
                    </div>
                    <textarea name="errormsg" readonly class="errormsg" rows="3">${errormsg}</textarea>
                </form>
            </div>
        </div>
        <div class="about" id="about">
            <h3>Contact Us:</h3>
            <h4>Contact Number: 1234567890</h4>
            <h4>Email: xyz@gmail.com</h4>
            <h4>Instagram: xyz</h4>
            <h4>Facebook: xyz</h4>
        </div>
    </body>
</html>

