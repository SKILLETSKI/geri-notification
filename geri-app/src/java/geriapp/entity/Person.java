/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.entity;

/**
 *
 * @author AvinashDash
 */

public class Person {
    
    String userName;
    String password;
    String Name;
    
    public Person(){
        this.userName = "";
        this.password = "";
        this.Name = "";
    }
    
    public Person(String userName, String password, String Name){
        this.userName = userName;
        this.password = password;
        this.Name = Name;
    }
    
    public String getName(){
        return this.Name;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    
    public void setPassword(String password){
        this.password = password;
    }       
    
}
