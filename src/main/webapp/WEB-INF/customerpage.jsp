<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : Rasmus
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=((User) session.getAttribute("user")).getEmail()%> </h1>
        You are now logged in as a customer of our wonderful site.
    </body>
    <table> 

        <td>
            <img src="https://datsoftlyngby.github.io/dat2sem2018Fall/Modul3/legowalls01.jpg" alt="W3Schools.com" style="width:480px;height:380px;">
        <td>

        <tr>
            <td>
                <form name="HouseSize" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="HouseSize">
                    house length:<br>
                    <input type="text" name="houselength" value="13">
                    <br>
                    house width:<br>
                    <input type="text" name="housewidth" value="9">
                    <br>
                    house height (layer count):<br>
                    <input type="text" name="househeight" value="4">
                    <br>
                    Do you want a Window and a Door in your legohouse?<br>
                    <select name="windowDoor">
                        <option value="false">No</option>
                        <option value="true">Yes</option>
                    </select>
                    <br>
                    <input type="submit" value="Submit">
                </form>

                <form name="ShowOrders" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="ShowOrders">
                    <input type="submit" value="Show Previous Orders">
                </form>
                <br>
                <form name="LogOut" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="LogOut">
                    <br>
                    <input type="submit" value="Log Out">
                </form>
            </td>


        </tr>
    </table>
    <% String error = (String) request.getAttribute("error");
        if (error != null) {
            out.println("<H2>Error!!</h2>");
            out.println(error);
        }
    %>


</html>
