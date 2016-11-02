<%-- 
    Document   : authorise
    Created on : Nov 2, 2016, 3:47:56 AM
    Author     : Samantha
--%>
<%@page import ="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = request.getParameter("inputName");
            String password = request.getParameter("inputPassword");

            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            
            if(username.equals("admin") && password.equals("tetris")){
                session.setAttribute("username", "admin");
                response.sendRedirect("home.jsp");
                return;
            }else {
                request.setAttribute("error", "Invalid username / password");
                dispatcher.forward(request, response);
            }
           // CaregiverDAO dao = new CaregiverDAO();
           // ArrayList<CaregiverDAO> userlist = dao.retrieveAllUsers();

            /*for (int i = 0; i < userlist.size(); i++) {
                User user = userlist.get(i);
                System.out.println(user);
                String name = user.getUsername();
                String pwd = user.getPassword();

                if (username.equals(name) && password.equals(pwd)) {
                    session.setAttribute("username", name);
                    response.sendRedirect("home.jsp");
                    return;
                }
            }*/




        %>
    </body>
</html>
