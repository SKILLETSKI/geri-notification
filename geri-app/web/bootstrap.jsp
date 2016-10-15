<%-- 
    Document   : bootstrap
    Created on : 15-Oct-2016, 20:47:51
    Author     : muhammadims.2013
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Bootstrap" method="post">
            <h1>Upload JSON</h1>
            <p>File: <input type="file" name="pathToFile" size="125"/></p>
            <p>Database Name: <input type="text" name="dbName"/></p>
            <p>Collection Name: <input type="text" name="collectionName"/></p>
            <p><input type="submit" value="Submit"/></p>
        </form>
    </body>
</html>
