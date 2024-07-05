package fr.maboite.demo.spring.boot.dao;

import fr.maboite.demo.spring.boot.model.Bateau;
import fr.maboite.demo.spring.boot.model.Croisiere;
import fr.maboite.demo.spring.boot.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CroisiereDao extends CrudRepository<Croisiere, Long> {

    public List<Croisiere> getByPortDepart(String portDepart);

}
