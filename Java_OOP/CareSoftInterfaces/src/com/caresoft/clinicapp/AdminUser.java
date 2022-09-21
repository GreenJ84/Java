package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
	
	public AdminUser(Integer id, String role) {
		this.employeeID = id;
		this.role = role;
	}

	@Override
	public boolean assignPin(int pin) {
		if (Integer.toString(pin).length() != 6) {
			return false;
		}
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.employeeID == confirmedAuthID) {
			return true;
		} else {
			authIncident();
			return false;
		}
	}


	
	public void newIncident(String notes) {
        String report = String.format(
            "(Datetime Submitted: %s \n,  Reported By ID: %s\n, Notes: %s) \n", 
            new Date(), this.employeeID, notes
        );
        securityIncidents.add(report);
    }
	
	
    public void authIncident() {
        String report = String.format(
            "(Datetime Submitted: %s \n  ID: %s\n Notes: %s) \n", 
            new Date(), this.employeeID, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}
	
}
