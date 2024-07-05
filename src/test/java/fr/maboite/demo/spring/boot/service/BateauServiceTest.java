package fr.maboite.demo.spring.boot.service;

import fr.maboite.demo.spring.boot.model.Bateau;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BateauServiceTest {

    @Autowired
    private BateauService bateauService;


    @Test
    void contextBateauServiceTest() {
        //Arrange
        BateauService bateauService = new BateauService();
        //Act
        System.out.println(bateauService);
        //Assert
        Assertions.assertNotNull(bateauService);
    }

    @Test
    void contextBateauServiceSaveIdTest() {
        //Arrange
        Bateau bateau = new Bateau();
        //Act
        bateauService.saveBateau(bateau);
        //Assert
        Assertions.assertNotNull(bateauService.saveBateau(bateau));
    }


    @Test
    void contextBateauServiceDeleteIdTest() {
        //Arrange
        Bateau bateau = new Bateau();
        //Act
        bateauService.deleteBateau(bateau.getId());
        //Assert
       Assertions.assertNotNull(bateauService.deleteBateau(bateau.getId()));
    }


    @Test
    void contextBateauServiceGetIdTest() {
        //Arrange
        Bateau bateau = new Bateau ();
        //Act
       bateauService.getBateau(bateau.getId());
        //Assert
        Assertions.assertNotNull(bateauService.getBateau(bateau.getId()));
    }
}
