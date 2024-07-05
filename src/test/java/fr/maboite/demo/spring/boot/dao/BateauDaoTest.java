package fr.maboite.demo.spring.boot.dao;

import fr.maboite.demo.spring.boot.model.Bateau;
import fr.maboite.demo.spring.boot.model.Croisiere;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BateauDaoTest {

    @Autowired
    private BateauDao bateauDao;

    @Autowired
    private CroisiereDao croisiereDao;

    @Test
    public void testSave(){
        //Arrange

        Bateau bateau = new Bateau();
        bateau.setNom("Oro Jackson");
        //Act
        Bateau savedBateau = bateauDao.save(bateau);
        //Assert
        Assertions.assertNotNull(savedBateau);
        Assertions.assertNotNull(savedBateau.getId());
        Assertions.assertEquals("Oro Jackson", savedBateau.getNom());
    }

    @Test
    public void testSaveWithCroisiere() {
        //ARRANGE
        //Création de company
        Bateau bateau = new Bateau();
        bateau.setNom("Sunny 2");

        //Création de croisère
        Croisiere croisiere = new Croisiere();
        croisiere.setPortDepart("Red port");
        Croisiere savedCroisiere = croisiereDao.save(croisiere);

        //Rattachement des deux objets
        bateau.setCroisiere(savedCroisiere);

        //ACT
        Bateau savedBateau = bateauDao.save(bateau);

        //ASSERT
        Assertions.assertNotNull(bateau.getCroisiere());
    }
}
