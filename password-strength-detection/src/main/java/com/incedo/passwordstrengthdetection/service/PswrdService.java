package com.incedo.passwordstrengthdetection.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PswrdService {
	
	private static final Logger log= LoggerFactory.getLogger(PswrdService.class);
	
	public String passwordStrengthDetector(String password) {
		
		int strength = 0;
        
        if( password.length() < 8 )
            strength=0;
        else if( password.length() >= 10 )
            {strength += 2;}
        else {strength += 1;}
        
        //if password contains one digit, add 2 to strength
        if( password.matches("(?=.*[0-9]).*") )
        { strength += 2; }
        
        //if password contains one lower case letter, add 2 to strength
        if( password.matches("(?=.*[a-z]).*") )
        { strength += 2;}
        
        //if password contains one upper case letter, add 2 to strength
        if( password.matches("(?=.*[A-Z]).*") )
        { strength += 2;}    
        
        //if password contains one special character, add 2 to strength
        if( password.matches("(?=.*[~!@#$%^&*()_-]).*") )
            {strength += 2;}

		
		if (strength == 10) {
			return "Very Strong";
		} else if (strength == 9) {
			return "Strong";
		} else if (strength == 8) {
			return "Moderate";
		}
		else {
			return "Weak";
		}
		 
		 
	}

}
