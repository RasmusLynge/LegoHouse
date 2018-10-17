<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : Rasmus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.HouseOrder"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>

        <h1>Hello <%=((User) session.getAttribute("user")).getEmail()%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
        <br>


        <%
            ArrayList<HouseOrder> orderList = (ArrayList) session.getAttribute("allOrderList");

            for (int i = 0; i < orderList.size(); i++) {
                out.println("<form name=\"ShowOrder\" action=\"FrontController\" method=\"POST\">\n"
                        + "<input type=\"hidden\" name=\"command\" value=\"ShowOrder\">"
                        + "<input type=\"submit\" value=\"" + orderList.get(i).toString()+ "\">"
                        + "<input type=\"hidden\" name=\"orderId\" value=\"" + orderList.get(i).getIdOrder() + "\"><br>" 
                        //Den sidste linje er til "isShipped" og virker ikke optimalt: orderId vil altid ligge sig, til den første ordre på siden...
                        
                        /*
                        + "<input type=\"hidden\" name=\"command\" value=\"IsShipped\">"
                        + "<input type=\"submit\" value=\"Ship Order\">"
                        + "<input type=\"hidden\" name=\"orderId\" value=\" " + orderList.get(i).getIdOrder() +" \"> <br>"
                        */
                );

            }
        %>
    </form>

    <form name="LogOut" action="FrontController" method="POST">
        <input type="hidden" name="command" value="LogOut">
        <input type="submit" value="Log Out">
        <br>
    </form>
</body>
</html>
