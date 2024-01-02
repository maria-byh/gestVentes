
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link rel="stylesheet" href="css/login.css">
       
    </head>
    <body>
  
        
            <div class="form">
              <p>Login</p>
               <form method="post" action="Login">
                <input type="text" id="username" name="username" placeholder="username">
                <input type="password" id="password" name="password" placeholder="password">
                <i class="fa fa-eye-slash show-pass" aria-hidden="true" id="eye1" onClick="changer1()"></i>

                   <input type="submit" value="Connecter" name="submit">


      </form>
               <script src="eye.js"></script>
      </div>
    </body>
    
</html>
