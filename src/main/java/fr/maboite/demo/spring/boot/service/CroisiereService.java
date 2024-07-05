package fr.maboite.demo.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CroisiereService {

    public CroisiereService() {
        System.out.println("Je suis XXXService, et je suis instancié");
    }

    @Autowired
    private BateauService bateauService;

    public BateauService getBateauService() {
        return bateauService;
    }

    public void setBateauService(BateauService bateauService) {
        this.bateauService = bateauService;
    }



}
