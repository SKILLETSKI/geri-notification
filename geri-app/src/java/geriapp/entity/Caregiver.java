package geriapp.entity;

import java.util.HashMap;

public class Caregiver {
    
	private String caregiverNRIC;
	private String password;
	private String phone;
	private String address;
	private String name;
	private String photo;
	private int escalationLevel;
	private HashMap<String,String> relationship;
	
	public Caregiver(String NRIC,String phone,String name, String password, String photo, String address, int escalationLevel, HashMap<String,String> relationship) {
		this.caregiverNRIC = NRIC;
		this.phone = phone;
		this.address = address;
		this.photo = photo;
		this.name = name;
		this.password = password;
		this.escalationLevel = escalationLevel;
	}
	
	public Caregiver(String NRIC, String phone, String address, String name, String photo){
		this.caregiverNRIC = NRIC;
		this.phone = phone;
		this.name = name;
                this.address = address;
                this.photo = photo;
                this.escalationLevel = 0;
                this.relationship = new HashMap<String,String>();
	}
        
	public String getNRIC() {
		return caregiverNRIC;
	}
	public void setNRIC(String NRIC) {
		this.caregiverNRIC = NRIC;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public int getEscalationLevel(){
		return escalationLevel;
	}
	public void setEscalationLevel(int escalationLevel){
		this.escalationLevel = escalationLevel;
	}
	public HashMap<String,String> getRelationship(){
		return relationship;
	}
	public void addRelationship(String relationship, String patientNRIC){
		this.relationship.put(patientNRIC, relationship);
	}
	
}
