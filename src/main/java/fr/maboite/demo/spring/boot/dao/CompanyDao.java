package fr.maboite.demo.spring.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.maboite.demo.spring.boot.model.Company;

@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query("select c from Company c where c.name = :companyNameParam")
    public List<Company> getCompanyParNom(@Param("companyNameParam") String companyName);

    @Query("select c from Company c where c.cash > 10000")
    public List<Company> getCompaniesDontCashSuperieur10_000();

    public List<Company> getCompanyByName(String name);

    public List<Company> getCompanyByNameAndCash(String name, Integer cash);

}