package fr.maboite.demo.spring.boot.service;

import org.springframework.stereotype.Component;

import fr.maboite.demo.spring.boot.model.Example;

@Component
public class ExampleService {

    public ExampleService() {
        System.out.println("Création de ExampleService");
    }

    public void genereNom(Example example) {
        //Code très compliqué pour générer un nom
        if(example.getId() >10) {
            example.setNom("grandNom");
        }else {
            example.setNom("petitNom");
        }
    }

}