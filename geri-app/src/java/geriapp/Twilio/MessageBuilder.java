/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.Twilio;



import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

public class MessageBuilder {
    private TwilioRestClient client = null;

    public MessageBuilder(TwilioRestClient client) {
        this.client = client;
    }

    public Message create(String to, String from, String body) {
        MessageCreator messageCreator = new MessageCreator(
                new PhoneNumber(to),
                new PhoneNumber(from),
                body);
        

        return messageCreator.create(this.client);
    }
}