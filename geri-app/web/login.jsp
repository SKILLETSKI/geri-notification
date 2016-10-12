<%-- 
    Document   : login
    Created on : 11-Oct-2016, 13:42:06
    Author     : wl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<script src="js/bottstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>-->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
       <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="lib/angular/angular.js"></script>
        <script src="lib/angular-bootstrap/ui-bootstrap-tpls.js"></script>
        <script src="lib/js/main.js"></script>
        <title>GERI-Notification</title>
        
        <style>
            .border{
                border: 1px solid black;
            }
            
        </style>
    </head>
    <body>
        <div class="container">
            <div class="card border">
            <h1 class="text-center">Medication Box Page</h1>
            <div class="row">
            <form class="col-md-4 col-md-offset-4" action="login.jsp" method="POST">
                
                Name:<input type="text" id="PersonThreshold" name="PersonThreshold" /></br>
                Phone Number: <input type="text" id="PhoneNum" name="PhoneNum" /> </br>
                No. of misses: <input type="text" id="NumMisses" name="NumMisses" /></br>
                <button type="submit" class="btn btn-primary">Submit</button>
                <input type="submit" value="Submit" /> </br>
                
            </form>
            </div>
            </div>
        </div>
    </body>
</html>
