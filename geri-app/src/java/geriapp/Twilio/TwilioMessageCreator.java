package geriapp.Twilio;

import java.util.HashMap;
import java.util.Map;


import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

public class TwilioMessageCreator {

    
    public static String TWILIO_ACCOUNT_SID = "ACec01a875b5cc448f2b2e903087059d29";
    public static String TWILIO_AUTH_TOKEN = "16f2063d70f35433fb14a141c308becf";
    public static String TWILIO_NUMBER = "+447481337150";

    // create an authenticated REST client
    public static TwilioRestClient twilioClient = new TwilioRestClient(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
    public static Account userAccount = twilioClient.getAccount();
  
    
    // Handle a POST request to send a text message
    public static void message(String body) throws TwilioRestException {
    	
    	String toPhone = "+6586568835";
        
    	SmsFactory smsFactory = userAccount.getSmsFactory();
        Map<String, String> smsParams = new HashMap<String, String>();
        smsParams.put("To", toPhone);
        smsParams.put("From", TWILIO_NUMBER);
        smsParams.put("Body", body);
        smsFactory.create(smsParams);
    }
  
}
