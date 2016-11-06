/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.servlets;

import geriapp.controller.MedboxEventController;
import geriapp.entity.reading.Reading;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.factory.SmsFactory;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

/**
 *
 * @author muhammadims.2013
 */
@WebServlet(name = "MedboxTimerServlet", urlPatterns = {"/MedboxTimer"})
public class MedboxTimerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TimerStartThread</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimerStartThread at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //}
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int threshold = Integer.parseInt(request.getParameter("threshold"));
        int numOfTakes = Integer.parseInt(request.getParameter("numOfTakes"));
        int numOfMissed = Integer.parseInt(request.getParameter("numOfMissed"));
        
        
        String toPhone = "+6586568835";
        String TWILIO_ACCOUNT_SID = "ACec01a875b5cc448f2b2e903087059d29";
        String TWILIO_AUTH_TOKEN = "16f2063d70f35433fb14a141c308becf";
        String TWILIO_NUMBER = "+447481337150";
        TwilioRestClient twilioClient = new TwilioRestClient(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
        Account userAccount = twilioClient.getAccount();
        
        MedboxEventController medboxEventController = new MedboxEventController();
        int numOfReadings = medboxEventController.startTimer(threshold);
        
        //String checkAlarm = medboxEventController.soundAlarm();
        
        //System.out.println(checkAlarm);
        //if (numOfReadings < (numOfTakes - numOfMissed)) {
            
            try{
                SmsFactory smsFactory = userAccount.getSmsFactory();
                Map<String, String> smsParams = new HashMap<String, String>();
                smsParams.put("To", toPhone);
                smsParams.put("From", TWILIO_NUMBER);
                smsParams.put("Body", "Number of readings: "+numOfReadings);
                smsFactory.create(smsParams);
            }catch(TwilioRestException e){
                e.printStackTrace();
            }
            
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
