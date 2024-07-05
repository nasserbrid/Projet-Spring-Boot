package fr.maboite.demo.spring.boot.dao;

import fr.maboite.demo.spring.boot.model.Bateau;
import fr.maboite.demo.spring.boot.model.Company;
import fr.maboite.demo.spring.boot.model.Reservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReservationDaoTest {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private CroisiereDao croisiereDao;

    @Test
    public void testSave(){
        //Arrange
        Reservation reservation = new Reservation();
        reservation.setNom("Mashle");
        //Act
        Reservation savedReservation = reservationDao.save(reservation);
        //Assert
        Assertions.assertNotNull(savedReservation);
        Assertions.assertNotNull(savedReservation.getId());
        Assertions.assertEquals("Mashle", savedReservation.getNom());
    }

    @Test
    public void testgetReservationByNom() {
        //ARRANGE
        Reservation reservation = new Reservation();
        reservation.setNom("Luffy");
        Reservation savedReservation = reservationDao.save(reservation);
        //ACT
        List<Reservation> reservations = reservationDao.getReservationByNom("Luffy");
        //ASSERT
        Assertions.assertEquals(1, reservations.size());
        Reservation loadedReservation = reservations.get(0);
        Assertions.assertEquals("Luffy", loadedReservation.getNom());
    }


    @Test
    public void testgetReservationByNomAndPrenom() {
        //ARRANGE
        Reservation reservation = new Reservation();
        reservation.setNom("Luffy");
        reservation.setPrenom("Monkey");
        Reservation savedReservation = reservationDao.save(reservation);
        //ACT
        List<Reservation> reservations = reservationDao.getReservationByNomAndPrenom("Luffy", "Monkey");
        //ASSERT
        Assertions.assertEquals(1, reservations.size());
        Reservation loadedReservation = reservations.get(0);
        Assertions.assertEquals("Luffy", loadedReservation.getNom());
        Assertions.assertEquals("Monkey", loadedReservation.getPrenom());
    }

    @Test
    public void testgetReservationByNomAndPrenomAllIgnoreCase() {
        //ARRANGE
        Reservation reservation = new Reservation();
        reservation.setNom("Akira");
        reservation.setPrenom("Toriyama");
        Reservation savedReservation = reservationDao.save(reservation);
        //ACT
        List<Reservation> reservations = reservationDao.getReservationByNomAndPrenomAllIgnoreCase("akira", "toriyama");
        //ASSERT
        Assertions.assertEquals(1, reservations.size());
        Reservation loadedReservation = reservations.get(0);
        Assertions.assertEquals("Akira", loadedReservation.getNom());
        Assertions.assertEquals("Toriyama", loadedReservation.getPrenom());
    }


}
