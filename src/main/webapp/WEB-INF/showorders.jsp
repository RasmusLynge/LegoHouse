<%-- 
    Document   : showorders
    Created on : 11-10-2018, 10:25:09
    Author     : Rasmu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.HouseOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>

        <h1>Your Previous Orders</h1>

        <%
            ArrayList<HouseOrder> orderList = (ArrayList) session.getAttribute("orderList");

            for (int i = 0; i < orderList.size(); i++) {
                out.println("<form name=\"ShowOrder\" action=\"FrontController\" method=\"POST\">\n"
                        + "<input type=\"hidden\" name=\"command\" value=\"ShowOrder\">"
                        + "<input type=\"submit\" value=\"" + orderList.get(i).toString()+ "\">"
                        + "<input type=\"hidden\" name=\"orderId\" value=\"" + orderList.get(i).getIdOrder() + "\"><br>" //virker ikke optimalt: orderId vil altid ligge sig, til den første ordre på siden...
                );

            }
        %>
        </form>



        <form name="BackPage" action="FrontController" method="POST">
            <input type="hidden" name="command" value="BackPage">
            <br>
            <input type="submit" value="Go Back">
        </form>

        <form name="LogOut" action="FrontController" method="POST">
            <input type="hidden" name="command" value="LogOut">
            <br>
            <input type="submit" value="Log Out">
        </form>
    </center>
</body>
</html>
