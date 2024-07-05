package fr.maboite.demo.spring.boot.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.maboite.demo.spring.boot.dao.CompanyDao;
import fr.maboite.demo.spring.boot.model.Company;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyDao companyDao;

    @PostMapping
    public Company save(@RequestBody Company company) {
        LOGGER.info("Sauvegarde de Company par le contrôleur");
        companyDao.save(company);
        return company;
    }

    @GetMapping("/{id}")
    public Company get(@PathVariable("id") Integer id) {
        LOGGER.info("Récupération de Company avec l'id : " + id);
        Optional<Company> companyOptional = companyDao.findById(id);
        if (companyOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No company found");
        } else {
            Company company = companyOptional.get();
            return company;
        }
        // La ligne ci-dessus est équivalente à l'algorithme ci-dessous :
        // Company company = companyDao.findById(id);
        // if(company == null) {
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No company found");
        // }else {
        // return company;
        // }

    }

}