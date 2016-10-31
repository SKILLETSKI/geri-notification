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


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Administrator {

@SerializedName("name")
@Expose
private String name;
@SerializedName("phoneNumber")
@Expose
private String phoneNumber;

/**
* 
* @return
* The name
*/
public String getName() {
return name;
}

/**
* 
* @param name
* The name
*/
public void setName(String name) {
this.name = name;
}

/**
* 
* @return
* The phoneNumber
*/
public String getPhoneNumber() {
return phoneNumber;
}

/**
* 
* @param phoneNumber
* The phoneNumber
*/
public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

}