<%-- 
    Document   : medbox_process
    Created on : Nov 2, 2016, 9:55:36 PM
    Author     : ASUS
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="geriapp.controller.MedboxEventController"%>
<%@page import="com.twilio.*"%>
<%@page import="com.twilio.sdk.*"%>
<%@page import="com.twilio.sdk.TwilioRestClient"%>
<%@page import="com.twilio.sdk.TwilioRestException"%>
<%@page import="com.twilio.sdk.resource.instance.Account"%>
<%@page import="com.twilio.sdk.resource.factory.SmsFactory"%>
<%@page import="org.apache.http.NameValuePair"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
            String patientId = request.getParameter("patientId");
            String thresholdNo = request.getParameter("thresholdNo");
            String NumDosage = request.getParameter("NumDosage");
            String NumMissed = request.getParameter("NumMissed");
            
            String toPhone = "+6586568835";
            String TWILIO_ACCOUNT_SID = "ACec01a875b5cc448f2b2e903087059d29";
            String TWILIO_AUTH_TOKEN = "16f2063d70f35433fb14a141c308becf";
            String TWILIO_NUMBER = "+447481337150";
            TwilioRestClient twilioClient = new TwilioRestClient(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
            Account userAccount = twilioClient.getAccount();

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
                if(checkAlarm == true){
                    SmsFactory smsFactory = userAccount.getSmsFactory();
                    Map<String, String> smsParams = new HashMap<String, String>();
                    smsParams.put("To", toPhone);
                    smsParams.put("From", TWILIO_NUMBER);
                    smsParams.put("Body", "Patient has not taken medication!");
                    smsFactory.create(smsParams);
                }else{
                    SmsFactory smsFactory = userAccount.getSmsFactory();
                    Map<String, String> smsParams = new HashMap<String, String>();
                    smsParams.put("To", toPhone);
                    smsParams.put("From", TWILIO_NUMBER);
                    smsParams.put("Body", "Patient is taking medication as per normal!");
                    smsFactory.create(smsParams);
                }
                return;
            }else {
                request.setAttribute("error", "Invalid Input");
                dispatcher.forward(request, response);
            }
%>