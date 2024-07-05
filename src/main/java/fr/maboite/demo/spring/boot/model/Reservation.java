package fr.maboite.demo.spring.boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "CROISIERE_ID")
    private Croisiere croisiere;


    public Reservation() {
        System.out.println("Je suis la classe Reservation");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
