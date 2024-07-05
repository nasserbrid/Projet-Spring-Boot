package fr.maboite.demo.spring.boot.dao;


import fr.maboite.demo.spring.boot.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDao extends CrudRepository<Reservation, Long> {

//    @Query("select r from Reservation r where r.nom = :reservationNomParam")
//    public List<Reservation> getReservationParNom(@Param("reservationNomParam") String reservationNom);

    //    @Query("select r from Reservation r
    //    where r.nom = :reservationNomParam"
    //    AND r.prenom = :reservationPrenomParam)
//    public List<Reservation> getReservationParNomEtPrenom(@Param("reservationNomParam", "reservationPrenomParam") String reservationNom, String reservationPrenom);

    public List<Reservation> getReservationByNom(String nom);

    public List<Reservation> getReservationByNomAndPrenom(String nom, String prenom);

    public List<Reservation> getReservationByNomAndPrenomAllIgnoreCase(String nom, String prenom);





}
