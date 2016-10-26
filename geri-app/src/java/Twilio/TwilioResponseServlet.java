/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Twilio;

/**
 *
 * @author AvinashDash
 */

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;

public class TwilioResponseServlet extends HttpServlet {

    // service() responds to both GET and POST requests.
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Create a dict of people we know.
        HashMap<String, String> callers = new HashMap<>();
        callers.put("+6586568835", "Dash");

        String fromNumber = request.getParameter("From"); //This gets the number which the message was received from
        String knownCaller = callers.get(fromNumber);
        String message;
        if (knownCaller == null) {
            // Use a generic message
            message = "Monkey, thanks for the message!";
        } else {
            // Use the caller's name
            message = knownCaller + ", thanks for the message!";
        }

        MessagingResponse twiml = new MessagingResponse.Builder()
                .message(new Message.Builder().body(new Body(message)).build())
                .build();

        response.setContentType("application/xml");
        try {
            response.getWriter().print(twiml.toXml());
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
    }
}