package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {
RestTemplate restTemplate = new RestTemplate();
	@Override
	public CatPic getPic() {
		ResponseEntity response = restTemplate.getForEntity(
				"https://cat-data.netlify.app/api/pictures/random",
				String.class); // Make GET request using client
		CatPic catPic = new CatPic();
		catPic.setFile(response.getBody().toString());
		// TODO Auto-generated method stub
		return catPic;
	}

}	
