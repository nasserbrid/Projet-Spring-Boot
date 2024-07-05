package fr.maboite.demo.spring.boot.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.maboite.demo.spring.boot.model.Company;
import fr.maboite.demo.spring.boot.model.CompanyType;
import fr.maboite.demo.spring.boot.model.Status;

import java.util.List;

@SpringBootTest
public class CompanyDaoTest {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private CompanyTypeDao companyTypeDao;

    @Test
    public void testSave() {
        //ARRANGE
        Company company = new  Company();
        company.setName("Ma société");
        company.setStatus(Status.OPENED);
        //ACT
        Company savedCompany = companyDao.save(company);
        //ASSERT
        Assertions.assertNotNull(savedCompany);
        Assertions.assertNotNull(savedCompany.getId());
        Assertions.assertEquals("Ma société", savedCompany.getName());
    }

    @Test
    public void testSaveWithCompanyType() {
        //ARRANGE
        //Création de company
        Company company = new  Company();
        company.setName("Ma société reliée à un Company Type");
        company.setStatus(Status.OPENED);

        //Création de companyType
        CompanyType companyType = new  CompanyType();
        companyType.setName("Mon type d'entreprise");
        CompanyType savedCompanyType = companyTypeDao.save(companyType);

        //Rattachement des deux objets
        company.setCompanyType(savedCompanyType);

        //ACT
        Company savedCompany = companyDao.save(company);

        //ASSERT
        Assertions.assertNotNull(savedCompany.getCompanyType());

    }

    @Test
    public void testGetCompaniesParNameEgalMonEntreprise() {
        //ARRANGE
        Company company = new  Company();
        company.setName("Mon entreprise");
        Company savedCompany = companyDao.save(company);
        //ACT
        List<Company> companies = companyDao.getCompanyByName("Mon entreprise");
        //ASSERT
        Assertions.assertEquals(1, companies.size());
        Company loadedCompany = companies.get(0);
        Assertions.assertEquals("Mon entreprise", loadedCompany.getName());
    }


}