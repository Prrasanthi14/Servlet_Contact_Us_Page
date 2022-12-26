<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
      <link rel="stylesheet" href="login.css" />
   </head>
   <body>
      <%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
      <div id="main-form">
         <form class="center" action="login" method="post">
            <h1>Admin</h1>
            <br><br>
            <div id="name">Name:<br><input type="text" name="name"><br><br></div>
            <div id="password">Password:<br><input type="password"  name="password"><br><br></div>
            <div id="submit"><input type="Submit"></div>
         </form>
      </div>
   </body>
</html>