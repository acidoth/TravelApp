<%--<jsp:useBean id="customer" class="main.TravelApp" scope="session"/>--%>

<%--
  Created by IntelliJ IDEA.
  User: chaamini
  Date: 7/22/13
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="styles.css"/>

<html>
<head>

    <title></title>
</head>
<body>

<%--<script>--%>
    <%--(function() {--%>
        <%--document.getElementsByName("ChennaiHotels").style.display="hidden";--%>
        <%--document.getElementsByName("SingaporeHotels").style.display = "hidden";--%>
        <%--document.getElementsByName("DubaiHotels").style.display = "hidden";--%>
        <%--document.getElementsByName("BangkokHotels").style.display = "hidden";--%>
        <%--document.getElementsByName("ColomboHotels").style.display = "hidden";--%>

    <%--})();--%>
<%--</script>--%>

<%--<script>--%>
    <%--function getElements(){--%>
        <%--window.alert("hierei");--%>
        <%--name1 = document.getElementsByName("name").valueOf();--%>
        <%--customer = new Customer();--%>
        <%--customer.setName(name1);--%>

        <%--travelApp = new TravelApp();--%>
        <%--travelApp.initialize(customer);--%>
    <%--}--%>
<%--</script>--%>

<%--<%--%>
    <%--String name1 = request.getParameter("name");--%>
    <%--Customer customer = new Customer() ;--%>
    <%--customer.setName(name1);--%>
<%--%>--%>
<%--<%--%>
    <%--String destinationFrom1= request.getParameter("destinationFrom");--%>
    <%--customer.setDestinationFrom(destinationFrom1);--%>
<%--%>--%>
<%--<%--%>
    <%--String destinationTo1 = request.getParameter("destinationTo");--%>
    <%--customer.setDestinationTo(destinationTo1);--%>
<%--%>--%>
<%--<%--%>
    <%--String stayInHotel1 = request.getParameter("stayInHotel");--%>
    <%--customer.setDestinationTo(stayInHotel1);--%>

    <%--TravelApp travelApp = new TravelApp();--%>
    <%--travelApp.initialize(customer);--%>
<%--%>--%>


<%--<script>--%>
    <%--function show(){--%>
        <%--if(document.getElementsByName("destinationTo").value=="Chennai") {--%>
            <%--document.getElementsByName("ChennaiHotels").show();--%>

        <%--}--%>
        <%--if(document.getElementsByName("destinationTo").value=="Singapore") {--%>
            <%--document.getElementsByName("SingaporeHotels").show();--%>
        <%--}--%>
        <%--if(document.getElementsByName("destinationTo").value=="Bangkok") {--%>
            <%--document.getElementsByName("BangkokHotels").show();--%>
        <%--}--%>
        <%--if(document.getElementsByName("destinationTo").value=="Dubai") {--%>
            <%--document.getElementsByName("DubaiHotels").show();--%>
        <%--}--%>
        <%--if(document.getElementsByName("destinationTo").value=="Colombo") {--%>
            <%--document.getElementsByName("ColomboHotels").show();--%>
        <%--}--%>
    <%--}--%>
<%--</script>--%>

<h3>Acidoth Tours</h3>
<h1>Plan your Tour</h1>

<form name="TravelApp" action="response.jsp" method="GET">
    Enter your name as in Passport:
    <input type="text" name="name"  /> <br>
    From:
    <select name="destinationFrom">
        <option value="Chennai">Chennai</option>
        <option value="Singapore">Singapore</option>
        <%--<option value="Dubai">Dubai</option>--%>
        <%--<option value="Bangkok">Bangkok</option>--%>
        <option value="Colombo">Colombo</option>
    </select>
    To:
    <select name="destinationTo">
        <option value="Singapore">Singapore</option>
        <%--<option value="Dubai">Dubai</option>--%>
        <%--<option value="Bangkok">Bangkok</option>--%>
        <option value="Colombo">Colombo</option>
        <option value="Chennai">Chennai</option>
    </select> <br>
    Date:
    <input type="text" name="Date"  />    <br>
    Hotel you Prefer:
    <select name="Hotels" onchange="show()" id="1" >
        <option value="Leela Palace">Leela Palace</option>
        <option value="Ramada Chennai">Ramada Chennai</option>
        <%--<option value="Raintree Hotel">Raintree Hotel</option>--%>
        <%--<option value="Green Park">Green Park</option>--%>
        <%--<option value="Hilton">Hilton</option>--%>
        <%--<option value="Ramada Chennai">Ramada Chennai</option>--%>
        <%--<option value="Cinnamon Grand">Cinnamon Grand</option>--%>
        <%--<option value="Green Park">Green Park</option>--%>
    </select>  <br>

    <%--<select name="SingaporeHotels" onchange="show()">--%>
        <%--<option value="V hotel">V Hotel</option>--%>
        <%--<option value="Sheraton Towers">Sheraton Towers</option>--%>
        <%--<option value="SingaX">SingaX</option>--%>
        <%--<option value="SingaY">SingaY</option>--%>
    <%--</select>--%>
    <%--<select name="DubaiHotels" onchange="show()">--%>
        <%--<option value="DubaiX">DubaiX</option>--%>
        <%--<option value="DubaiY">DubaiY</option>--%>
        <%--<option value="DubaiZ">DubaiZ</option>--%>
        <%--<option value="DubaiR">DubaiR</option>--%>
    <%--</select>--%>
    <%--<select name="BangkokHotels" onchange="show()">--%>
        <%--<option value="BangkokX">BangkokX</option>--%>
        <%--<option value="BangkokY">BangkokY</option>--%>
        <%--<option value="BangkokZ">BangkokZ</option>--%>
        <%--<option value="BangkokR">BangkokR</option>--%>
    <%--</select>--%>
    <%--<select name="ColomboHotels" onchange="show()">--%>
        <%--<option value="Hilton">Hilton</option>--%>
        <%--<option value="Renuka Hotel">Renuka Hotel</option>--%>
        <%--<option value="Galadari">Galadari</option>--%>
        <%--<option value="Cinnamon Grand">Cinnamon Grand</option>--%>
    <%--</select>--%>
    No of Nights:
    <input type="text" name="stayInHotel" />  <br><br>

    <input type="submit" value="Submit" />
</form>




</body>
</html>