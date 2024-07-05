package fr.maboite.demo.spring.boot.service;

import fr.maboite.demo.spring.boot.model.Bateau;
import org.springframework.stereotype.Component;

@Component
public class BateauService {

    public BateauService() {
        System.out.println("Je suis XXXService, et je suis instancié");
    }


    public Bateau saveBateau(Bateau bateau){
        System.out.println("j'enregistre l'Id d'un bateau");
        return bateau;
    }

    public Bateau deleteBateau(Long id){
        System.out.println("je supprime l'Id d'un bateau");

        return new Bateau();

    }

    public Bateau getBateau(Long id){
        System.out.println("je recupère l'Id d'un bateau");

        return new Bateau();
    }

}
