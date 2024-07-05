package fr.maboite.demo.spring.boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Bateau")
public class Bateau {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    private Integer capacite;

    @ManyToOne
    @JoinColumn(name = "CROISIERE_ID")
    private Croisiere croisiere;


    public Bateau() {
        System.out.println("Je suis la classe Bateau");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Croisiere getCroisiere() {
        return croisiere;
    }

    public void setCroisiere(Croisiere croisiere) {
        this.croisiere = croisiere;
    }
}
