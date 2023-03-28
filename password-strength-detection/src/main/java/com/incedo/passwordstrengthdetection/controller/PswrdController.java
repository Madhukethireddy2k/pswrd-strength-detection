package com.incedo.passwordstrengthdetection.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.incedo.passwordstrengthdetection.service.PswrdService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class PswrdController {
	
	@Autowired
	private PswrdService pswrdService;
	
	@PostMapping("/pswrdstrength")
	public String getStrength(@RequestBody String pswrd ) {
		return pswrdService.passwordStrengthDetector(pswrd);
	}

}
