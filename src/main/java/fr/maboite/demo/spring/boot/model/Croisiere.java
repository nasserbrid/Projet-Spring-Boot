package fr.maboite.demo.spring.boot.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Croisiere")
public class Croisiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateDepart;
    private LocalDateTime dateArrive;
    private String portDepart;
    private String portArrive;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID")
    private  Reservation reservation;

    @OneToMany(mappedBy = "croisiere")
    private Set<Bateau> bateaux = new HashSet<>();


    @OneToMany(mappedBy = "croisiere")
    private Set<Reservation> reservations = new HashSet<>();

    public Croisiere() {
        System.out.println("Je suis la classe croisière");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDateTime dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalDateTime getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(LocalDateTime dateArrive) {
        this.dateArrive = dateArrive;
    }

    public String getPortDepart() {
        return portDepart;
    }

    public void setPortDepart(String portDepart) {
        this.portDepart = portDepart;
    }

    public String getPortArrive() {
        return portArrive;
    }

    public void setPortArrive(String portArrive) {
        this.portArrive = portArrive;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Set<Bateau> getBateaux() {
        return bateaux;
    }

    public void setBateaux(Set<Bateau> bateaux) {
        this.bateaux = bateaux;
    }
}
