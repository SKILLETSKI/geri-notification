<%-- 
    Document   : bootstrap-result
    Created on : 15-Oct-2016, 21:25:18
    Author     : muhammadims.2013
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String bootstrapResult = (String) request.getAttribute("output");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p><%=bootstrapResult%></p>
    </body>
</html>
