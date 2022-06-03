package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {
RestTemplate restTemplate = new RestTemplate();

static String catPicUrl = "https://cat-data.netlify.app/api/pictures/random";
	@Override
	public CatPic getPic() {

		// TODO Auto-generated method stub
		return restTemplate.getForObject(catPicUrl, CatPic.class);
	}

}	
