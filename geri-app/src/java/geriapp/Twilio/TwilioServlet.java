/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.Twilio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.HashMap;

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
import com.google.common.collect.Lists;

import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;

/**
 *
 * @author AvinashDash
 */
public class TwilioServlet extends HttpServlet {

    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String phone = request.getParameter("From");
        String body = request.getParameter("Body");
        
        

        String output;

        try{
                output = processMessage(body);
            
        } catch (Exception e) {
            output = "We were unable to process your request!";
            e.printStackTrace();
        }

        try {
            MessagingResponse messagingResponse = new MessagingResponse.Builder()
                    .message(new Message.Builder().body(new Body(output)).build())
                    .build();

            response.setContentType("text/xml");

            response.getWriter().write(messagingResponse.toXml());
        } catch (TwiMLException e) {
            throw new RuntimeException(e);
        }
    }

    private String processMessage(String message){
        
        String output = "Caregiver: Jessica Bong, The command that you input is incorrect. Please input if you are\n1. Available 2. Unavailable";

        if (message.equals("1")) {
            return "Caregiver: Jessica Bong, you have confirmed that you will address\nissue 121: Patient [S123 - Tommy Tan] has not taken medication from 1000 - 1400 hrs";
        }else if(message.equals("2")){
            
            try{
                String toPhone = "+6586068378";
                String TWILIO_ACCOUNT_SID = "ACec01a875b5cc448f2b2e903087059d29";
                String TWILIO_AUTH_TOKEN = "16f2063d70f35433fb14a141c308becf";
                String TWILIO_NUMBER = "+447481337150";
                TwilioRestClient twilioClient = new TwilioRestClient(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
                Account userAccount = twilioClient.getAccount();

                SmsFactory smsFactory = userAccount.getSmsFactory();
                Map<String, String> smsParams = new HashMap<String, String>();
                smsParams.put("To", toPhone);
                smsParams.put("From", TWILIO_NUMBER);
                smsParams.put("Body", "Caregiver: Jessica Bong is unable to attend to\nissue121: Patient [S123 - Tommy Tan] has not taken medication from 1000 - 1400 hrs.\nCaregiver: Elizabeth Ong, Will you be able to attend in their place?");
                smsFactory.create(smsParams);
                return "Caregiver: Jessica Bong, you have confirmed that you will NOT be able to address\nissue121: Patient [S123 - Tommy Tan] has not taken medication from 1000 - 1400 hrs. \nIssue Escalated";
            }catch(TwilioRestException e){
                e.printStackTrace();
                return "Twilio Rest Exception";
            }
            
            
        }else{
            return output;
        }
        
        
    }

}