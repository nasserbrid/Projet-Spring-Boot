package fr.maboite.demo.spring.boot.controller;

import fr.maboite.demo.spring.boot.dao.BateauDao;
import fr.maboite.demo.spring.boot.model.Bateau;
import fr.maboite.demo.spring.boot.model.Company;
import fr.maboite.demo.spring.boot.service.BateauService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import fr.maboite.demo.spring.boot.service.BateauService;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/bateaux2")
public class BateauController2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(BateauController2.class);

    /**
     * Un contrôleur est un bean Spring : il est
     * dans le contexte, on peut donc lui injecter
     * d'autres beans Spring
     */
    @Autowired
    private BateauDao bateauDao; ;


    @PostMapping
    public Bateau save(@RequestBody Bateau bateau) {
        LOGGER.info("Sauvegarde du Bateau par le contrôleur");
        bateauDao.save(bateau);
        return bateau;
    }

    @GetMapping("/{id}")
    public Bateau getBateauById(@PathVariable("id")Long id) {
        LOGGER.info("Récupération de Bateau avec l'id : " + id);
        Optional<Bateau> bateauOptional = bateauDao.findById(id);
        if (bateauOptional.isPresent()) {
            return bateauOptional.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No bateau found");
        }
    }



    @DeleteMapping("/{id}")
    public void deleteBateauById(@PathVariable("id")Long id) {
        LOGGER.info("Suppression de Bateau " + id);
       bateauDao.deleteById(id);
    }

}
