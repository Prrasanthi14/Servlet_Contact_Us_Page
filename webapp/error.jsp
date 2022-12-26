<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Bad Login</title>
   </head>
   <body>
      <h1 style="text-align:center"> Wrong Username/Password , Try Again!</h1>
      <%response.setHeader("Refresh","2 ; URL=login.jsp"); %>
   </body>
</html>