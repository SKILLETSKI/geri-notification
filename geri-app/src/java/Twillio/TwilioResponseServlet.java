/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Twillio;

/**
 *
 * @author AvinashDash
 */

import Twilio.*;
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
        /*
            The next 2 lines need to be replaced by a query to match the phone number of the incoming
            message to the list of users' phone numbers
        */
     
        HashMap<String, String> groupMembers = new HashMap<>(); //Populate with group members' details
        groupMembers.put("+6586568835", "Dash");
        
        String fromNumber = request.getParameter("From"); //This gets the number which the message was received from
        String isGroupMember = groupMembers.get(fromNumber); //Needs to be replaced by a code to verify the user 
        String message;
        if (isGroupMember == null) {
            
            //Need to add in logic to verify what message is being responded to
            message = "We have received your request";
        } else {
            // Use the caller's name
            message = "Sorry, we do not recognize your phone number";
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