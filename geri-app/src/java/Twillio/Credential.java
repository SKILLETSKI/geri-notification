/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Twillio;

/**
 *
 * @author CAG
 */
public class Credential {
    private Administrator admin = new Administrator();
    private final String AccountSid = "ACec01a875b5cc448f2b2e903087059d29";
    private final String AuthToken = "16f2063d70f35433fb14a141c308becf";
    private final String PhoneNumber = admin.getPhoneNumber();
    
    public String getAccountSid(){
        return this.AccountSid;
    }
    
    public String getAuthToken(){
        return this.AuthToken;
    }
    
    public String getPhoneNumber(){
        return this.PhoneNumber;
    }
}
