package fr.maboite.demo.spring.boot.dao;

import fr.maboite.demo.spring.boot.model.Bateau;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BateauDao extends CrudRepository<Bateau, Long> {

}
