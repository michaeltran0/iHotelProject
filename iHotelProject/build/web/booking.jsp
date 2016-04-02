<%-- 
    Document   : booking
    Created on : Mar 31, 2016, 5:24:01 PM
    Author     : hani
--%>

<%@page import="java.util.List"%>
<%@page import="model.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Booking jsp!</h1>

        <%

            try {
                List<Room> roomList = (List<Room>) request.getAttribute("rooms");
                if (roomList != null) {
                    for (Room r : roomList) {

                        out.print("<p>" + r.getRoomNo() + r.getFloorNo() + r.getRoomType() + r.getPrice() + r.isBathroom() + r.getDetails() + "</p>");
                    }
                } else {
                    out.print("roomList in NULL!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.print(e.getMessage());
            }
        %>

        <form action="BookingServlet">
            <input type="submit" name="add" value="add"/>
            <input type="submit" name="edit" value="edit"/>
            <input type="submit" name="remove" value="remove"/>
        </form>
        <a href="LogOutServlet">Log Out</a>
        <form action="LogOutServlet">
            <input type="submit" name="logout" value="Log Out"/>
        </form>
    </body>
</html>
