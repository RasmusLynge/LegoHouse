<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : Rasmus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        <h1>Welcome to LEGOHOUSEMAKER</h1>

        <table>
            <tr>
                <td>Login</td>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" value="Customer@lego.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password" value="lego">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                <td>Or Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email" value="Enter your email">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" value="123">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" value="123">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<h2>Error!!</h2>");
                out.println(error);
            }
        %>
    </body>
</html>
