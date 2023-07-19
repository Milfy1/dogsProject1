package com.udacity.bootstrap.controllers;

import com.udacity.bootstrap.services.CatFactsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catfact")
public class CatFactsController {
    private final CatFactsService catFactsService;

    public CatFactsController(CatFactsService catFactsService) {
        this.catFactsService = catFactsService;
    }

    @GetMapping()
    public String Getfact(){
        return catFactsService.GetCatFact();
    }
}
