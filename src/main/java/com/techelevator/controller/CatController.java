package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.dao.JdbcCatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> getAllCards(){
        return catCardDao.list();
    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard getCatCard(@PathVariable int id){
        return catCardDao.get(id);

    }

    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public CatCard getRandomCatCard(){
        return new CatCard(catFactService.getFact(), catPicService.getPic());
    }

    @PostMapping(path = "/api/cards")
    public boolean postCatCard(CatCard catCard){
        return catCardDao.save(catCard);
    }

    @PostMapping(path = "/api/cards/{id}")
    public boolean updateCatCard(@PathVariable int id, @RequestBody CatCard catCard){
        return catCardDao.update(id, catCard);
    }

    @DeleteMapping(path = "/api/cards/{id}")
    public boolean deleteCatCard(@PathVariable int id, @RequestBody CatCard catCard){
        return catCardDao.delete(id);

    }



}
