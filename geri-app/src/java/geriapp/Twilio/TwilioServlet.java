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

        try {
            
            if (phone != "+6586568835") {
                output = "You are not a registered respondent to this service";
            } else {
                output = processMessage(body);
            }
        } catch (Exception e) {
            output = "Something went wrong. Try again.";
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

    private String processMessage(String message) {
        String output = "The command that you input is incorrect. Please input 1. I will address the issue 2. I will not be able to address the issue";

        if (message == "1") {
            output = "You have confirmed that you will address the issue";
        }else if(message == "2"){
            output = "You have confirmed that you will not be able to address the issue";
        }
        return output;
    }

}