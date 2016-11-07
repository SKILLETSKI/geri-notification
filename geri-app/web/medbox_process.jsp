<%-- 
    Document   : medbox_process
    Created on : Nov 2, 2016, 9:55:36 PM
    Author     : ASUS
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="geriapp.controller.MedboxEventController"%>
<%@page import="com.twilio.*"%>
<%@page import="org.apache.http.impl.client.CloseableHttpClient"%>
<%@page import="org.apache.http.impl.client.HttpClientBuilder"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.http.client.HttpClient"%>

<%@page import="org.apache.http.message.BasicNameValuePair"%>
<%@page import="org.apache.http.client.entity.UrlEncodedFormEntity"%>
<%@page import="org.apache.http.client.methods.HttpPost"%>
<%@page import="org.apache.http.client.methods.CloseableHttpResponse"%>
<%@page import="org.apache.http.impl.client.HttpClients"%>
<%@page import="org.apache.http.HttpResponse"%>
<%@page import="org.apache.http.client.methods.HttpGet"%>
<%@page import="org.apache.http.client.ClientProtocolException"%>"
<%@page import="com.twilio.sdk.*"%>
<%@page import="com.twilio.sdk.TwilioRestClient"%>
<%@page import="com.twilio.sdk.TwilioRestException"%>
<%@page import="com.twilio.sdk.resource.instance.Account"%>
<%@page import="com.twilio.sdk.resource.factory.SmsFactory"%>
<%@page import="org.apache.http.NameValuePair"%>
<%@page import="org.apache.http.client.methods.HttpUriRequest"%>
<%@page import="org.apache.commons.logging.LogFactory"%>
<%@page import="org.apache.commons.lang3.time.FastDateFormat"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="org.codehaus.jackson.JsonParseException"%>
<%@page import="org.codehaus.jackson.map.JsonMappingException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
            String patientId = request.getParameter("patientId");
            String thresholdNo = request.getParameter("thresholdNo");
            String numDosage = request.getParameter("NumDosage");
            String numMissed = request.getParameter("NumMissed");
            
//            String toPhone = "+6586568835";
//            String TWILIO_ACCOUNT_SID = "ACec01a875b5cc448f2b2e903087059d29";
//            String TWILIO_AUTH_TOKEN = "16f2063d70f35433fb14a141c308becf";
//            String TWILIO_NUMBER = "+447481337150";
//            TwilioRestClient twilioClient = new TwilioRestClient(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
//            Account userAccount = twilioClient.getAccount();

//            MedboxEventController medboxEventController = new MedboxEventController();
//            //set medbox rule first
//            int threshold = Integer.parseInt(thresholdNo)*60*1000;
//            int numOfTakes = Integer.parseInt(numDosage);
//            int numOfMissed = Integer.parseInt(numMissed);
//            medboxEventController.setMedboxEvent(patientId, threshold, numOfTakes, numOfMissed);
            int threshold = Integer.parseInt(thresholdNo)*1000;
            int numOfTakes = Integer.parseInt(numDosage);
            int numOfMissed = Integer.parseInt(numMissed);
            
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://default-environment.bxypxxac43.ap-southeast-1.elasticbeanstalk.com/MedboxTimer");

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("threshold", ""+threshold));
            params.add(new BasicNameValuePair("numOfTakes", ""+numOfTakes));
            params.add(new BasicNameValuePair("numOfMissed", ""+numOfMissed));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            
            CloseableHttpResponse servletResponse = client.execute(httpPost);
            client.close();
            
                    // add header
		
            /*
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet newRequest = new HttpGet("http://default-environment.bxypxxac43.ap-southeast-1.elasticbeanstalk.com/MedboxTimer?threshold="+threshold+"&numOfTakes="+numOfTakes+"&numOfMissed="+numOfMissed);
            try{
                HttpResponse thisResponse = client.execute(newRequest);
            }catch(ClientProtocolException e){
                e.printStackTrace();
            }
            */
            ArrayList<String> valueList = new ArrayList<>();
            valueList.add(patientId);
            valueList.add(thresholdNo);
            valueList.add(numDosage);
            valueList.add(numMissed);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("medbox.jsp");
            
            if(!patientId.equals(null) && !thresholdNo.equals(null) && !numDosage.equals(null) && !numMissed.equals(null) ){
                
                session.setAttribute("values", valueList);
//                session.setAttribute("medboxEventController", medboxEventController);

//                medboxEventController.startTimer();
//                String checkAlarm = medboxEventController.soundAlarm();
//                
//                SmsFactory smsFactory = userAccount.getSmsFactory();
//                Map<String, String> smsParams = new HashMap<String, String>();
//                smsParams.put("To", toPhone);
//                smsParams.put("From", TWILIO_NUMBER);
//                smsParams.put("Body", checkAlarm);
//                smsFactory.create(smsParams);
                
                //shifted this down
                response.sendRedirect("medbox_Submit.jsp");
                
                return;
            }else {
                request.setAttribute("error", "Invalid Input");
                dispatcher.forward(request, response);
            }
%>