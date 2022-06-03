package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.dao.JdbcCatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/cards")
public class CatController {
    @Autowired
    private CatCardDao catCardDao;
    @Autowired
    private CatFactService catFactService;
    @Autowired
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @GetMapping
    public List<CatCard> getAllCards(){
        return catCardDao.list();
    }

    @GetMapping("/{id}")
    public CatCard getCatCard(@PathVariable int id) throws CatCardNotFoundException {
        return catCardDao.get(id);

    }

    @GetMapping("/random")
    public CatCard getRandomCatCard(){
        return new CatCard(catFactService.getFact(), catPicService.getPic());
    }

    @PostMapping("/cards")
    public boolean postCatCard(CatCard catCard){
        return catCardDao.save(catCard);
    }


    @PutMapping("/{id}")
    public boolean updateCatCard(@Valid @PathVariable int id , CatCard catCard) throws CatCardNotFoundException{
        return catCardDao.update(id, catCard);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCatCard(@PathVariable int id, @RequestBody CatCard catCard){
        return catCardDao.delete(id);

    }



}
