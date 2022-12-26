<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Contact Us</title>
      <link rel="stylesheet" type="text/css" href="contactus.css">
   </head>
   <body>
      <div id="contactform">
         <h1>Contact Us</h1>
         <form  action="contactus" method="post">
            <div id="name">
               <label id="label">Name:</label>
               <br>
               <input type="text" name="name" placeholder="Enter the name" required>
               <br>
            </div>
            <div id="email">
               <br>
               <label id="label">Email:</label>
               <br>
               <input type="email" name="email" placeholder="Enter the email id" required>
            </div>
            <div id="message">
               <br>
               <label id="label">Message:</label>
               <br>
               <textarea  name="message" rows="15" cols="40" placeholder="Enter your message" required></textarea>
               <br>
            </div>
            <div id="submit">
               <input type="Submit" class="submit">
            </div>
         </form>
      </div>
   </body>
</html>