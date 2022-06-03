package com.techelevator.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component


public class RestCatFactService implements CatFactService {
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatFact getFact( ) {
		ResponseEntity response = restTemplate.getForEntity(
				"https://cat-data.netlify.app/api/facts/random",
				String.class); // Make GET request using client
		CatFact catFact = new CatFact();
		catFact.setText(response.getBody().toString());
		// TODO Auto-generated method stub
		return catFact;
	}

}
