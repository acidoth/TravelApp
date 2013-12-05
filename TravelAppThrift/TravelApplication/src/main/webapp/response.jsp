<%@ page import="main.TravelApp" %>
<%@ page import="main.Customer" %>

<%--
  Created by IntelliJ IDEA.
  User: chaamini
  Date: 8/15/13
  Time: 6:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
     <%--<jsp:useBean id="mybean" scope="session" class="main.Customer" />--%>
     <%--<jsp:setProperty name="mybean" property="name" />--%>
     <%--<%String hotel1 = request.getParameter("Hotels");--%>
     <%--String name1 = request.getParameter("name");--%>
     <%--String destinationFrom1 = request.getParameter("destinationForm");--%>
     <%--String destinationTo1 = request.getParameter("destinationTo");--%>
     <%--String date1 = request.getParameter("Date");--%>
     <%--String stayInHotel1 = request.getParameter("stayInHotel");--%>
     <%--%>--%>

      <%
     TravelApp travelApp = new TravelApp();
     travelApp.initialize(new Customer(request.getParameter("name"),request.getParameter("destinationFrom"),
             request.getParameter("destinationTo"),request.getParameter("Date"),request.getParameter("Hotels"),
             request.getParameter("stayInHotel")));
      %>
     <%="Your Transaction is still on Processing"%>

</body>
</html>