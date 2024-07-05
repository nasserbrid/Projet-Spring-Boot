package fr.maboite.demo.spring.boot.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.maboite.demo.spring.boot.model.Example;
import fr.maboite.demo.spring.boot.service.ExampleService;

/**
 * Contrôleur REST : gère
 * des requêtes HTTP avec des méthodes Java.
 * Ici, on gère toutes les requêtes dont l'URL
 * commence par /examples
 */
@RestController
@RequestMapping("/examples")
public class ExampleController {

    /**
     * Un contrôleur est un bean Spring : il est
     * dans le contexte, on peut donc lui injecter
     * d'autres beans Spring
     */
    @Autowired
    private ExampleService exampleService;

    public ExampleController() {
        System.out.println("Création de ExampleController");
    }

    /**
     * GetMapping indique que les requêtes de type GET
     * vont être traitées par cette méthode. Ici, on
     * indique le suffixe de l'URL : /{id} . les guillemets
     * servent à extraire de l'URL des variables : ce sont des
     * PathVariables pour Spring Web.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Example getById(@PathVariable("id") Integer id) {
        System.out.println("Je dois récupérer l'exemple avec l'id : " + id);
        Example example = new Example();
        example.setId(id);
        example.setDateCreation(LocalDateTime.now());
        exampleService.genereNom(example);
        return example;
    }

    /**
     * PostMapping indique que les requêtes de type POST
     * vont être traitées par cette méthode. L'annotation
     * @RequestBody demande à Spring de transformer le corps
     * de la requête HTTP en argument de la méthode (attention,
     * il faut que Spring puisse transformer correctement
     * le corps en objet Java).
     *
     * @param id
     * @return
     */
    @PostMapping
    public Example save(@RequestBody Example example) {
        System.out.println("je sauvegarde : " + example);
        return example;
    }

    /**
     * DeleteMapping indique que les requêtes de type DELETE
     * vont être traitées par cette méthode. Ici, on
     * utilise la même syntaxe que pour GetMapping
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        System.out.println("Je supprime l'exemple avec l'id :" + id);
    }

    //Ici, on utilise RequestMapping pour configurer finement
    //quelles requêtes HTTP font que Spring Web appelle la méthode getSpecialById.
    @RequestMapping(path = "/special/{id}", method= {RequestMethod.GET, RequestMethod.DELETE},
            produces = {"application/json"})
    public Example getSpecialById(@PathVariable("id") Integer id) {
        System.out.println("Je dois récupérer l'exemple avec l'id : " + id);
        Example example = new Example();
        example.setId(id);
        example.setNom("Nom spécial généré ici");
        example.setDateCreation(LocalDateTime.now());
        return example;
    }


}