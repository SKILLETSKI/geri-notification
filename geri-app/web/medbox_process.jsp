<%-- 
    Document   : medbox_process
    Created on : Nov 2, 2016, 9:55:36 PM
    Author     : ASUS
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="geriapp.controller.MedboxEventController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
            String patientId = request.getParameter("patientId");
            String thresholdNo = request.getParameter("thresholdNo");
            String NumDosage = request.getParameter("NumDosage");
            String NumMissed = request.getParameter("NumMissed");
            
            MedboxEventController medboxEventController = new MedboxEventController();
            
            ArrayList<String> valueList = new ArrayList<>();
            valueList.add(patientId);
            valueList.add(thresholdNo);
            valueList.add(NumDosage);
            valueList.add(NumMissed);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("medbox.jsp");
            
            if(!patientId.equals(null) && !thresholdNo.equals(null) && !NumDosage.equals(null) && !NumMissed.equals(null) ){
                response.sendRedirect("medbox_Submit.jsp");
                session.setAttribute("values", valueList);
                medboxEventController.startTimer();
                boolean checkAlarm = medboxEventController.soundAlarm();
                return;
            }else {
                request.setAttribute("error", "Invalid Input");
                dispatcher.forward(request, response);
            }
%>