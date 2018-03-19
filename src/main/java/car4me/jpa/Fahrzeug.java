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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


/**
 *
 * @author Budda
 */

@Entity
public class Fahrzeug implements Serializable{
    
    @Id
    @GeneratedValue(generator = "car_ids")
    private Long id;
    
    @Column(name = "HERSTELLER")
    @NotNull(message = "Der Hersteller darf nicht leer sein.")
    private String hersteller="";
    
    @Column(name = "MODELL")
    @NotNull(message = "Das Modell darf nicht leer sein.")
    private String modell="";
    
    @Column(name = "BAUJAHR")
    @NotNull(message = "Das Baujahr darf nicht leer sein.")
    private String baujahr="";
    
    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getHersteller() {
        return hersteller;
    }
    
    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    
    public String getModell() {
        return modell;
    }
    
    public void setModell(String modell) {
        this.modell = modell;
    }
    
    public String getBaujahr() {
        return baujahr;
    }
    
    public void setBaujahr(String baujahr) {
        this.baujahr = baujahr;
    }

 
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Fahrzeug() {
    }
    
    public Fahrzeug(String hersteller, String modell, String baujahr) {
        this.hersteller = hersteller;
        this.modell = modell;
        this.baujahr = baujahr;
    }
//</editor-fold>
    
}
