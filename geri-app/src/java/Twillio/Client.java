/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Twillio;

import com.twilio.http.TwilioRestClient;
import com.twilio.base.Resource;

public class Client {
    private Credential credentials;
    private TwilioMessageCreator messageCreator;

    public Client() {
        this.credentials = new Credential();
        this.messageCreator = new TwilioMessageCreator(
                new TwilioRestClient.Builder(credentials.getAccountSid(), credentials.getAuthToken()).build()
        );
    }

    public Client(TwilioMessageCreator messageCreator, Credential credentials) {
        this.credentials = credentials;
        this.messageCreator = messageCreator;
    }

    public void sendMessage(String to, String message, String mediaUrl) {
        messageCreator.create(to, credentials.getPhoneNumber(), message, mediaUrl);
    }
}