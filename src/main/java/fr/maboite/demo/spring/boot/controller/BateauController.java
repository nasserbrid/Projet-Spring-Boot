package fr.maboite.demo.spring.boot.controller;

import fr.maboite.demo.spring.boot.model.Bateau;
import fr.maboite.demo.spring.boot.service.BateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import fr.maboite.demo.spring.boot.service.BateauService;
@RestController
@RequestMapping("/bateaux")
public class BateauController {

    
    /**
     * Un contrôleur est un bean Spring : il est
     * dans le contexte, on peut donc lui injecter
     * d'autres beans Spring
     */
    @Autowired
    private BateauService bateauService;

    public BateauController() {
        System.out.println("Création de BateauController");

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
    public Bateau getBateauById(@PathVariable("id") Integer id) {
        System.out.println("Je dois récupérer le bateau avec l'id : " + id);
        Bateau bateau = new Bateau();
        bateau.setId(Long.valueOf(id));
        bateau.setNom("nom");
        bateauService.getBateau(Long.valueOf(id));

        return bateau;
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
    public Bateau saveBateau(@RequestBody Bateau bateau) {
        System.out.println("je sauvegarde : " + bateau);
        return bateau;
    }

    /**
     * DeleteMapping indique que les requêtes de type DELETE
     * vont être traitées par cette méthode. Ici, on
     * utilise la même syntaxe que pour GetMapping
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Bateau deleteBateauById(@PathVariable("id") Integer id) {
        System.out.println("Je supprime le bateau avec l'id :" + id);
        Bateau bateau = new Bateau();
        bateauService.deleteBateau(Long.valueOf(id));
        return bateau;
    }

    //Ici, on utilise RequestMapping pour configurer finement
    //quelles requêtes HTTP font que Spring Web appelle la méthode getSpecialById.
    @RequestMapping(path = "/special/{id}", method= {RequestMethod.GET, RequestMethod.DELETE},
            produces = {"application/json"})
    public Bateau getSpecialBateauById(@PathVariable("id") Integer id) {
        System.out.println("Je dois récupérer le bateau avec l'id : " + id);
        Bateau bateau = new Bateau();
        bateau.setId(Long.valueOf(id));
        bateau.setNom("nom");
        bateauService.deleteBateau(Long.valueOf(id));
       // bateauService.getBateau();
        bateauService.saveBateau(bateau);
        return bateau;
    }

}
