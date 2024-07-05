package fr.maboite.demo.spring.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.maboite.demo.spring.boot.model.CompanyType;

@Repository
public interface CompanyTypeDao extends CrudRepository<CompanyType, Integer> {

    @Query("select ct from CompanyType ct "
            + " left outer join ct.companies "
            + " where ct.name  = :nameParam ")
    public List<CompanyType> getCompanyTypeParNom(@Param("nameParam") String name);


}