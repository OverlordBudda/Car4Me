/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car4me.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Budda
 */

@Entity
public class Kunde implements Serializable{
    
    @Id
    @GeneratedValue(generator = "customer_ids")
    @TableGenerator(name = "customer_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
    @Column(name = "VORNAME")
    @NotNull(message = "Der Vorname darf nicht leer sein.")
    private String vorname;
    
    @Column(name = "NACHNAME")
    @NotNull(message = "Der Nachname darf nicht leer sein.")
    private String nachname;
    
    @Column(name = "STRASSE")
    @NotNull(message = "Straße darf nicht leer sein.")
    private String strasse;
    
    @Column(name = "HAUSNUMMER")
    @NotNull(message = "Hausnummer darf nicht leer sein.")
    private String hausnummer;
    
    @Column(name = "PLZ")
    @Size(min = 5, max = 5, message = "Feld PLZ muss fünf lang sein.")
    @NotNull(message = "PLZ darf nicht leer sein.")
    private String plz;

    @Column(name = "ORT")
    @NotNull(message = "Ort darf nicht leer sein.")
    private String ort;
    
    @Column(name = "LAND")
    @NotNull(message = "Land darf nicht leer sein.")
    private String land;
    
    @OneToMany(mappedBy = "kunde", fetch = FetchType.LAZY)
    List<Leihvertrag> leihvertrage = new ArrayList<>();

    //<editor-fold defaultstate="collapsed" desc="SETTER und Getter">
    public long getId() {
        return id;
    }
    
    public String getVorname() {
        return vorname;
    }
    
    public String getNachname() {
        return nachname;
    }
    
    public String getStrasse() {
        return strasse;
    }
    
    public String getHausnummer() {
        return hausnummer;
    }
    
    public String getPlz() {
        return plz;
    }
    
    public String getOrt() {
        return ort;
    }
    
    public String getLand() {
        return land;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    
    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }
    
    public void setPlz(String plz) {
        this.plz = plz;
    }
    
    public void setOrt(String ort) {
        this.ort = ort;
    }
    
    public void setLand(String land) {
        this.land = land;
    }

    public List<Leihvertrag> getLeihvertrage() {
        return leihvertrage;
    }

    public void setLeihvertrage(List<Leihvertrag> leihvertrage) {
        this.leihvertrage = leihvertrage;
    }
    
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Kunde() {
    }
    
    public Kunde(String vorname, String nachname, String strasse, String hausnummer, String plz, String ort, String land) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
    }
//</editor-fold>
    
}
