package fr.maboite.demo.spring.boot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CroisiereServiceTest {

    @Test
    void contextBateauServiceTest() {
        //Arrange
         CroisiereServiceTest croisiereServiceTest = new CroisiereServiceTest();
        //Act
        System.out.println(croisiereServiceTest);
        //Assert
        Assertions.assertNotNull(croisiereServiceTest);
    }
}
